package com.zigolive.liveup;

public abstract class Application
{
	private ApplicationContext ac;
	
	public Application(ApplicationContext appContext) {
		ac = appContext;
	}
	public void init(){
	}
	public ApplicationContext getApplicationContext(){
		return ac;
	}
}
