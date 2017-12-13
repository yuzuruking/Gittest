package com.jnmd.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jnmd.hibernate.domain.User;
import com.jnmd.hibernate.util.HibernateUtils;

public class Test {
    public User save(User user){
        SessionFactory factory = HibernateUtils.getFactory();
        
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally{
            HibernateUtils.closeSession(session);
        }
        /*// 在应用程序结束时关闭
        factory.close();*/
        return user;
    }
    
    public User updateUser(User user){
        SessionFactory factory = HibernateUtils.getFactory();
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(user);
            
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally{
            HibernateUtils.closeSession(session);
        }
        return user;
    }
    
    public void delUser(User user){
        SessionFactory factory = HibernateUtils.getFactory();
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.delete(user);
            
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally{
            HibernateUtils.closeSession(session);
        }
    }
    
    
    public User getUser(int id){
        SessionFactory factory = HibernateUtils.getFactory();
        User user = null;
        Session session = null;
        
        try {
            session = factory.openSession();
            user = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            HibernateUtils.closeSession(session);
        }
        
        return user;
    }
    
    public User loadUser(int id){
        SessionFactory factory = HibernateUtils.getFactory();
        User user = null;
        Session session = null;
        
        try {
            session = factory.openSession();
            user = session.load(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            HibernateUtils.closeSession(session);
        }
        
        return user;
    }
    
    
    public static void main(String[] args) {
        Test test = new Test();
        /*
        //添加
        User user = new User("王五","123654",25);
        test.save(user);
        System.out.println(user);
        */
        
        /*
        //修改
        User user = new User(2,"王五","654321",25);
        user = test.updateUser(user);
        System.out.println(user);
        */
        
        /*
        //删除
        User user = new User();
        user.setId(2);
        test.delUser(user);
        */
        
        
        //get查询
        User user = test.getUser(1);
        System.out.println(user);
        
        
        /*
        //load查询
        User user = test.loadUser(1);
        System.out.println(user);
        */
    }

}
