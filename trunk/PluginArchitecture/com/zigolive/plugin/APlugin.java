package com.zigolive.plugin;

import org.dom4j.Node;

public abstract class APlugin 
{
	private IPluginArch parch;
	public APlugin(IPluginArch pa)
	{
		parch = pa;
	}
	public IPluginArch getArch(){ return parch;}
	public abstract void setup(Node n);
	public abstract void setup();
	
}
