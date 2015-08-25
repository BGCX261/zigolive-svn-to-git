<?php
/*
 * Created on 17 Jul 2007
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */
 

class Ajaxview extends AjaxController {
	function index(){
		$this->render("ajv", array("a"=>"b"), "SMARTY");
		BBLog::info("hello");
	}
	function getTheTime(){
		return date("D M Y G:i:s");
	}
}
?>
