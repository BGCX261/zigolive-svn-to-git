<?php
/*
 * Created on 19 Jul 2007
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */

class BBLog {
	private static $inst = null;
	private static function getInst(){
		if(BBLog::$inst == null) {
			$conf = array('error_prepend' => '<font color="#ff0000"><tt>',
            'error_append'  => '</tt></font>',
            'buffering'=>true);
            BBLog::$inst = Log::singleton("display", '', 'BBLog', $conf, PEAR_LOG_ERR);
		}
		return BBLog::$inst;
	}
	public static function debug($msg){ BBLog::getInst()->debug($msg);}
	public static function info($msg){ BBLog::getInst()->info($msg);}
	public static function notice($msg){ BBLog::getInst()->notice($msg);}
	public static function warning($msg){ BBLog::getInst()->warning($msg);}
	public static function err($msg){ BBLog::getInst()->err($msg);}
	
	
	
}


?>
