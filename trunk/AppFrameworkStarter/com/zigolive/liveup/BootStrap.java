package com.zigolive.liveup;


import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Loads the libraries from the path and 
 * then start the application framework
 * @author Tim
 *
 */
public class BootStrap
{
	//MyURLClassLoader myCl; 
	
	// Lib directory, and AppFrwk Starter
	public BootStrap(String config)
	{
		//myCl = mcl;
		
		HashMap<String, String> configKeys = BasicConfigReader.getBasicConfig(config);
		String root = configKeys.get("root");
		String lib = configKeys.get("lib");
		String bin = configKeys.get("bin");
		
		try{
			File f = new File(root+lib);
			ArrayList<URL> urls = new ArrayList<URL>();
			if(f.isDirectory()){
				for(File c:f.listFiles()){
					if(c.getName().endsWith(".jar")){
						urls.add(c.toURL());
					}
				}
				URL binURL = new File(root+bin).toURL();
				urls.add(binURL);
				MyURLClassLoader cl = new MyURLClassLoader("Main app Classloader",urls.toArray(new URL[]{}), this.getClass().getClassLoader());
				//cl.loadClass("org.dom4j.util.SimpleSingleton").newInstance();
				System.out.println(cl.toString());
				Class c = cl.loadClass("com.zigolive.liveup.KickStart");
				System.out.println(c.getName());
				Constructor t = c.getConstructor(new Class[]{String.class, cl.getClass()});
				t.newInstance(new Object[]{config, cl});
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		//new 
		if(args.length>0)
			new BootStrap(args[0]);
		else
			new BootStrap("../AppFramework/conf/config.xml");
		
	}
	
	
	
	
	
}
