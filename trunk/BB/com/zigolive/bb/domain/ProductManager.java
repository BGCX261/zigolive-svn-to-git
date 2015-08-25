package com.zigolive.bb.domain;
import org.hibernate.Session;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.zigolive.utils.HibernateUtil;

public class ProductManager {

	private static ProductManager pm = null;
	private ProductManager(){}
	public static ProductManager instance(){ 
		if (pm==null) pm = new ProductManager();
		return pm;
	}
    public void saveProduct(Product p) {

        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
    }
    
    public List<Product> listProducts(){
    	Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Product").list();
        session.getTransaction().commit();
        return result;
    }
    
    public static void main(String[] args) {
        
    	
    	
        
	}
   
}