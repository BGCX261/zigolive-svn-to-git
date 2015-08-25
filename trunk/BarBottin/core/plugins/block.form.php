<?php
/*
 * Created on 18 Jul 2007
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */
 
 function smarty_block_form($params, $content, &$smarty, &$repeat){ 	
 	if(!$repeat) {
 		if(!isset($params['method'])) $params['method'] = "POST";
 		if(!isset($params['action'])) $params['action'] = $_SERVER['PHP_SELF']."/onSubmit";
 		return "<form method='".$params['method']."' action='".$params['action']."'>"
				.$content
				."<input type='hidden' name='__onSubmit' value='true' />"
 				."</form>";
 	}
 }
?>
