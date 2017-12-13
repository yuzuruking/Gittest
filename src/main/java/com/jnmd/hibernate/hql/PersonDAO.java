package com.jnmd.hibernate.hql;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jnmd.hibernate.util.HibernateUtils;

public class PersonDAO {
    private static final String FIND_PERSON_BY_NAME_AND_AGE = "select p from Person p where p.name=:name and p.age=:age";
    private static final String FIND_PERSONS = "from Person";
    private static final String FIND_PERSON_BY_NAME = "from Person where name = ?";
    private static final String FIND_PERSON_BY_AGE_RANGE = "from Person p where p.age between ? and ?";
    private static final String FIND_ID_MAX = "select max(pid) from Person";
    private static final String FIND_PERSON = "select new Person(pid,name) from Person";
    private static final String FIND_PERSON2 = "select pid,name from Person";
    //姓名年龄查询
    public List<Person> queryPerson(String name,int age) {
       Session session =  HibernateUtils.getFactory().openSession();
       Query query = session.createQuery(FIND_PERSON_BY_NAME_AND_AGE);
       query.setString("name", name);
       query.setInteger("age", age);
       
       List<Person> list = query.list();
       HibernateUtils.closeSession(session);
       return list;
    }
    //分页查询
    public List<Person> queryPerson(int start,int number) {
        Session session =  HibernateUtils.getFactory().openSession();
        Query query = session.createQuery(FIND_PERSONS);
        query.setFirstResult(start);
        query.setMaxResults(number);
        
        List<Person> list = query.list();
        HibernateUtils.closeSession(session);
        return list;
    }
    //姓名查询
    public Person getPerson(String name){
        Session session = HibernateUtils.getFactory().openSession();
        Query query = session.createQuery(FIND_PERSON_BY_NAME);
        
        query.setString(0, name);
        Person p = (Person)query.uniqueResult();
        
        HibernateUtils.closeSession(session);
        return p;
    }
    //年龄范围查询
    public List<Person> getPerson(int start,int end){
        Session session = HibernateUtils.getFactory().openSession();
        Query query = session.createQuery(FIND_PERSON_BY_AGE_RANGE);
        
        query.setInteger(0, start);
        query.setInteger(1, end);
        
        List<Person> list = query.list();
        HibernateUtils.closeSession(session);
        return list;
    }
    //最大ID查询
    public int findMaxId(){
        Session session = HibernateUtils.getFactory().openSession();
        Query query = session.createQuery(FIND_ID_MAX);
        
        Object obj = query.uniqueResult();
        HibernateUtils.closeSession(session);
        return (Integer)obj;
    }
    //查询部分属性
    public List<Person> getPersons(){
        Session session = HibernateUtils.getFactory().openSession();
        Query query = session.createQuery(FIND_PERSON);
        
        List<Person> list = query.list();
        
        HibernateUtils.closeSession(session);
        
        return list;
    }
    
    public List<Person> getPersons2(){
        Session session = HibernateUtils.getFactory().openSession();
        Query query = session.createQuery(FIND_PERSON2);
        
        List<Object[]> objs = query.list();
        
        HibernateUtils.closeSession(session);
        
        List<Person> list = new ArrayList<Person>();
        Person p;
        for(Object[] arrs : objs){
            int pid = (Integer)arrs[0];
            String name = (String)arrs[1];
            p = new Person(pid,name);
            list.add(p);
        }
        return list;
        
        
    }
}
