package com.zigolive.liveup;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.zigolive.liveup.MyURLClassLoader;

/**
 * Gets a XML node, and initialises a new application using it
 * 
 * it should also load the plugins used by the application
 * classes will only be loaded when used
 * 
 * @author Tim
 *
 */
public class ApplicationManager
{
	//private AppClassLoader cl;
	Document configXML;
	String root,lib,bin,plugins,apps;
	private MyURLClassLoader mcl;
	public String getBin()
	{
		return bin;
	}
	public String getLib()
	{
		return lib;
	}
	public String getPlugins()
	{
		return plugins;
	}
	public String getRoot()
	{
		return root;
	}
	public ApplicationManager(Document config, MyURLClassLoader mcl)
	{
		this.mcl = mcl;
		root = config.selectSingleNode("/config/root").getStringValue();
		lib = config.selectSingleNode("/config/lib").getStringValue();
		bin = config.selectSingleNode("/config/bin").getStringValue();
		plugins = config.selectSingleNode("/config/plugins").getStringValue();
		apps = config.selectSingleNode("/config/apps").getStringValue();

		configXML = config;
		
		List<Node> apps = config.selectNodes("/config/startapp");
		System.out.println("Starting "+apps.size()+" apps");
		for(Node appNode:apps){
			startApplication(appNode);
		}

	}
	public void startApplication(Node appConfigNode){
		
		try{
			String appName = appConfigNode.selectSingleNode("@name").getStringValue();
			String appConfigFileName = root+apps+appName;
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File(appConfigFileName+"/config.xml"));
			
			Node appNode = document.selectSingleNode("/config");
			//String appName = appNode.selectSingleNode("name").getStringValue();
			String appRoot = appNode.selectSingleNode("root").getStringValue();
			String appClass = appNode.selectSingleNode("class").getStringValue();
			//String fwRoot = appNode.selectSingleNode("root").getStringValue();
			MyURLClassLoader cl = new MyURLClassLoader("Application Class Loader", new URL[]{}, mcl); 
			System.out.println("Second ClassLoader>"+cl);
			ApplicationContext appC = new ApplicationContext(cl,appRoot,apps, plugins, root);
			
			// Get the plugins
			PluginManager pm = new PluginManager(appC);
			appC.setPm(pm);
	
			List<Node> plugins = appNode.selectNodes("plugin");
			for(Node plugin:plugins){
				String pluginName = plugin.selectSingleNode("@name").getStringValue();
				System.out.println(pluginName);
				MyURLClassLoader parent = pm.registerPlugin(plugin);
				cl.addParent(parent);
			}
			try{
				//cl.addUrl(new File(appC.getFrameworkRoot()+bin).toURL());
	
				// Load the app into the classloader
				
				File f = new File(appC.getAppRoot());
				System.out.println(f.toURL());
				cl.addUrl(f.toURL());
				for(File c:f.listFiles()){
					if(c.getName().endsWith(".jar"))
						cl.addUrl(c.toURL());
					
				}
				// Now start the app :) using cl
				System.out.println(cl);
				Class app = cl.loadClass(appClass);
				Constructor<?> constructor = app.getConstructor(new Class[]{ApplicationContext.class});
				Application application = (Application)constructor.newInstance(new Object[]{appC});
				System.out.println("Starting app "+appName);
				application.init();
				//application.init();
				/*
				Object p = app.newInstance();
				
				//p = p.getClass().asSubclass(Application.class);
				System.out.println(p.getClass());
				System.out.println(p.getClass().getSuperclass());
				*///Class appContext = null;
	/*			for(Method m:app.getSuperclass().getMethods()){
					if(m.getName().equals("init"))
						for(Class c:m.getParameterTypes())
							appContext = c;
							//System.out.println(c);
				}
	*/			
				
				/*Method d = p.getClass().getMethod("init", new Class[]{ApplicationContext.class});
				//Method m = app.getMethod("init",new Class[]{ApplicationContext.class});
				d.invoke(p,new Object[]{appC});
				//app.newInstance();
				*/
				
			}catch(Exception e){
				e.printStackTrace();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
