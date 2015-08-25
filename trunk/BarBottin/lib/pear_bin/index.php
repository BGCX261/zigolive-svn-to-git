<?php
###########################################################
#      This file is identical to docs/index.php.txt       #
#  It exists only for backward-compatiblity with go-pear  #
###########################################################

/**
 * Put this file in a web-accessible directory as index.php (or similar)
 * and point your webbrowser to it.
 */

// $pear_dir must point to a valid PEAR install (=contains PEAR.php)
$pear_dir = 'C:/Documents and Settings/Administrator/workspace/BarBottin/lib/PEAR'; // default of install

// OPTIONAL: If you have a config file at a non-standard location,
// uncomment and supply it here:
//$pear_user_config = '';


/***********************************************************
 * Following code tests $pear_dir and loads the webfrontend:
 */
if (!file_exists($pear_dir.'/PEAR.php')) {
    trigger_error('No PEAR.php in supplied PEAR directory: '.$pear_dir,
                    E_USER_ERROR);
}
ini_set('include_path', $pear_dir);
require_once('PEAR.php');

// Include WebInstaller
putenv('PHP_PEAR_INSTALL_DIR='.$pear_dir); // needed if unexisting config
require_once('PEAR/WebInstaller.php');
?>
