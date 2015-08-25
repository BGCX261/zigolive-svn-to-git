<?php
/*
 * Created on 8 Sep 2007
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */
 
 class BarModel
{
	//@orm char(100)
	public $name = "No Name";
	
	//@orm text(500)
	public $address;
	
	//@orm char(10)
	public $postcode;
	
	//@orm char(50)
	public $city;
	
	//@orm text(10000)
	public $description;
	
	//@orm text(100)
	public $status = "DRAFT";
	
}
?>
