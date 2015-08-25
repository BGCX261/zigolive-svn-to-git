package com.zigolive.bb.wicket;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zigolive.bb.domain.Page;
import com.zigolive.bb.wicket.components.SiteMap;
import com.zigolive.utils.HibernateUtil;

import wicket.PageParameters;
import wicket.markup.html.WebPage;
import com.zigolive.utils.HibernateUtil;

public class BBIndex extends WebPage {
	public BBIndex(final PageParameters parameters) 
    {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		Page root = (Page) s.createQuery("from Page page where page.title='Root'").uniqueResult();
		tx.commit();
		s.close();
		add(new SiteMap("SiteMap", root,1));
		
	}
}
