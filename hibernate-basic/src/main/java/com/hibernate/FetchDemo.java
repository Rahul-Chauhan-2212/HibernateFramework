package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Address;
import com.hibernate.entity.Student;

public class FetchDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Student student = session.get(Student.class, 1);
		System.out.println(student);
		Address address = session.load(Address.class, 2);
		System.out.println(address.getCity());
		session.close();
		factory.close();
	}
}
