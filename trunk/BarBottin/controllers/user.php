<?php
/*
 * Created on 8 Sep 2007
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */
 
 class User extends Controller
 {
 	
 	public $defaultAction = "index";
 	function index(){
 		
 		
 	}
 	
 	function login(){
 		$this->render("user/login", array(), "SMARTY");
 	}
 	function logout(){
 		//$this->render("user/login", array(), "SMARTY");
 		session_destroy();
 	}
 	function logon(){
 		// Actually do the logon
 		$userName = $_POST['name'];
 		$password = $_POST['password'];
 		$users = $this->application->db->query("From UserModel as user where user.name='".$userName."' and user.password='".$password."'");
 		if(count($users)>0){
 			$_SESSION['user'] = $users[0];
 			// Logon ok
 			echo "Logon OK";
 		}else {
 			// Logon Error
 			echo "Logon Error";
 		}
 	}
 	
 	function listUsers(){
 		$data['users'] = $this->application->db->get("UserModel");
 		$this->render("user/list", $data, "SMARTY");
 	}
 	function edit(){
 		$userName = trim($this->request->args[0]);
 		$o = $this->application->db->create("UserModel");
 		$o->name = $userName;
 		$users = $this->application->db->find($o);
 		$data['user'] = $users[0];
  		$this->render("user/edit", $data, "SMARTY");
 	}
  	function saveedit(){
 		$userName = $_POST['name'];
 		$users = $this->application->db->query("from UserModel as user where user.name = '".$userName."'");
 		$user = $users[0];
 		$user->email = $_POST['email'];
 		$user->password = $_POST['password'];
 		$this->render("user/modified", array('user'=>$userName), "SMARTY");
 	}	
 	function saveUser()
 	{
 		//print_r($_POST);
 		// First check if the user exists already
 		$user = $this->application->db->query("From UserModel as user where user.name='".$_POST['name']."'");
 		if(!$user){
 			// The user doesn't exist
 			$user = $this->application->db->create("UserModel");
 			$user->name = $_POST['name'];
 			$user->password = $_POST['password'];
 			$user->email = $_POST['email'];
 			$this->application->db->commit($user);
 			$data['user'] = $user;
 			// Now a new acl request object must be created
 			// The ARO must have the same name as the user
 			require_once("lib/phpgacl/gacl_api.class.php");
 			$api = new gacl_api(array());
 			$gid = $api->get_group_id("users");
 			$res = $api->add_object("user", $user->name, $user->name, 0, 0, "ARO");
 			$res = $api->add_group_object($gid, "user", $user->name, "ARO");
 			$this->render("user/created", $data, "SMARTY");
 		} else {
 			$data['user'] = $_POST;
 			$data['user']['password'] = "";
 			$data['info'] = "The user name is already used";
 			$this->render("user/register", $data, "SMARTY");
 		}
 	}
 	
 	
 	function remove(){
 		// Remove user, the remove from gacl
 		
 		$userName = trim($this->request->args[0]);
 		$users = $this->application->db->query("From UserModel as user where user.name='".$userName."'");
 		$user = $users[0];
 		$this->application->db->delete($user);
 		require_once("lib/phpgacl/gacl_api.class.php");
 		$api = new gacl_api(array());
 		$id = $api->get_object_id("user", $userName, "ARO");
 		$api->del_object($id, "ARO");
 		$this->render("user/removed", array("user"=>$userName), "SMARTY");
 	}
 	function register()
 	{
 		$this->render("user/register", array(), "SMARTY");
 	}
 }
 
 
 
?>
