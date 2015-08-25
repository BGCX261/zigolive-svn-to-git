<?php
/*
 * Created on 18 Jul 2007
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */
 
 class Test extends Controller {
 	public $fsm;
	function index(){
		$o = new Documentfsm("DocumentWorkFlow");
		$o->test();
 	}
 	
 }
?>
