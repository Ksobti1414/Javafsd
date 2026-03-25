package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HQLTest {
  public static void main(String[] args) {
	  Session session=HibernateUtil.getSessionFactory().openSession();
	  Transaction t=session.beginTransaction();
	  //String hql="select o.o_name,o_quantity,o_price from Order o";
	  String hql1="delete from Order where id=:id";
	  Query query=session.createQuery(hql1);
	  query.setParameter("id", 102);
	  query.executeUpdate();
	  t.commit();
	  String hql="from Order";
	  Query<Cricketer>q=session.createQuery(hql,Cricketer.class);
	  List<Cricketer>list=q.getResultList();
	  list.forEach(dt->System.out.println(dt.getC_name()+" "+dt.getC_team()));
  }
}
