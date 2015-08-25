<?php
/*
 * Created on 19 Jul 2007
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */
class Documentfsm extends Workflow{
	function Documentfsm($type){
		parent::__construct($type);
	}
	function init(){
		//	$a = array();
		//$this->fsm = new FSM('EDIT',$a , "Users");
		$this->fsm->setDefaultTransition(null, "__default", $this, "Moderators");
		$this->fsm->addTransition('PROPOSE', "EDIT", "PROPOSED", "__proccess", $this, "Moderators");
		$this->fsm->addTransition('REJECT', "PROPOSED", "REJECTED", "__proccess", $this, "Users");
		$this->fsm->addTransition('PUBLISH', "PROPOSED", "PUBLISHED", "__proccess", $this, "Users");
		$this->fsm->addTransition('EDIT', "PUBLISHED", "EDIT", "__proccess", $this, "Users");
		$this->fsm->addTransition('EDIT', "REJECTED", "EDIT", "__proccess", $this, "Users");
		$this->fsm->addTransition('DELETE', "EDIT", "DELETED", "__proccess", $this, "Users");
		
	}
	
	function test(){
		echo $this->hasPermission("pisky","PUBLISH","Moderators","PROPOSE");
	}
	
	 	
 	function __proccess($symbol, $payload){
 		print("Current Symbol:".$symbol."<br>");
 	}
 	function __default($symbol, $payload){
 		print_r($symbol);
 		print(" ".$symbol." is not an allowed transaction from the current state ".$this->fsm->getCurrentState().". state unchanged<br>");
 		//print_r($payload);
 	}
 	
}

?>
