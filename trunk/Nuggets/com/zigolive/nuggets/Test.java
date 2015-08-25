package com.zigolive.nuggets;

import java.io.File;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class Test
{

	public static void main(
			String[] args)
	{
		DAVRepositoryFactory.setup();
		ISVNOptions options = SVNWCUtil.createDefaultOptions(true);
		String url = "http://zigolive.googlecode.com/svn/nuggets";
		try {
			SVNClientManager clientManager = SVNClientManager.newInstance(options,"anonymous","anonymously");
			
			SVNUpdateClient updateClient = clientManager.getUpdateClient();
			SVNURL svnUrl = SVNURL.parseURIDecoded( url );
			System.out.println(svnUrl.getPort());
			updateClient.doCheckout(svnUrl, new File("Test"), SVNRevision.HEAD, SVNRevision.HEAD, true);
			//SVNRepository repository = SVNRepositoryFactory.create( SVNURL.parseURIDecoded( url ), null );
			
			
			
			
			//jSystem.out.println(repository.getLock("").getOwner());
			//repository.checkout(repository.getLatestRevision(), "NuggetTest", true, e);
		} catch (SVNException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
