package com.zigolive.plugin.exampleplugin;

import org.dom4j.Node;

import com.zigolive.plugin.APlugin;
import com.zigolive.plugin.IPluginArch;

public class TestPlugin extends APlugin {
	public TestPlugin(IPluginArch p)
	{
		super(p);
	}
	public void setup(){
		System.out.println("Registering TestPlugin with no args");
	}
	public void setup(Node n){
		System.out.println(n.selectSingleNode("desc").getText());
		System.out.println("Registering TestPlugin");
	}
	public String getString(String s){return s.toUpperCase();}
	public int product(int[] numbers){
		int sum = 1;
		for(int n:numbers)sum*=n;
		return sum;
	}
}
