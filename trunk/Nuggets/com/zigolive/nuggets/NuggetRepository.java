package com.zigolive.nuggets;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class NuggetRepository
{
	private SVNURL url;
	private SVNRepository repository;
	public NuggetRepository(String url)
	{

		try {
			this.url = SVNURL.parseURIDecoded( url );
			DAVRepositoryFactory.setup();
			repository = SVNRepositoryFactory.create( this.url, null );
		} catch (SVNException e) {
			e.printStackTrace();
		}
	}

	public Collection<SVNDirEntry> getNuggetList(){
		Collection<SVNDirEntry> contents = new ArrayList<SVNDirEntry>();
		Map properties = new HashMap();
		try {
			repository.getDir("", repository.getLatestRevision(), properties, contents);
		} catch (SVNException e) {
			e.printStackTrace();
		}
		return contents;
	}
	public synchronized void checkOutNugget(String name, String dest) throws SVNException{
		
		ISVNOptions options = SVNWCUtil.createDefaultOptions(true);
		SVNClientManager clientManager = SVNClientManager.newInstance(options,"anonymous","anonymously");
		SVNUpdateClient updateClient = clientManager.getUpdateClient();
		updateClient.doCheckout(url.appendPath(name, false), new File(dest), SVNRevision.HEAD, SVNRevision.HEAD, true);
	}
	/**
	 * @param args
	 */
	public static void main(
			String[] args)
	{
		String url = "http://zigolive.googlecode.com/svn/nuggets/";
		NuggetRepository np = new NuggetRepository(url);
		for(SVNDirEntry s:np.getNuggetList()){
			System.out.println(s);
		}
	}

}
