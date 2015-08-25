package runtest;

import java.net.URL;
import java.net.URLClassLoader;

public class ParentFirstClassLoader extends URLClassLoader
{
	public ParentFirstClassLoader(URL[] urls) {
	    super(urls);
	  }

	  public ParentFirstClassLoader(URL[] urls, ClassLoader parent) {
	    super(urls, parent);
	  }

	  public void addURL(URL url) {
	    super.addURL(url);
	  }
	  
	  public Class<?> loadClass(String name) throws ClassNotFoundException {
	  	return loadClass(name, false);
	  }
/*	  protected Class<?> loadClass(String name, boolean resolve)
	    throws ClassNotFoundException {
	  	
		    // First check if the class is already loaded
		    Class c = findLoadedClass(name);
		    if (c == null) {
		        try {
		            if (getParent() != null) {
		                c = getParent().loadClass(name);
		            } else {
		                c = System.class.getClassLoader().loadClass(name);
		            }
		        } catch (ClassNotFoundException e) {
		            // If still not found, then invoke
		            // findClass to find the class.
		            c = findClass(name);
		        }
		    }
		    if (resolve) {
			    resolveClass(c);
		    }
		    return c;
	  }
*/	  
}
