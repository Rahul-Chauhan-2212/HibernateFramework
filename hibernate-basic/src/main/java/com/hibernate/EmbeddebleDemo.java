package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Student;

public class EmbeddebleDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Course course = new Course();
		course.setCourse_name("Java");
		course.setDuration("2 Months");
		Student student = new Student();
		student.setName("Rahul Chauhan");
		student.setCollege("KIET");
		student.setCourse(course);
		session.save(student);
		tx.commit();
		session.close();
		factory.close();

	}

}
