<?php
/*
 * Created on 17 Jul 2007
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */
 include_once 'HTML/AJAX/Server.php';
 
class AjaxController extends Controller {
 	
 	function javascript(){
		$server = new HTML_AJAX_Server($this->request);
		$server->handleRequest();
	}
}
?>
