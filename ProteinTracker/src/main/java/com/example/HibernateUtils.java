package com.example;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static
	{
		try {
			Configuration configuration = new Configuration().configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory =  configuration.buildSessionFactory(serviceRegistry);
		}
		catch(HibernateException hibernateException) {
			System.out.println("Problem Creating Session Factory"+hibernateException.getMessage());
		}
		
	}
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	

}
