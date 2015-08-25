<?php

class Controller
{
	public $defaultAction = "index";
 
	function render($view, $data, $rendererClass = "PHP") {
		$rendererClassName = $rendererClass."_Renderer";
		$renderer = new $rendererClassName($view, $this->application);
		return $renderer->fetch($data);
	}
}

class PHP_Renderer
{
	private $view;
	private $app;
	
	function __construct($v, $a){
		$this->view = $v;
		$this->app = $a;
	}	
	function fetch($data)
	{
		include_once($this->app->config['Views']['folder'].$this->view.".php");
	}
}
class SMARTY_Renderer
{
	private $view;
	private $app;
	
	function __construct($v, $a){
		$this->view = $v;
		$this->app = $a;
	}	
	function fetch($data)
	{
		include_once("lib/smarty/Smarty.class.php");
		// Initiallise smarty defaults;
		$s = new Smarty();
	
        $s->template_dir = $this->app->config['Views']['folder'];
        $s->compile_dir  = $this->app->config['Paths']['cache'].$this->app->config['Views']['cached'];
        $s->config_dir   = 'conf/';
        $s->cache_dir    = $this->app->config['Paths']['cache'];
		$s->plugins_dir[0]  = "c:\\tim_jboss\\seam_workbench\\BarBottin\\lib\\smarty\\plugins\\";
		$s->plugins_dir[1]  = "core/plugins/";
        $s->caching = false;
		//$s->load_filter("pre", "form");
        $s->assign($data);
			
		return $s->fetch($this->view.".php");
	}
}

?>