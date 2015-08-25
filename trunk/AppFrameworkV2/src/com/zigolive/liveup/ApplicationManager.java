package com.zigolive.liveup;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.dom4j.Node;

import com.zigolive.liveup.xmlhelper.XMLConfig;

import runtest.ChildFirstClassLoader;

public class ApplicationManager
{
	XMLConfig config ;
	public ApplicationManager(String configFile)
	{
		//Option o = new Option("hello", "hjkjh");
		//o.addValue("hekk");
		config = new XMLConfig(configFile);
		for(Node n:config.getList("/config/application")){
			startApplication(n);
		}
	}
	public void startApplication(Node n){
		// Start an app with a given config node
		XMLConfig appConfig = new XMLConfig(n);
		String appRoot = 
			config.getValue("config/root-folder")+
			config.getValue("config/apps-folder")+
			appConfig.getValue("root-folder");
		System.out.println(appRoot);
		String appClass = appConfig.getValue("main-class");
		ChildFirstClassLoader cl = new ChildFirstClassLoader(getJarsInFolder(appRoot), ApplicationManager.class.getClassLoader());
		try {
			cl.addURL(new File(appRoot).toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			Class<?> c = cl.loadClass(appClass);
			Constructor<?> constructor = c.getConstructor(new Class[]{XMLConfig.class});
			Application app = (Application)constructor.newInstance(new Object[]{appConfig});
			app.init();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private URL[] getJarsInFolder(String folder){
		ArrayList<URL> urls = new ArrayList<URL>();
		File f = new File(folder);
		
		if(f.isDirectory()){
			for(File child:f.listFiles()){
				if(child.getName().endsWith(".jar")){
					try {
						urls.add(child.toURL());
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return urls.toArray(new URL[]{});
	}
	
	public static void main(
			String[] args)
	{
		new ApplicationManager("MainConfig.xml");
	}
}
