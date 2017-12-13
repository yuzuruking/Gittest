package com.jnmd.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jnmd.hibernate.domain.User;
import com.jnmd.hibernate.util.HibernateUtils;

public class TetSession {

    public static void main(String[] args) {

        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();

        Session session = null;
        Transaction transaction = null;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            User user = new User("test","987456",18);
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }
        /*
         * // 在应用程序结束时关闭 factory.close();
         */
    }

}
