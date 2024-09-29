package com.lazy.eager;

import java.util.ArrayList;
import java.util.List;

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
		
		
		//creating Many answer
		Answer ans=new Answer();
		ans.setAnswerId(342);
		ans.setAnswer("Java is Programming Language");
		
		ans.setQuestion(q1);
		
		
		
		Answer ans1 = new Answer();
		ans1.setAnswerId(33);
		ans1.setAnswer("Java is Independent Language");

		ans1.setQuestion(q1);
		
		

		Answer ans2 = new Answer();
		ans2.setAnswerId(363);
		ans2.setAnswer("Java has different types of framework");

		ans2.setQuestion(q1);
		
		List<Answer> list=new ArrayList<Answer>();
		list.add(ans);
		list.add(ans1);
		list.add(ans2);
		q1.setAnswer(list);
		
		
		
		
		
		
		
		
		
		
		
		//session
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		//save
		s.save(q1);
		
		
//		
		Question q=(Question)s.get(Question.class, 1212);
		
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		
		
		
//		
		tx.commit();
		
		
		
       
//		s.save(ans);
//		s.save(ans1);
//		s.save(ans2);
//		
		
		
		
		//fetching
		
		/*
		 * Question newQ=(Question)s.get(Question.class, 1212);
		 * System.out.println(newQ.getQuestionId());
		 * System.out.println(newQ.getQuestion());
		 */
		
		
		
		s.close();
		factory.close();

	}

}
