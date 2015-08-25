package com.zigolive.bb.domain;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Vector;

import com.zigolive.utils.HibernateUtil;

public class PageManager {
	private Session session;
	private static PageManager pm = null;
	private PageManager(){}
	public static PageManager instance(){ 
		if (pm==null) pm = new PageManager();
		return pm;
	}
	private Session getSession(){
		if(session==null){
			session = new HibernateUtil().getSessionFactory().getCurrentSession();
		}
		return session;
	}
	private void closeSession(){
		session.close();
		session = null;
	}
    public void savePage(Page p) {
        Session session = getSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
    }
    
    public List<Page> listPages(){
    	Session session = getSession();
        session.beginTransaction();
        List result = session.createQuery("from Page").list();
        session.getTransaction().commit();
        return result;
    }
    public Page getPageByTitle(String title){
    	Session session = getSession();
        session.beginTransaction();
        Page result = (Page) session.createQuery("from Page page where page.title = '"+title+"'").uniqueResult();
        session.getTransaction().commit();
        return result;
    }
    public static void main(String[] args) {
        Session s = new HibernateUtil().getSessionFactory().getCurrentSession();
    	Transaction tx = s.beginTransaction();
    	
        Page root = new Page();
        root.setTitle("Root");
        Page index = new Page();
        index.setTitle("Index");
        index.setParent(root);
        Page galeries = new Page();
        galeries.setTitle("Galeries");
        Page aboutUs = new Page();
        aboutUs.setTitle("About Us");
        aboutUs.setParent(root);
        
        Vector<Page> child = new Vector<Page>();
        
        Page where = new Page();
        where.setTitle("Where to find us");
        where.setParent(aboutUs);
        //aboutUs.getChildren().add(where);
        child.add(where);
        Page how = new Page();
        how.setTitle("How to contact us");
        how.setParent(aboutUs);
        //aboutUs.getChildren().add(how);
        child.add(how);
        aboutUs.setChildren(child);
        
        
        galeries.setParent(root);
        List<Page> children = new Vector<Page>();
        children.add(galeries);
        children.add(aboutUs);
        children.add(index);
        root.setChildren(children);
        
    	s.save(root);
    	s.save(index);
    	s.save(galeries);
    	s.save(aboutUs);
    	s.save(how);
    	s.save(where);
    	//tx.commit();
    	
    	//tx = s.beginTransaction();
    	List<Page> pages = (List<Page>) s.createQuery("from Page").list();
        for(Page o:pages){
        	String cs = " Children:";
        	String prt = " Parent:";
        	if(o.getParent()!=null) prt += o.getParent().getTitle();
        	else prt +="Null";
        	if (o.getChildren()!=null) for(Page p:o.getChildren()) cs += p.getTitle();
        	else cs+="Null";
        	System.out.println("Title:"+o.getTitle()+cs+prt);
        	//System.out.print(o.getChildren());
        }
        tx.commit();
	}
   
}