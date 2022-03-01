package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Member;
import com.hibernate.entity.Team;

public class LoadingDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session openSession = factory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();

//		Team team = new Team();
//		List<Member> members = new ArrayList<>();
//		Member member1 = new Member();
//		Member member2 = new Member();
//		team.setTeamname("Invincible");
//		member1.setMember_id(1);
//		member1.setMembername("Rahul");
//		member1.setTeam(team);
//		member2.setMember_id(2);
//		member2.setMembername("Karan");
//		member2.setTeam(team);
//		members.add(member1);
//		members.add(member2);
//		team.setTeam_id(1);
//		team.setMembers(members);
//		openSession.save(team);
//		openSession.save(member1);
//		openSession.save(member2);

		Team team = openSession.get(Team.class, 1);
		System.out.println(team.getTeamname());
		System.out.println(team.getTeam_id());
		// Eager Loading query
//		select
//        team0_.team_id as team_id1_7_0_,
//        team0_.teamname as teamname2_7_0_,
//        members1_.team_team_id as team_tea3_8_1_,
//        members1_.member_id as member_i1_8_1_,
//        members1_.member_id as member_i1_8_2_,
//        members1_.membername as memberna2_8_2_,
//        members1_.team_team_id as team_tea3_8_2_ 
//    from
//        Team team0_ 
//    left outer join
//        Team_Member members1_ 
//            on team0_.team_id=members1_.team_team_id 
//    where
//        team0_.team_id=?
		// Lazy Loading query and lazy loading is default
//		 select
//	        team0_.team_id as team_id1_7_0_,
//	        team0_.teamname as teamname2_7_0_ 
//	    from
//	        Team team0_ 
//	    where
//	        team0_.team_id=?
		for (Member member : team.getMembers()) {
			System.out.println(member.getMember_id() + "-->" + member.getMembername());
		}

		beginTransaction.commit();
		openSession.close();
		factory.close();

	}

}
