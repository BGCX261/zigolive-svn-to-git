<?php
/*
 * Created on 19 Jul 2007
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */
require("FSM2.php");
require("lib/phpgacl/gacl.class.php");

class Workflow {
	
	var $gacl;
	var $fsm;
	var $workflowType;
	
	function Workflow($workflowType) {
		$this->workflowType = $workflowType;
		$stack = array();
		$this->fsm = new FSM('DEFAULT', $stack, "Default");
		$this->gacl = new gacl(array('db_name'=>"blog_test", 'db_table_prefix'=>"acl_"));
		$this->init();
	}
	
	function hasPermission($user,$task,$wfgroup,$currentState){
		$this->fsm->_currentState = $currentState;
		$this->fsm->_group = $wfgroup;
		print_r(array('workflow', 'process', 'default', $user, $this->workflowType, $wfgroup));
		if($this->gacl->acl_check('workflow', 'process', 'default', $user, $this->workflowType, $wfgroup)){
			echo "Task $task allowed for $user<br>";
			return $this->fsm->process($task);		
		}else{
			echo $user." is not allowed to perform task:".$task."<br>";
			return false;
		}
		//return false;
	}
}

?>
