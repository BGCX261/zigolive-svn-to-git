<?php


class Request {
	function __construct($controller,$action, $args, $qs, $rawurl){
		$this->controller = $controller;
		$this->action = $action;
		$this->args = $args;
		$this->rawurl = $rawurl;
		$this->querystring = $qs;
		//print_r($qs);
	}
}


?>