package com.janiejohnstone.persistance;

import org.hibernate.Transaction;


import com.janiejohnstone.persistance.domain.ImageGroup;
import com.janiejohnstone.persistance.domain.ImageInfo;
import com.janiejohnstone.persistance.domain.Page;
import com.janiejohnstone.persistance.domain.TextContent;

public class BootStrapDB {

	public static void init(){
		Transaction tx = HibernateUtil.getCurrentSession().beginTransaction();

		/////////////////////////////////////////
		////    TEXT CONTENTS FOR PAGES     /////
		/////////////////////////////////////////
		TextContent tp1 = new TextContent();
		tp1.setText("Content for page 1");
		HibernateUtil.getCurrentSession().save(tp1);
		TextContent tp2 = new TextContent();
		tp2.setText("Content for page 2");
		HibernateUtil.getCurrentSession().save(tp2);
		TextContent tp3 = new TextContent();
		tp3.setText("Content for page 3");
		HibernateUtil.getCurrentSession().save(tp3);
		TextContent tp4 = new TextContent();
		tp4.setText("Content for page 4");
		HibernateUtil.getCurrentSession().save(tp4);
		TextContent tp5 = new TextContent();
		tp5.setText("Content for page 5");
		HibernateUtil.getCurrentSession().save(tp5);
		TextContent tp6 = new TextContent();
		tp6.setText("Content for page 6");
		HibernateUtil.getCurrentSession().save(tp6);
		TextContent tp7 = new TextContent();
		tp7.setText("Content for page 7");
		HibernateUtil.getCurrentSession().save(tp7);
		TextContent tp8 = new TextContent();
		tp8.setText("Content for page 8");
		HibernateUtil.getCurrentSession().save(tp8);
		
		/////////////////////////////////////////
		////    SET CONTENT FOR PAGES       /////
		/////////////////////////////////////////
		Page page_1 = new Page();
		//page_1.setCentralContent(tp1);
		Page page_2 = new Page();
		//page_2.setCentralContent(tp2);
		Page page_3 = new Page();
		//page_3.setCentralContent(tp3);
		Page page_4 = new Page();
		//page_4.setCentralContent(tp4);
		Page page_5 = new Page();
		//page_5.setCentralContent(tp5);
		Page page_6 = new Page();
		//page_6.setCentralContent(tp6);
		Page page_7 = new Page();
		//page_7.setCentralContent(tp7);
		Page page_8 = new Page();
		//page_8.setCentralContent(tp8);
		HibernateUtil.getCurrentSession().save(page_1);
		HibernateUtil.getCurrentSession().save(page_2);
		HibernateUtil.getCurrentSession().save(page_3);
		HibernateUtil.getCurrentSession().save(page_4);
		HibernateUtil.getCurrentSession().save(page_5);
		HibernateUtil.getCurrentSession().save(page_6);
		HibernateUtil.getCurrentSession().save(page_7);
		HibernateUtil.getCurrentSession().save(page_8);
		
		ImageInfo il = new ImageInfo();
		il.setDescription("This is the description");
		il.setLink(page_1);
		il.setSrc("images/chairs/images.jpg");
		HibernateUtil.getCurrentSession().save(il);
		// TODO Add your page's components here   
		ImageInfo il2 = new ImageInfo();
		il2.setDescription("This is the description");
		il2.setLink(page_2);
		il2.setSrc("images/chairs/images_001.jpg");
		HibernateUtil.getCurrentSession().save(il2);
		ImageInfo il3 = new ImageInfo();
		il3.setDescription("This is the description");
		il3.setLink(page_3);
		il3.setSrc("images/chairs/images_001.jpg");
		HibernateUtil.getCurrentSession().save(il3);
		// TODO Add your page's components here   
		ImageInfo il4 = new ImageInfo();
		il4.setDescription("This is the description");
		il4.setLink(page_4);
		il4.setSrc("images/chairs/images_001.jpg");
		HibernateUtil.getCurrentSession().save(il4);
		ImageInfo il5 = new ImageInfo();
		il5.setDescription("This is the description");
		il5.setLink(page_5);
		il5.setSrc("images/chairs/images_001.jpg");
		HibernateUtil.getCurrentSession().save(il5);
		// TODO Add your page's components here   
		ImageInfo il6 = new ImageInfo();
		il6.setDescription("This is the description");
		il6.setLink(page_6);
		il6.setSrc("images/chairs/images_001.jpg");
		HibernateUtil.getCurrentSession().save(il6);
		ImageInfo il7 = new ImageInfo();
		il7.setDescription("This is the description");
		il7.setLink(page_7);
		il7.setSrc("images/chairs/images_001.jpg");
		HibernateUtil.getCurrentSession().save(il7);
		// TODO Add your page's components here   
		ImageInfo il8 = new ImageInfo();
		il8.setDescription("This is the description");
		il8.setLink(page_8);
		il8.setSrc("images/chairs/images_001.jpg");
		HibernateUtil.getCurrentSession().save(il8);
		// TODO Add your page's components here   
		ImageGroup ig = new ImageGroup();
		ig.getImages().add(il);
		ig.getImages().add(il2);
		ig.getImages().add(il3);
		ig.getImages().add(il4);
		ig.getImages().add(il5);
		ig.getImages().add(il6);
		ig.getImages().add(il7);
		ig.getImages().add(il8);
		HibernateUtil.getCurrentSession().save(ig);
		
		Page homePage = new Page();
		homePage.setImageGroup(ig);
		TextContent textIndex = new TextContent();
		textIndex.setText("This is the central page content");
		//homePage.setCentralContent(textIndex);
		homePage.setHomePage(true);
		HibernateUtil.getCurrentSession().save(textIndex);
		HibernateUtil.getCurrentSession().save(homePage);
		
		tx.commit();
	}
}
