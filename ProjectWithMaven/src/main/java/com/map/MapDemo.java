package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		
		//Question-1
		
		//Creating Question
		Question q1=new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java?");
		
		
		//creating answer
		Answer ans=new Answer();
		ans.setAnswerId(342);
		ans.setAnswer("Java is Programming Language");
		q1.setAnswer(ans);
		ans.setQuestion(q1);
		
		
		
		
		//Question-2
		
				//Creating Question
				Question q2=new Question();
				q2.setQuestionId(242);
				q2.setQuestion("What is collection Framework?");
				
				
				//creating answer
				Answer ans1=new Answer();
				ans1.setAnswerId(344);
				ans1.setAnswer("API to work with group of objects");
				ans1.setQuestion(q2);
				q2.setAnswer(ans1);
		
		
		
		
		
		//session
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		//save
		s.save(q1);
		s.save(ans);
		
		s.save(q2);
		s.save(ans1);
		
		tx.commit();
		
		
		//fetching
		
		Question newQ=(Question)s.get(Question.class, 1212);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());
		s.close();
		factory.close();

	}

}
