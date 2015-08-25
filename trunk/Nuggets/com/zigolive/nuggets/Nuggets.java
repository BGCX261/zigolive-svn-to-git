package com.zigolive.nuggets;

import java.util.HashMap;

import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;

public class Nuggets
{
	static abstract class Command{
		public String info = "";
		public abstract void exec();
	}

	public Nuggets(final String[] args)
	{
		final HashMap<String, Command> commands = new HashMap<String, Command>();
		String url = "http://zigolive.googlecode.com/svn/nuggets/";
		final NuggetRepository np = new NuggetRepository(url);
	
		Command get = new Command(){
			public void exec()
			{
				System.out.println("Installing new nugget "+args[1]);
				try{
					np.checkOutNugget(args[1], args[1]);
					System.out.println("Done !");
				}catch(SVNException e){
					System.out.println("Couldn't find the plugin "+args[1]+". check for typos.");
				}
			}
		};
		get.info = "Get and install a nugget from the repository";
		Command list = new Command(){
			public void exec()
			{
				System.out.println("The following nuggets are available from the repository:");
				for(SVNDirEntry s:np.getNuggetList()){
					//System.out.println(s);
					System.out.println(s.getName());
					
				}
			}
		};
		list.info = "List all nuggets available from the repository";
		Command help = new Command(){
			public void exec()
			{
				System.out.println("Nugget Help");
				for(String key:commands.keySet()){
					System.out.println(key+": "+commands.get(key).info);
				}
			}
		};
		help.info = "Print this help";
		commands.put("list-nuggets",list);
		commands.put("get-nugget", get);
		commands.put("help", help);
		try {
			commands.get(args[0]).exec();
		} catch (RuntimeException e) {
			System.out.println("Unknown command "+args[0]);
			commands.get("help").exec();
		}
	}
		

	public static void main(
			String[] args)
	{
		//String[] a = {"list-nuggets", "NuggetTest"};
		new Nuggets(args);
	}

}
