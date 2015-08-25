package com.zigolive.liveup;

import java.net.URL;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.zigolive.liveup.MyURLClassLoader;

public class KickStart
{
	private MyURLClassLoader mcl;
	public KickStart(String configFile, MyURLClassLoader mcl)
	{
		this.mcl = mcl;
		try{
			SAXReader reader = new SAXReader();
			Document document = reader.read(configFile);
			ApplicationManager appMan = new ApplicationManager(document, mcl);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(
			String[] args)
	{
		try{
			MyURLClassLoader mcl = new MyURLClassLoader("Non bootstraped class loader", new URL[]{},KickStart.class.getClassLoader());
			new KickStart("conf/config.xml",mcl);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
