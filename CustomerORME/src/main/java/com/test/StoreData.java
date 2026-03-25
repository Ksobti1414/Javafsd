
package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	
	public static void main(String[] args) {
		    
		//Configuration cfg = new Configuration();
		
		//cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
	
		Customer c = new Customer();
		
		c.setCust_name("Rohit");
		c.setCust_city("Mumbai");
		c.setCust_state("Maharashtra");
		
		session.persist(c);
		List<Customer>list=session.createQuery("from Customer",Customer.class).list();
		list.forEach(dt->System.out.println(dt.getId()+" "+dt.getCust_name()+" "+dt.getCust_city()+" "+dt.getCust_state()));
		
		//t.commit();
		/*
		Customer obj=session.find(Customer.class,1);
		System.out.println(obj.getId()+" "+obj.getCust_name()+" "+obj.getCust_city()+" "+obj.getCust_state());
		obj.setCust_name("Sharma");
		obj.setCust_city("Chennai");
		obj.setCust_state("Tamil Nadu");
		//session.REMOVE(obj);
		t.commit();
		System.out.println("Done.");
		*/
		session.close();
		
	}
}

