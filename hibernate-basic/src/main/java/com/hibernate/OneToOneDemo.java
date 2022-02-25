package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Answer;
import com.hibernate.entity.Question;

public class OneToOneDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Question q1 = new Question();
		Answer ans1 = new Answer();
		ans1.setAnswer_id(32);
		ans1.setDescription("Programming Language");
		q1.setQuestion_id(12);
		q1.setDescription("What is Java?");
		q1.setAnswer(ans1);
		Question q2 = new Question();
		Answer ans2 = new Answer();
		ans2.setAnswer_id(42);
		ans2.setDescription("API for handling complex objects");
		q2.setQuestion_id(56);
		q2.setDescription("What is Collection?");
		q2.setAnswer(ans2);
		session.save(q1);
		session.save(ans1);
		session.save(q2);
		session.save(ans2);
		tx.commit();
		Question question = session.get(Question.class, 12);
		System.out.println("Question--> " + question.getDescription() + "\n" + "Answer--> "
				+ question.getAnswer().getDescription());
		session.close();
		factory.close();
	}
}
