package com.example;

import java.util.Date;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {

		System.out.println("Hibernate Start");
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		User user = new User();
		user.setName("Santanu");
		user.getHistory().add(new UserHistory(new Date(),"Set name to Santanu"));
		user.getProteinData().setGoal(250);
		user.getHistory().add(new UserHistory(new Date(),"Set the goal to 250"));
		session.save(user);

		session.getTransaction().commit();
		
		session.beginTransaction();
		
		User loadedUser = (User) session.load(User.class, 1);
		System.out.println(loadedUser.getName());
		System.out.println(loadedUser.getProteinData().getGoal());
		for(UserHistory history: loadedUser.getHistory())
		{
			System.out.println(history.getEntryTime().toString() + " " + history.getEntry());
		}
		
		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 50);
		loadedUser.getHistory().add(new UserHistory(new Date(),"Added 50 protein"));
		session.getTransaction().commit();
		
		session.close();
		HibernateUtils.getSessionFactory().close();
		System.out.println("Hibernate End");
	}

}
