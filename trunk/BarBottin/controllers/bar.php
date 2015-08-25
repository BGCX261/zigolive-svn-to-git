<?php
/*
 * Created on 8 Sep 2007
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */
 
 
 
 
 class Bar extends Controller {
 	//public $fsm;
 	public $defaultAction="listall";
 	
 	function view(){
 		print_r($_SESSION['user']);
 		if(!$this->gacl->acl_check('bars', 'view', $_SESSION['user']['group'], $_SESSION['user']['name'])) exit;
		$id = $this->request->args[0];
		$data["bar"] = $this->application->db->get("BarModel", $id);
		return $this->render("bar/view", $data, "SMARTY");
 	}
	function newbar(){
 		if(!$this->gacl->acl_check('bars', 'create', $_SESSION['user']['group'], $_SESSION['user']['name'])) exit;
		$data["bar"]["oid"] = "new";
		return $this->render("bar/edit", $data, "SMARTY");
 	}
 	function edit(){
  		if(!$this->gacl->acl_check('bars', 'edit', $_SESSION['user']['group'], $_SESSION['user']['name'])) exit;
		$id = $this->request->args[0];
		$bar = $this->application->db->get("BarModel", $id);
		$data["bar"] = $bar;
		return $this->render("bar/edit", $data, "SMARTY");
 	}	
 	function save(){
 		if(!$this->gacl->acl_check('bars', 'edit', $_SESSION['user']['group'], $_SESSION['user']['name'])) exit;
 		$id = $this->request->args[0];
 		$bar = "";
 		if(trim($id)=="new"){
 			$bar = $this->application->db->create("BarModel");
 		} else {
 			$bar = $this->application->db->get("BarModel", $id);
 		}
 		//$bar = $this->application->db->get("BarModel", $id);
 		$bar->name = $_POST["BarName"];
 		$bar->address = $_POST["BarAddress"];
 		$bar->postcode = $_POST["BarPostCode"];
  		$bar->city = $_POST["BarTown"];
  		$bar->description = $_POST["BarDescription"];
 		$this->application->db->commit($bar);
 		//print_r($this->request->args);
 		header('Location: /Bar/Listall');
 		//$this->listall();
 	}
 	
 	function listall(){
 		$l = $this->application->db->get("BarModel");
 		//$this->application->db->delete($l[0]);
 		//$this->application->db->commit();
 		$data["bars"] = $this->application->db->get("BarModel");
 		//print_r($data);
 		return $this->render("bar/list", $data, "SMARTY");
 	}
 	
 	
 	function test()
 	{
		
 		
 	}
 }
 
 
?>
