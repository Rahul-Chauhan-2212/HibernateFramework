package com.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Address;
import com.hibernate.entity.Student;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Student student = new Student();
		student.setName("Rahul Chauhan");
		student.setCollege("KIET");
		Address address = new Address();
		address.setStreet("street1");
		address.setCity("Delhi");
		address.setIsOpen(true);
		address.setX(46.78);
		address.setAddedDate(new Date());
		try {
			FileInputStream fis = new FileInputStream("C://Users/RAHUL CHAUHAN/Pictures/rahul.jpg");
			byte[] data = new byte[fis.available()];
			fis.read(data);
			fis.close();
			address.setImage(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Transaction tx = session.beginTransaction();
		session.save(student);
		session.save(address);
		tx.commit();
		session.close();
	}
}
