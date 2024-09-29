package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		// it is an interface
		SessionFactory factory = cfg.buildSessionFactory();

		Student student1 = new Student();

		student1.setId(54545);
		student1.setName("Shivam");
		student1.setCity("Khorda");

		Certificate certi = new Certificate();

		certi.setCourse("Full Stack Java");
		certi.setDuration("9 Months");

		student1.setCerti(certi);

		Student student3 = new Student();

		student3.setId(7464);
		student3.setName("Chandan");
		student3.setCity("puri");

		Certificate certi3 = new Certificate();

		certi3.setCourse("Full Stack Web");
		certi3.setDuration("8 Months");

		student3.setCerti(certi3);

		Student student2 = new Student();

		student2.setId(674545);
		student2.setName("Rahul");
		student2.setCity("GRD");

		Certificate certi1 = new Certificate();

		certi1.setCourse("Full Stack Development");
		certi1.setDuration("9 Months");

		student2.setCerti(certi1);

		Session s = factory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(student1);
		s.save(student2);
		s.save(student3);
		tx.commit();
		factory.close();

	}

}
