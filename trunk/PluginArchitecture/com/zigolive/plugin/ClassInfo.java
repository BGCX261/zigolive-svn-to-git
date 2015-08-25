package com.zigolive.plugin;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class ClassInfo {
	
	public static <T>T makeInstance(String clazz, IPluginArch arch){
		try{
			Class c = Class.forName(clazz);
			Constructor constructor = c.getConstructor(new Class[]{IPluginArch.class});
			return (T)constructor.newInstance(new Object[]{arch});
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static Method[] getMethods(String classname){
		try{
			Class c = Class.forName(classname);
			return c.getMethods();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static Method getMethod(String classname, String method){
		for(Method m:getMethods(classname))
			if(m.getName().equals(method))return m;
		return null;
	}
	
	public static <T>T invokeMethod(Object instance, Method m, Object[] args){
		try{
			return (T)m.invoke(instance, args);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		//TestPlugin t = TestPlugin.setup();
		//int i = invokeMethod(t,getMethod(t.getClass().getName(),"product"),new Object[]{new int[]{1,2,3,4,5,6,7,8,9}});
		//System.out.println(i+20);
	}
}
