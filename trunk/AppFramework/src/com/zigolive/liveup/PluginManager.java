package com.zigolive.liveup;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.zigolive.liveup.updates.NuggetEater;

/**
 * This is a plugin manager for an application
 * @author Tim
 *
 */
public class PluginManager
{
	private ApplicationContext context;
	HashMap<String, Plugin> plugins;
	public PluginManager(ApplicationContext c)
	{
		this.context = c;
		plugins = new HashMap<String, Plugin>();
	}
	public MyURLClassLoader registerPlugin(Node pn){
		//LiveUpClassLoader cl = new LiveUpClassLoader(new URL[]{}, context.getCl());
		try{
			String pname = pn.selectSingleNode("@name").getStringValue();
			System.out.println("trying plugin>" + pname);
			String pluginConfigFileName = context.getPluginRoot()+pname+"/config.xml";
			File pluginFolder = new File(context.getPluginRoot()+pname);
			if(!pluginFolder.exists()&&pn.selectSingleNode("@autodownload").getStringValue().equals("true")){
				try{
					NuggetEater.download("http://zigolive.googlecode.com/svn/trunk/ZigoLiveNuggets/"+pname+".zip",pname+".zip");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File(pluginConfigFileName));
			Node n = document.selectSingleNode("/config");
			// Load stuff from plugin
			String pdir = n.selectSingleNode("dir").getStringValue();
			// Directory to scan for this plugin
			String dir = context.getPluginRoot()+pdir;
			File df = new File(dir);
			MyURLClassLoader cl = new MyURLClassLoader("Plugin Class Loader", new URL[]{}, context.getCl());
			cl.addUrl(df.toURL());
			for(File c:df.listFiles()){
				if(c.getName().endsWith(".jar"))
					cl.addUrl(c.toURL());
			}
			// Now make the class available 
			String name = n.selectSingleNode("name").getStringValue();
			String className = n.selectSingleNode("class").getStringValue();
			Plugin p = (Plugin)cl.loadClass(className).newInstance();
			plugins.put(name, p);
			System.out.println("Line 51 (PluginManager)>" + dir);
			System.out.println("Line 52 (PluginManager)>" + cl);
			return cl;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public <T> T getPlugin(String name){
		return (T)plugins.get(name);
	}
	public HashMap<String,Plugin> getPlugins(){
		return plugins;
	}
}
