package com.jnmd.hibernate.hql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_person")

public class Person {
    @Id
    @GeneratedValue
    private int pid;
    
    @Column(name="userName")
    private String name;
    private int age;
    public Person() {
        super();
    }
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public Person(int pid, String name, int age) {
        super();
        this.pid = pid;
        this.name = name;
        this.age = age;
    }
    public Person(int pid,String name){
        this.pid = pid;
        this.name = name;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [pid=" + pid + ", name=" + name + ", age=" + age + "]";
    }
    
    
}
