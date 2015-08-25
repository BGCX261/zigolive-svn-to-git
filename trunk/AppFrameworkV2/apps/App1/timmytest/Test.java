package timmytest;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;

import com.zigolive.liveup.Application;
import com.zigolive.liveup.xmlhelper.XMLConfig;


public class Test extends Application
{

	public Test(XMLConfig conf)
	{
		super(conf);
		System.out.println("Hello");
		Document d = DocumentFactory.getInstance().createDocument();
		System.out.println(d);

	}
	@Override
	public void init()
	{
		Options options = new Options();
		options.addOption(new Option( "help", "print this message" ));
		CommandLineParser parser = new GnuParser();
		try {
			CommandLine line = parser.parse( options, new String[]{"-help"});
			System.out.println(line.hasOption("help"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Hellllllo");

		//CommandLine cl = CommandLine.
	}
	public static void main(String[] args)
	{
		Document d = DocumentFactory.getInstance().createDocument();
		
		
	}
}
