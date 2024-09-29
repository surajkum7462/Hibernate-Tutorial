package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {
	
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		
		
		Session s=factory.openSession();
		
		//HQL
		//Syntax
		
//		String query="from Student";
//		String query="from Student where city='grd'";
		// we can write another way
//		String query="from Student where city=:x";
		
		String query="from Student as s where s.city=:x and s.name=:n";
		
		Query q=s.createQuery(query);
//		q.setParameter("x", "grd");
		
		q.setParameter("x", "grd");
		q.setParameter("n", "rahul");
		
		
		
		
		//single(Unique)
		//q.uniqueResult();
		
		//multiple(List)
		
		List<Student> list=q.list();
		
		for(Student st:list)
		{
			System.out.println(st.getName()+":"+st.getCerti().getCourse()+":");
		}
		
		
		System.out.println("_______________________");
		// for deleting data i have to do transaction
      	Transaction tx=s.beginTransaction();
//		 Query q2=s.createQuery("delete from Student s where s.city=:c");
//		
//		q2.setParameter("c","grd");
//		int r=q2.executeUpdate();
//		System.out.println("Deleted row:"+r);
		
		
		
		// Now Query for update
      	Query q3=s.createQuery("update Student set city=:c where name=:n");
		q3.setParameter("c", "Mumbai");
		q3.setParameter("n","Shivam");
		int r=q3.executeUpdate();
		System.out.println("Updated rows:"+r);
		
		//name update
		Query q4=s.createQuery("update Student set name=:n where city=:c");
		q4.setParameter("n", "Rahul Kumar");
		q4.setParameter("c","Mumbai");
		
		int r1=q4.executeUpdate();
		System.out.println("Updated rows:"+r1);
		tx.commit();
		
		
		Query q5=s.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answer as a");
		
	List<Object[]> list3	=q5.getResultList();
	
	for(Object[] arr:list3)
	{
		System.out.println(Arrays.toString(arr));
	}
		
		
		
		s.close();
		factory.close();
		
	}

}
