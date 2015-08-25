package com.zigolive.liveup;

import com.zigolive.liveup.xmlhelper.XMLConfig;

public abstract class Application
{
	XMLConfig appConfig;
	public Application(XMLConfig appConfig)
	{
		this.appConfig = appConfig;
		// TODO Auto-generated constructor stub
	}
	public abstract void init();

}
