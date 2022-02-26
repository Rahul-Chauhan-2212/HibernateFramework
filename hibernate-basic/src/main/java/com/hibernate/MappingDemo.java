package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Answer;
import com.hibernate.entity.Question;

public class MappingDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/*
		 * Question q1 = new Question(); Answer ans1 = new Answer();
		 * ans1.setAnswer_id(32); ans1.setDescription("Programming Language");
		 * q1.setQuestion_id(12); q1.setDescription("What is Java?");
		 * q1.setAnswer(ans1); Question q2 = new Question(); Answer ans2 = new Answer();
		 * ans2.setAnswer_id(42);
		 * ans2.setDescription("API for handling complex objects");
		 * q2.setQuestion_id(56); q2.setDescription("What is Collection?");
		 * q2.setAnswer(ans2); session.save(q1); session.save(ans1); session.save(q2);
		 * session.save(ans2);
		 */
		Question question = new Question();
		List<Answer> answers = new ArrayList<>();
		Answer ans1 = new Answer();
		ans1.setAnswer_id(1);
		ans1.setDescription("Programming Language");
		Answer ans2 = new Answer();
		ans2.setAnswer_id(2);
		ans2.setDescription("Based on OOPS Concepts");
		Answer ans3 = new Answer();
		ans3.setAnswer_id(3);
		ans3.setDescription("Both of the above");
		answers.add(ans1);
		answers.add(ans2);
		answers.add(ans3);
		question.setQuestion_id(1);
		question.setDescription("What is Java?");
		question.setAnswer(answers);
		ans1.setQuestion(question);
		ans2.setQuestion(question);
		ans3.setQuestion(question);
		session.save(question);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		tx.commit();
		/*
		 * Question question = session.get(Question.class, 12);
		 * System.out.println("Question--> " + question.getDescription() + "\n" +
		 * "Answer--> " + question.getAnswer().getDescription());
		 */
		session.close();
		factory.close();
	}
}
