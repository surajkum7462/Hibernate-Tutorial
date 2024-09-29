package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaExample {

	
	public static void main(String[] args) {
		Session s=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		
		Criteria c=s.createCriteria(Student.class);
		
//		c.add(Restrictions.eq("certi.course", "Full Stack Java"));
//		c.add(Restrictions.gt("id", 54545));
//		c.add(Restrictions.lt("id", 54545));
		c.add(Restrictions.like("certi.course", "full%"));
		
		List<Student> st=c.list();
		
		for(Student s1:st)
		{
			System.out.println(s1);
		}
		
		
		s.close();
	}
}
