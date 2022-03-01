package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Member;
import com.hibernate.entity.Team;

public class StateDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session openSession = factory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Team team = new Team();
		List<Member> members = new ArrayList<>();
		Member member1 = new Member();
		Member member2 = new Member();
		team.setTeamname("Invincible");
		member1.setMember_id(1);
		member1.setMembername("Rahul");
		member1.setTeam(team);
		member2.setMember_id(2);
		member2.setMembername("Karan");
		member2.setTeam(team);
		members.add(member1);
		members.add(member2);
		team.setTeam_id(1);
		team.setMembers(members);
		//transient state
		openSession.save(team);
		openSession.save(member1);
		openSession.save(member2);	
		//persistent state
		beginTransaction.commit();
		openSession.close();
		//detached state
		member1.setMembername("kigj");
		factory.close();
		
		
	}

}
