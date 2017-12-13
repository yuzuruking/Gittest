package com.jnmd.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final SessionFactory factory;
    
    static{
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        factory = config.buildSessionFactory();
    }
    
    public static SessionFactory getFactory(){
        return factory;
    }
    public static void closeFactory(){
        if (factory != null) {
            factory.close();
        }
    }
    public static void closeSession(Session session){
        if (session != null) {
            session.close();
        }
    }
    
    
    
    
}
