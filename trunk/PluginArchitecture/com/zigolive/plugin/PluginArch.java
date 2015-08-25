package com.zigolive.plugin;//PluginArch

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.zigolive.plugin.exampleplugin.TestPlugin;

public class PluginArch implements IPluginArch{
	private static final File configFile = new File("config.xml");
	private static final HashMap<String, PluginArch> pluginArches = new HashMap<String, PluginArch>();
	
	private HashMap<String, APlugin> plugins = new HashMap<String, APlugin>();
	
	private PluginArch(){
		initialize();
	}
	private void initialize(){
		regesterPluginsFromConfig(configFile);
	}
	private void regesterPluginsFromConfig(File f){
		try{
			SAXReader reader = new SAXReader();
			Document document = reader.read(f);
			List<Node> list = document.selectNodes("/config/plugin");
			
			for(Node n:list){
				String pName = n.selectSingleNode("@name").getStringValue();
				String className = n.selectSingleNode("class").getText();
				APlugin p = ClassInfo.makeInstance(className, this);
				p.setup(n);
				plugins.put(pName, p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}
	public PluginArch getApplicationInstance(String name){
		if(!pluginArches.containsKey(name))
			pluginArches.put(name, new PluginArch());
		return pluginArches.get(name);
	}
	public void registerPlugin(String plugin) {
		try {
			APlugin p = ClassInfo.makeInstance(plugin, this);
			p.setup();
			//Method m = c.getMethod("setup", new Class[]{this.getClass()});
			//plugins.put(plugin, (IPlugin)m.invoke(null, new Object[]{this}));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//nothing
	}
	
	public <T>T getPlugin(String plugin){
		if(!plugins.containsKey(plugin))throw new RuntimeException("No plugin found!");
		return (T)plugins.get(plugin);
	}
	
	public static void main(String[] args) {
		PluginArch arch = new PluginArch();
		TestPlugin plugin = arch.getPlugin("TestPlugin");
		System.out.println(plugin.product(new int[]{1,2,3,4}));
		
		arch.registerPlugin("com.zigolive.plugin.exampleplugin.TestPlugin");
		//arch.registerPlugin("TestPlugin");
	}
}
