package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;
import com.hibernate.entity.Project;

public class MappingDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// one to one mapping
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
		// one to many mapping
		/*
		 * Question question = new Question(); List<Answer> answers = new ArrayList<>();
		 * Answer ans1 = new Answer(); ans1.setAnswer_id(1);
		 * ans1.setDescription("Programming Language"); Answer ans2 = new Answer();
		 * ans2.setAnswer_id(2); ans2.setDescription("Based on OOPS Concepts"); Answer
		 * ans3 = new Answer(); ans3.setAnswer_id(3);
		 * ans3.setDescription("Both of the above"); answers.add(ans1);
		 * answers.add(ans2); answers.add(ans3); question.setQuestion_id(1);
		 * question.setDescription("What is Java?"); question.setAnswer(answers);
		 * ans1.setQuestion(question); ans2.setQuestion(question);
		 * ans3.setQuestion(question); session.save(question); session.save(ans1);
		 * session.save(ans2); session.save(ans3);
		 */
		List<Project> project1 = new ArrayList<>();
		List<Project> project2 = new ArrayList<>();
		List<Project> project3 = new ArrayList<>();
		List<Employee> employee1 = new ArrayList<>();
		List<Employee> employee2 = new ArrayList<>();
		List<Employee> employee3 = new ArrayList<>();
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		Project proj1 = new Project();
		Project proj2 = new Project();
		Project proj3 = new Project();
		emp1.setId(1);
		emp1.setEname("Rahul");
		emp1.setProjects(project1);
		emp2.setId(2);
		emp2.setEname("Ajay");
		emp2.setProjects(project2);
		emp3.setId(3);
		emp3.setEname("Ram");
		emp3.setProjects(project3);
		proj1.setId(1);
		proj1.setPname("Library Management");
		proj1.setEmployees(employee1);
		proj2.setId(2);
		proj2.setPname("Employee Management");
		proj2.setEmployees(employee2);
		proj3.setId(3);
		proj3.setPname("Attendance Management");
		proj3.setEmployees(employee3);
		project1.add(proj1);
		project1.add(proj2);
		project2.add(proj2);
		project2.add(proj3);
		project3.add(proj3);
		project3.add(proj1);
		employee1.add(emp1);
		employee1.add(emp2);
		employee2.add(emp2);
		employee2.add(emp3);
		employee3.add(emp3);
		employee3.add(emp1);
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(proj1);
		session.save(proj2);
		session.save(proj3);

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
