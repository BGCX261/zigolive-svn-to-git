<?php
require_once 'Log.php';
require_once 'lib/ezpdo.1.1.6/ezpdo_runtime.php';
require_once("lib/phpgacl/gacl.class.php");

class Application {

	public static $instance;	
	public $logger;
	public $gacl_config = array();
	private $request;
	function __construct(){
		$this->instance = $this;
		$this->loadSettings();
		spl_autoload_register(array($this, 'autoLoader'));
		$this->initPersistance();
		//echo strpos("coreBla","_");
		//$a = new models_Bla();
		
	}
	function autoLoader($className) {
		
		$underscorePos = strpos($className, "_");
		//echo $className."<br>";
		if($underscorePos){
			$pre = substr($className, 0,$underscorePos);
			$post = substr($className, $underscorePos+1);
			foreach($this->config['AutoClassLoading']['folder'] as $folder):
				//echo $folder;
				if($folder == $pre){
					//echo "Looking for class ".$post." in ".$pre;
					include($pre."/".$post.".php");
					eval("class ${className} extends ".$post."{}");		
					return;
				}
			endforeach;
		} else {
			$found = false; 
			foreach($this->config['AutoClassLoading']['folder'] as $folder):
				$filename = $folder . "/" . strtolower($className) . '.php';
				if(file_exists($filename)){
					if($found){
						die("It seems that the class ".$className." appears multiple times on the class path.\nUse the namespace opperator(_) to indicate where to load the class from");
					} else {
						$found = true;
						include_once($filename);
					}
				}
			endforeach;
			
		}
	}
	function loadSettings(){
		$this->config = parse_ini_file("conf/framework.ini", true);
	}
	function initPersistance(){
		
		$m = epManager::instance();
		$m->setConfigOption("compiled_dir", "" . $this->config['Paths']['cache'].$this->config['Models']['cached']);
		$m->setConfigOption("source_dirs", "" . $this->config['Models']['folder']);
		$m->setConfigOption("log_file", "" . $this->config['Paths']['logs'] . "ezpdo.log");
		foreach($this->config['Persistance'] as $k=>$v):
			$m->setConfigOption($k, $v);
		endforeach;
		$this->db = $m;	
	}
	
	
	
	
	function onRequest(){


		session_start();
		session_register("count");
		if(!isset($_SESSION['user'])){
			$_SESSION['user']['name'] = "annon";
			$_SESSION['user']['group'] = "user";
		}

		$path = $_SERVER["PHP_SELF"];
		$me = $_SERVER['SCRIPT_NAME'];
		//$posQS = strpos($path,"?");
		$qstring = $_SERVER["QUERY_STRING"];
		//$path = $url;
		// Now, remove trailing slash to path, it is no longer  needed
		$posSlash = strrpos($path, "/");
		if($posSlash == strlen($path)-1 && strlen($path)>1){
			$path = substr($path, 0,$posSlash);
		}
		if($path == $this->config['Paths']['root'] || $path == $me)
		{	// This is the typical initial website request http://host.com/
			// Get the default controller
			$obj = $this->getController($this->config['Controllers']['defaultController']);
			$req = new Request($this->config['Controllers']['defaultController'],$obj->defaultAction, array(), $qstring, $path);
			return $this->callRequest($obj,$req);
			
		}
		// Now Check to see if there is anything trailing in the url
		if(strpos($path,"/")==0) $path = substr($path, 1);
		$parts = explode("/",$path);
		$controller = $this->getController($parts[1]);
		//print_r($parts);
		if(count($parts)==2){	// Call Default
			$req = new Request($parts[1],$controller->defaultAction, array(), $qstring, $path);
			return $this->callRequest($controller,$req);
			
		}
		if(count($parts)==3){ // Call specified action
			$req = new Request($parts[1],$parts[2], array(), $qstring, $path);
			return $this->callRequest($controller,$req);
		}
		if(count($parts)>3){ // Their are arguments specified
			$req = new Request($parts[1],$parts[2], array_slice($parts, 3), $qstring, $path);
			return $this->callRequest($controller,$req);

		}	
	}


	
	public function getController($name){
		$className = ucfirst($name);
		$obj = eval("return new ".$className."();");
		$obj->application = $this;
		$obj->db = $this->db;
		$gacl = new gacl(array());
		$obj->application->gacl = $gacl;
		$obj->gacl = $gacl; 
		return $obj;
	}

	public function callRequest($obj, $req){
		BBLog::notice("Calling request: ".$req->controller."->".$req->action);	
		$obj->request = $req;
		$action = $req->action;
		//echo $action;
		return $obj->$action();
	}
	public function callController($name, $req){
		$obj = $this->getController($name);
		return callRequest($obj, $req);
	}
}


?>