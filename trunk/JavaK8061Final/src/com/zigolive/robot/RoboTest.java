package com.zigolive.robot;

public class RoboTest {
	public static void main(String[] args) {
		
		try{
			JavaK8061 card = new JavaK8061();

			Thread.sleep(1000);
			card.setAnalogChannel(1);
			Thread.sleep(50000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
