package com.zigolive.utils;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.zigolive.bb.domain.Page;
import com.zigolive.bb.domain.Product;
import com.zigolive.bb.domain.ProductGroup;
import com.zigolive.bb.domain.Test;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
    	return sessionFactory;
    }

    static {
        try {
        	Configuration cfg = new AnnotationConfiguration()
            .addAnnotatedClass(Test.class)
            .addAnnotatedClass(Product.class)
            .addAnnotatedClass(Page.class)
            .addAnnotatedClass(ProductGroup.class)
            .setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect")
            .setProperty("hibernate.connection.driver_class", "org.apache.derby.jdbc.EmbeddedDriver")
            .setProperty("hibernate.connection.url", "jdbc:derby:/bb_domain;create=true")
            .setProperty("hibernate.order_updates", "true")
        	.setProperty("hibernate.current_session_context_class", "thread")
        	.setProperty("hibernate.hbm2ddl.auto", "create-drop")
        	.setProperty("hibernate.show_sql", "true")
        	.setProperty("hibernate.connection.pool_size", "1");
        	
        	// Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = cfg.buildSessionFactory();
            
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


}