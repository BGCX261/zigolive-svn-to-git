package com.janiejohnstone.persistance;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.janiejohnstone.persistance.domain.ImageGroup;
import com.janiejohnstone.persistance.domain.ImageInfo;
import com.janiejohnstone.persistance.domain.Page;
import com.janiejohnstone.persistance.domain.TextContent;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
    	return sessionFactory;
    }

    public static Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();
    }
    static {
        try {
        	Configuration cfg = new AnnotationConfiguration()
            .addAnnotatedClass(Page.class)
            .addAnnotatedClass(TextContent.class)
            .addAnnotatedClass(ImageGroup.class)
            .addAnnotatedClass(ImageInfo.class)
            .setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect")
            .setProperty("hibernate.connection.driver_class", "org.apache.derby.jdbc.EmbeddedDriver")
            .setProperty("hibernate.connection.url", "jdbc:derby:bb_domain;create=true")
            .setProperty("hibernate.order_updates", "true")
        	.setProperty("hibernate.current_session_context_class", "thread")
        	.setProperty("hibernate.hbm2ddl.auto", "update")
        	.setProperty("hibernate.show_sql", "true")
        	.setProperty("hibernate.connection.pool_size", "1")
        	;//.setProperty("hibernate.generatorClass","increment");
        	
        	
        	// Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = cfg.buildSessionFactory();
            
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


}