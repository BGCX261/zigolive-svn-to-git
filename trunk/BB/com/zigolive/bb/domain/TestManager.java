package com.zigolive.bb.domain;

import org.hibernate.Session;

import com.zigolive.utils.HibernateUtil;

public class TestManager {

	public static void main(String[] args) {
		
		Test t = new Test();
		t.setName("GHU3U");
		
		Product p = new Product();
		p.setName("P133");
		p.setDescription("Thi3s is p1");
		p.setPrice(19.949);
		p.setImage("this i4s the image");
		
		Session session = new HibernateUtil().getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(t);
        session.save(p);
        session.getTransaction().commit();
        
	}
}
