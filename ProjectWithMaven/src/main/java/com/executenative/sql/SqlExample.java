package com.executenative.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SqlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session s=factory.openSession();
		
		//this is sql query
		String q="select * from student";
		
		// if we have to execute native sql then
		NativeQuery nq = s.createSQLQuery(q);
		
		List<Object[]> list=nq.list();
		
		for(Object[] st:list)
		{
//			System.out.println(Arrays.toString(st));
			System.out.println(st[4]+" : "+st[3]);
		}
		
		
		
		
		s.close();
		factory.close();
	}

}
