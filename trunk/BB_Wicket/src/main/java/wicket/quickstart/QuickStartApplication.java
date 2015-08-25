package wicket.quickstart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zigolive.bb.domain.PageManager;
import com.zigolive.bb.domain.ProductGroupManager;
import com.zigolive.bb.wicket.BBIndex;

import wicket.ISessionFactory;
import wicket.Session;
import wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see wicket.quickstart.Start#main(String[])
 */
public class QuickStartApplication extends WebApplication
{    
	/** Logging */
	private static final Log log = LogFactory.getLog(QuickStartApplication.class);

    /**
     * Constructor
     */
	public QuickStartApplication()
	{
		PageManager.main(new String[]{});
		ProductGroupManager.main(new String[]{});
	}
	
	/**
	 * @see wicket.Application#getHomePage()
	 */
	public Class getHomePage()
	{
		return BBIndex.class;
	}

    /**
     * @see wicket.protocol.http.WebApplication#getSessionFactory()
     */
    public ISessionFactory getSessionFactory()
    {
        return new ISessionFactory()
        {        	
			public Session newSession()
            {
                return new QuickStartSession(QuickStartApplication.this);
            }
        };
    }
}