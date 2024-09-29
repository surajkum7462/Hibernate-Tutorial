package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.OneToMany.Answer;
import com.OneToMany.Question;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session s=factory.openSession();
		
		Question q1 = new Question();
		q1.setQuestionId(232);
		q1.setQuestion("What is SpringBott?");
		
		
		Answer a1 = new Answer(454,"Spring Boot is works for backend");
		Answer a2 = new Answer(213,"2nd answer");
		Answer a3 = new Answer(12323,"3rd anser");
		
		List<Answer> list=new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswer(list);
		
		Transaction tx=s.beginTransaction();
		
		
		s.save(q1);
		
		tx.commit();
		
		
		
		
		
		
		
		
		
		s.close();
		factory.close();
	}

}
