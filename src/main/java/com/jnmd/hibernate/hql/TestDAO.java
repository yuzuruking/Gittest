package com.jnmd.hibernate.hql;

import java.util.List;

import com.jnmd.hibernate.util.PageConst;

public class TestDAO {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        
        /*List<Person> persons = personDAO.queryPerson("zhangsan", 21);
        for(Person p : persons){
            System.out.println(p);
        }*/
        /*
        //分页查询
        System.out.println("第一次");
        List<Person> persons = personDAO.queryPerson(0, 2);
        for(Person p : persons){
            System.out.println(p);
        }
        
        System.out.println("第二次");
        persons = personDAO.queryPerson(0, PageConst.pageNumberMin);
        for(Person p : persons){
            System.out.println(p);
        }*/
        
        /*
        //姓名查询
        Person p = personDAO.getPerson("lisi");
        System.out.println(p);*/
        
        /*
        //年龄范围
        List<Person> persons = personDAO.getPerson(18, 30);
        for(Person p : persons){
            System.out.println(p);
        }*/
        
        /*
        //查询最大id
        int maxPid = personDAO.findMaxId();
        System.out.println(maxPid);*/
        
        /*
        //查询部分属性
        List<Person> persons = personDAO.getPersons();
        for(Person p : persons){
            System.out.println(p);
        }*/
        
        personDAO.getPersons2();
        
        
    }

}
