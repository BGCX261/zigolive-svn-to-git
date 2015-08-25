package com.zigolive.plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class Starter
{
	private static String root;
	private static String libs;
	public static void getPluginFolder(String config){
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(config);
			XPathFactory Xfactory = XPathFactory.newInstance();
			XPath xpath = Xfactory.newXPath();
			XPathExpression expr = xpath.compile("/config/global/root");
			NodeList n = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			root = n.item(0).getTextContent();
			expr = xpath.compile("/config/global/libs");
			n = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			libs = n.item(0).getTextContent();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		try{
			getPluginFolder("config.xml");
			System.out.println(libs);
			String base = "FILE:///"+libs;
			FilenameFilter ff = new FilenameFilter(){
				public boolean accept(File dir, String name)
				{
					if(name.endsWith(".jar"))return true;
					return false;
				}
				
			};
			JarClassLoader jcl = 
				new JarClassLoader(base);
			File dir = new File(new URL(base).getFile());
			if(dir.isDirectory()){
				for(File f:dir.listFiles(ff)){
					System.out.println(f.getName());
					jcl.readJarFile(f.getName());
				}
				jcl.readJarFile("FILE:///"+root+"PA.jar");
			}else{
				System.out.println("The directory given for plugins doesn't seem to exist");
			}
				
			try{
				// Now Start the App 
				Class clazz = jcl.loadClass("com.zigolive.plugin.PluginArch");
				Method m = clazz.getMethod("main", new Class[]{String[].class});
				m.invoke(null, new Object[]{new String[]{}});
			}catch(Exception e){
				System.out.println("Here");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
