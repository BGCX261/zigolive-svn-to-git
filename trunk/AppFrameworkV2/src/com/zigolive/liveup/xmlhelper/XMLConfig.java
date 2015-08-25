package com.zigolive.liveup.xmlhelper;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XMLConfig
{
	Node root;
	public XMLConfig(String configFile)
	{
		SAXReader reader = new SAXReader();
        try {
			root = reader.read(new File(configFile).toURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//root = doc.selectSingleNode("/");
	}
	public XMLConfig(Node root)
	{
		this.root = root;
	}
	
	public String getValue(String path){
		try {
			return root.selectSingleNode(path).getStringValue();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Node> getList(String path){
		return root.selectNodes(path);
	}
	
	public static void main(String[] args)
	{
		XMLConfig c = new XMLConfig("../AppFramework/conf/config.xml");
		System.out.println(c.getValue("/config/root"));
	}
}
