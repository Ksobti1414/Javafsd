package com.test;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class CricketerDao {
public static SessionFactory getDBSessionF() {
	SessionFactory factory=null;
	try {
		//Configuration cfg=new Configuration();
		//cfg.configure("hibernate.cfg.xml");
		factory=HibernateUtil.getSessionFactory();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return factory;
}
public void saveOrder(Cricketer obj) {
	Session session=CricketerDao.getDBSessionF().openSession();
	Transaction t=session.beginTransaction();
	session.persist(obj);
	t.commit();
	session.close();
	
}
public List<Cricketer>listAllOrders(){
	Session session=CricketerDao.getDBSessionF().openSession();
	Transaction t=session.beginTransaction();
	Query<Cricketer>q=session.createQuery("from Order",Cricketer.class);
	List<Cricketer>list=q.list();
	session.close();
	return list;
}
public void updateOrder(Cricketer obj) {
	Session session=CricketerDao.getDBSessionF().openSession();
	Transaction t=session.beginTransaction();
	Cricketer dt=session.find(Cricketer.class,obj.getId());
	dt.setC_name(obj.getC_name());
	dt.setC_team(obj.getC_team());
	session.persist(dt);
	t.commit();
	session.close();
}
public void deleteOrder(Cricketer obj) {
	Session session=CricketerDao.getDBSessionF().openSession();
	Transaction t=session.beginTransaction();
	session.remove(obj);
	t.commit();
	session.close();
}
}
