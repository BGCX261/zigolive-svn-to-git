package com.zigolive.bb.domain;

import java.util.List;
import java.util.Vector;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zigolive.utils.HibernateUtil;

public class ProductGroupManager {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		// First Create a Chair Category
		ProductGroup chairs = new ProductGroup();
		chairs.setName("Chairs");
		chairs.setImagesDir("images/chairs/");
		List<Product> chairList = new Vector<Product>();
		chairs.setProducts(chairList);
		
		Product p1= new Product();
		p1.setName("Chair1");
		p1.setDescription("Chair1desc");
		p1.setPrice(19.99);
		p1.setImage("images.jpg");
		
		Product p2= new Product();
		p2.setName("Chair2");
		p2.setDescription("Chair2desc");
		p2.setPrice(19.99);
		p2.setImage("images_001.jpg");

		Product p3= new Product();
		p3.setName("Chair3");
		p3.setDescription("Chair3desc");
		p3.setPrice(19.99);
		p3.setImage("images_001_001.jpg");

		Product p4= new Product();
		p4.setName("Chair4");
		p4.setDescription("Chair4desc");
		p4.setPrice(19.99);
		p4.setImage("images_001_002.jpg");

		Product p5= new Product();
		p5.setName("Chair5");
		p5.setDescription("Chair5desc");
		p5.setPrice(19.99);
		p5.setImage("images_002.jpg");

		Product p6= new Product();
		p6.setName("Chair6");
		p6.setDescription("Chair6desc");
		p6.setPrice(19.99);
		p6.setImage("images_003.jpg");

		Product p7= new Product();
		p7.setName("Chair7");
		p7.setDescription("Chair7desc");
		p7.setPrice(19.99);
		p7.setImage("images_004.jpg");

		chairList.add(p1);
		chairList.add(p2);
		chairList.add(p3);
		chairList.add(p4);
		chairList.add(p5);
		chairList.add(p6);
		chairList.add(p7);
		
		s.save(p1);
		s.save(p2);
		s.save(p3);
		s.save(p4);
		s.save(p5);
		s.save(p6);
		s.save(p7);
		s.save(chairs);

		
		
		
		
		
		
		
		
		
		
		
		
		ProductGroup paintings = new ProductGroup();
		paintings.setName("Paintings");
		paintings.setImagesDir("images/paintings/");
		List<Product> paintingsList = new Vector<Product>();
		paintings.setProducts(paintingsList);
		Product q1= new Product();
		q1.setName("Painting1");
		q1.setDescription("Painting1desc");
		q1.setPrice(19.99);
		q1.setImage("images.jpg");
		
		Product q2= new Product();
		q2.setName("Painting2");
		q2.setDescription("Painting2desc");
		q2.setPrice(19.99);
		q2.setImage("images_001.jpg");

		Product q3= new Product();
		q3.setName("Painting3");
		q3.setDescription("Painting3desc");
		q3.setPrice(19.99);
		q3.setImage("images_001_001.jpg");

		Product q4= new Product();
		q4.setName("Painting4");
		q4.setDescription("Painting4desc");
		q4.setPrice(19.99);
		q4.setImage("images_001_002.jpg");

		Product q5= new Product();
		q5.setName("Painting5");
		q5.setDescription("Painting5desc");
		q5.setPrice(19.99);
		q5.setImage("images_002.jpg");

		Product q6= new Product();
		q6.setName("Painting6");
		q6.setDescription("Painting6desc");
		q6.setPrice(19.99);
		q6.setImage("images_003.jpg");

		Product q7= new Product();
		q7.setName("Painting7");
		q7.setDescription("Painting7desc");
		q7.setPrice(19.99);
		q7.setImage("images_004.jpg");

		paintingsList.add(q1);
		paintingsList.add(q2);
		paintingsList.add(q3);
		paintingsList.add(q4);
		paintingsList.add(q5);
		paintingsList.add(q6);
		paintingsList.add(q7);
		
		s.save(q1);
		s.save(q2);
		s.save(q3);
		s.save(q4);
		s.save(q5);
		s.save(q6);
		s.save(q7);
		s.save(paintings);


		tx.commit();
		
	}
}
