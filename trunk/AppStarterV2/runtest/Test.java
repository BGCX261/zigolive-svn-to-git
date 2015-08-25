package runtest;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;


public class Test
{
	public static void main(String[] args)
	{
		try{
			File fileDom4J = new File("../AppFramework/lib/dom4j.jar");
			File fileJaxen = new File("../AppFramework/lib/jaxen.jar");
			//File fileTrueZip = new File("../AppFramework/lib/truezip-6.jar");
			File fileAppRoot = new File("../AppFrameworkTests/bin/");
			URL urlDom4J = fileDom4J.toURL(); 
			URL urlJaxen = fileJaxen.toURL(); 
			//URL urlTrueZip = fileTrueZip.toURL(); 
			URL urlAppRoot = fileAppRoot.toURL(); 
			ParentFirstClassLoader cl = new ParentFirstClassLoader(new URL[]{urlDom4J,urlJaxen,urlAppRoot}, Test.class.getClassLoader());
			System.out.println(cl.loadClass("com.zigolive.liveup.ApplicationManager"));
			Class<?> c = cl.loadClass("com.zigolive.liveup.ApplicationManager");
			Constructor<?> constructor = c.getConstructor(new Class[]{String.class});
			constructor.newInstance(new Object[]{"../AppFrameworkTests/MainConfig.xml"});
			//c.newInstance();
			//cl.loadClass("org.dom4j.Document");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
