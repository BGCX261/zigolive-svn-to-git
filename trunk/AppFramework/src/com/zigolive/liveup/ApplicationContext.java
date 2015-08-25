package com.zigolive.liveup;

public class ApplicationContext
{
	private String appRoot;
	private String appsRoot;
	
	private String pluginRoot;
	private String frameworkRoot;
	private MyURLClassLoader cl;
	private PluginManager pm;
	public ApplicationContext(MyURLClassLoader cl, String ar,String appsR, String pr, String fr)
	{
		this.cl = cl;
		appRoot = ar;
		appsRoot = appsR;
		pluginRoot = pr;
		frameworkRoot = fr;
		// TODO Auto-generated constructor stub
	}
	public void setPm(PluginManager pm)
	{
		this.pm = pm;
	}
	public PluginManager getPm()
	{
		return pm;
	}
	public String getAppsRoot()
	{
		return frameworkRoot+appsRoot;
	}
	public String getPluginRoot()
	{
		return frameworkRoot+pluginRoot;
	}
	public String getAppRoot()
	{
		return getAppsRoot()+appRoot;
	}
	public String getFrameworkRoot()
	{
		return frameworkRoot;
	}
	public MyURLClassLoader getCl()
	{
		return cl;
	}
}
