package com.janiejohnstone.app;

import org.apache.wicket.application.ReloadingClassLoader;
import org.apache.wicket.protocol.http.ReloadingWicketServlet;

public class JanieJohnstoneClassReloadingServlet extends ReloadingWicketServlet {

	static
 	{
 		ReloadingClassLoader.includePattern("com.janiejohnstone.app.*");
 		ReloadingClassLoader.includePattern("com.janiejohnstone.components.filmstrip.*");
 		ReloadingClassLoader.includePattern("com.janiejohnstone.components.uploader.*");
 		ReloadingClassLoader.includePattern("com.janiejohnstone.components.bookmarkableimgelink.*");
 		ReloadingClassLoader.includePattern("com.janiejohnstone.pages.*");
 		ReloadingClassLoader.includePattern("com.janiejohnstone.pages.admin.*");
 		//ReloadingClassLoader.includePattern("com.janiejohnstone.persistance.*");
 		//ReloadingClassLoader.includePattern("com.janiejohnstone.persistance.domain.*");
 	}
}
