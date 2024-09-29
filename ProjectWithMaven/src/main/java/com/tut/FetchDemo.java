package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String[] args) {
		 Configuration cfg=new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        // it is an interface
	        SessionFactory factory=cfg.buildSessionFactory();
	         Session session=factory.openSession();
	         //get-student:104
	         
	         Student student=  (Student)session.load(Student.class, 105);
	         System.out.println(student);
	         
	         Address ad=(Address)session.get(Address.class, 1);
	        System.out.println(ad.getStreet()+":"+ad.getCity());
	        
	        Address ad1=(Address)session.get(Address.class, 1);
	        System.out.println(ad1.getStreet()+":"+ad1.getCity());
	      session.close();
	      factory.close();
	}

}
