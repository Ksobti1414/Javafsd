package com.test;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
public class Criteria {
 public static void main(String[]args) {
	 Configuration cfg=new Configuration();
	 cfg.configure("hibernate.cfg.xml");
	 SessionFactory sf=cfg.buildSessionFactory();
	 Session session=sf.openSession();
	 Transaction t=session.beginTransaction();
	 CriteriaBuilder cb=session.getCriteriaBuilder();
	 CriteriaQuery<Cricketer>cq=cb.createQuery(Cricketer.class);
	 cq.distinct(true);
	 Root<Cricketer>rt=cq.from(Cricketer.class);
	 cq.select(rt);
	 TypedQuery<Cricketer>tq=session.createQuery(cq);
	 List<Cricketer>list=tq.getResultList();
	 System.out.println(list);
 }
}

