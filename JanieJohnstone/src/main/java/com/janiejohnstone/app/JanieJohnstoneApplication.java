package com.janiejohnstone.app;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.wicket.Request;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebRequest;
import org.apache.wicket.protocol.http.WebRequestCycle;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.util.lang.PackageName;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.UrlResourceStream;
import org.apache.wicket.util.resource.locator.ResourceStreamLocator;
import org.hibernate.Transaction;
import org.slf4j.Logger;

import com.janiejohnstone.pages.Index;
import com.janiejohnstone.pages.admin.ManageGaleries;
import com.janiejohnstone.persistance.BootStrapDB;
import com.janiejohnstone.persistance.HibernateUtil;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see com.janiejohnstone.app.Start#main(String[])
 */
public class JanieJohnstoneApplication extends WebApplication
{    
	/** Logging */
	//private static final Log log = LogFactory.getLog(JanieJohnstoneApplication.class);

    /**
     * Constructor
     */
	public JanieJohnstoneApplication()
	{
		myinit();
		//BootStrapDB.init(); 
	}
	protected void init(){
        // instruct the application to use our custom resource stream locator
        getResourceSettings().setResourceStreamLocator(new CustomResourceStreamLocator());

	}
	protected void myinit()
    {
		System.out.println("*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%*&^%(*&^%£&^$%");
		mount("/Admin", PackageName.forClass(ManageGaleries.class));
		mountBookmarkablePage("/Index", Index.class);		
    }

	/**
	 * @see wicket.Application#getHomePage()
	 */
	public Class getHomePage()
	{
		return Index.class;
	}

	@Override
	public RequestCycle newRequestCycle(Request request, Response response) {
		// TODO Auto-generated method stub
		return new WebRequestCycle(this,(WebRequest)request, response){
			private org.hibernate.Session session;
			private Transaction tx;
			@Override
			protected void onBeginRequest() {
				// First, start session, and transaction
				//Logger.getAnonymousLogger().info("Begining request");
				session = HibernateUtil.getSessionFactory().getCurrentSession();
				tx = session.beginTransaction();
				super.onBeginRequest();
			}
			@Override
			protected void onEndRequest() {
				// close transaction (and hence session)
				tx.commit();
				super.onEndRequest();
				//Logger.getAnonymousLogger().info("Ending request");
			}

		};
	}
	
	@Override
	public Session newSession(Request request, Response response) {
		// TODO Auto-generated method stub
		return new WebSession(this, request);
	}
  
    
	
    private final class CustomResourceStreamLocator extends ResourceStreamLocator
    {
  
        public IResourceStream locate(Class clazz, String path)
        {

            String location;
            location = "/WEB-INF" + path;
            URL url;
            try
            {
            	//System.out.println(clazz.getName()+":"+path);
                // try to load the resource from the web context
                url = getServletContext().getResource(location);
                //Logger..info("Trying to locate:"+url.toString());
                if (url != null)
                {
                    
                	return new UrlResourceStream(url);
                }
            }
            catch (MalformedURLException e)
            {
                throw new WicketRuntimeException(e);
            }

            // resource not found; fall back on class loading
            return super.locate(clazz, path);
        }

    }
}