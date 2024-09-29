package com.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		// Creating Employee Table
		Emp e1=new Emp();
		Emp e2=new Emp();
		Emp e3=new Emp();
		
		e1.setEid(12);
		e1.setEname("Ram");
		
		
		e2.setEid(13);
		e2.setEname("Shyam");
		
		
		e3.setEid(123);
		e3.setEname("Sundar");
		
		// Creating Project Table
		
		Project p1=new Project();
		Project p2=new Project();
		
		p1.setPid(2);
		p1.setPname("Library Management System");
		
		p2.setPid(3);
		p2.setPname("Chatbot");
		
		
		List<Emp> l1=new ArrayList<Emp>();
		List<Project> l2=new ArrayList<Project>();
		
		l1.add(e1);
		l1.add(e2);
		l1.add(e3);
		
		l2.add(p1);
		l2.add(p2);
		
		
		e1.setProjects(l2);
		e2.setProjects(l2);
		
		
		
		
		
		
		
		Session s=factory.openSession();
		
		Transaction tx=s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
		
		s.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		factory.close();

	}

}
