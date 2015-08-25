<?php
/*
 * Created on 18 Jul 2007
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */
 
 class Test2 extends FormController
 {
 	function index(){
 		//$data['user'] = 
		$this->render("example2",array(),"SMARTY");
 	}
 	
 	function onSubmit(){
 		
 		echo "Form Submitted";
 		
 	}
 	
 }
?>
