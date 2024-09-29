package com.obj.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {

	public static void main(String[] args) {
	 
		//Transient State
		//Persistent State
		//Detached State
		//Removed State
		System.out.println("Running:");
		
		SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Creating Student object
		Student st=new Student();
		st.setId(1414);
		st.setName("Suraj");
		st.setCity("Grd");
		st.setCerti(new Certificate("Hibernate","2 Months"));
		// st:transient State
		
		
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		
		s.save(st);
		//st:Persistent -session,database(obj)
		
		st.setName("Rahul");//name is changed
		s.delete(st);//delete the data
		
		tx.commit();
		
		
		s.close();
		//st:Detached
		
		
//		st.setName("Shivam");//name is not updated because session is closed
//		
//		System.out.println(st);
		
		
		
		
		
		
		
		f.close();

	}

}
