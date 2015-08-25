package com.zigolive.liveup;

import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class BasicConfigReader
{

	public static HashMap<String, String> getBasicConfig(){
		return getBasicConfig("conf/config.xml");
	}
	public static HashMap<String, String> getBasicConfig(String confFile){
		HashMap<String, String> conf = new HashMap<String, String>();
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(confFile);
			XPathFactory Xfactory = XPathFactory.newInstance();
			XPath xpath = Xfactory.newXPath();
			XPathExpression rootE = xpath.compile("/config/root");
			XPathExpression libE = xpath.compile("/config/lib");
			XPathExpression binE = xpath.compile("/config/bin");
			conf.put("root", ((NodeList) rootE.evaluate(doc, XPathConstants.NODESET)).item(0).getTextContent());
			conf.put("lib", ((NodeList) libE.evaluate(doc, XPathConstants.NODESET)).item(0).getTextContent());
			conf.put("bin", ((NodeList) binE.evaluate(doc, XPathConstants.NODESET)).item(0).getTextContent());
		}catch(Exception e){
			e.printStackTrace();
		}
		return conf;
	}

}
