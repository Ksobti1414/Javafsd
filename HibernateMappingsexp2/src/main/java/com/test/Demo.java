package com.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo {
	public static void main(String[]args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory sf=cfg.buildSessionFactory();
	Session session=sf.openSession();
	Transaction t=session.beginTransaction();
	Order o1=new Order();
	o1.setO_name("Lifestyle");
	Order o2=new Order();
	o2.setO_name("ABC");
	List<Order>list=Arrays.asList(o1,o2);
	Users u=new Users();
	u.setU_name("Rohit");
	u.setCity("Mumbai");
	u.setOrders(list);
//	emp.setE_name("Rohit");
//	emp.setE_company("ABC");
//	emp.setAddress(adr);
	o1.setUser(u);
	o2.setUser(u);
	session.persist(u);
	t.commit();
	System.out.println("Done");
	session.close(); 
}
}
