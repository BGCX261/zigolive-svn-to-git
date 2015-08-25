package com.zigolive.applications.test;

import java.util.HashMap;

import com.zigolive.liveup.Application;
import com.zigolive.liveup.ApplicationContext;
import com.zigolive.liveup.Plugin;
import com.zigomushy.appframeworktests.TestPlugin;

public class Test extends Application
{
	public Test(ApplicationContext ac)
	{
		super(ac);
		System.out.println("Hello");
		//init();
	}
	
	public void init() {
		//TestPlugin t = getApplicationContext().getPm().getPlugin("TestPlugin");
		//t.Test("Hello from the plugin");
		HashMap<String, Plugin> plugins = getApplicationContext().getPm().getPlugins();
		for(String s:plugins.keySet()){
			System.out.println(s+" "+plugins.get(s));
		}
		TestPlugin p = (TestPlugin)plugins.get("TestPlugin");
		p.Test("hello from plugin");
		System.out.println("Hello from init in Test");
	}

}
