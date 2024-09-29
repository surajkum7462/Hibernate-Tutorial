package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session s=factory.openSession();
		//by default enabled
		Student st=(Student)s.get(Student.class, 54545);
		System.out.println(st);
		
		
		
		System.out.println("After working something");
		
		Student st1=(Student)s.get(Student.class, 54545);
		
		System.out.println(st1);
		
		
		System.out.println(s.contains(st1));

		s.close();
	}

}
