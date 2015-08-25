package com.zigolive.liveup;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class MyURLClassLoader extends URLClassLoader{
	private String name;
	private ArrayList<MyURLClassLoader> parents = new ArrayList<MyURLClassLoader>();;
	public MyURLClassLoader(String name, URL[] urls, ClassLoader parent)
	{
		super(urls, parent);
		this.name = name;
	}
	public void addParent(MyURLClassLoader cl){
		parents.add(cl);
	}
	public Class<?> loadClass(String name) throws ClassNotFoundException
	{
		try{
			//if(name.startsWith("com.zigomushy") || name.startsWith("com.zigolive.applications")) throw new ClassNotFoundException();
			//System.out.println("Trying to find class:"+name);
			//return super.loadClass(name);
			return super.loadClass(name);
		}catch(ClassNotFoundException e){
			for(MyURLClassLoader p:parents){
				try{
					Class<?> c = p.loadClass(name);
					return c;
				}catch(ClassNotFoundException e2){
					
				}
			}
			return getParent().loadClass(name);
		}
	}
	
	public void addUrl(URL url) {
		//for(URL u:super.getURLs())if(u.equals(url)) throw new RuntimeException("Dammit!!!!!");
		super.addURL(url);
	}
	
    public String toString() {
  	  if( getParent() != null ) {
  		System.out.println("------------");
  	     String result = name+"\n"+"MYURLClassLoader:\n"
  	        + "hashcode: " + hashCode() + "\n"
  	        + "URLs: " + java.util.Arrays.asList(
  	           getURLs() ) + "\n";
  	        //+ "parent { " + getParent().toString() + " }\n";
  	     for(MyURLClassLoader m:parents)result+=m.toString()+"\n";
  	     return result;
  	  } else {
  	     System.out.println("*********");
  		  return name+"\n"+"MYURLClassLoader:\n"
  	        + "hashcode: " + hashCode() + "\n"
  	        + "URLs: " + java.util.Arrays.asList(
  	           getURLs() ) + "\n";
  	  }
  	}
	
}
