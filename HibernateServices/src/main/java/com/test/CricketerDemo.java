package com.test;

import java.util.List;

public class CricketerDemo {
  public static void main(String[] args) {
	  CricketerDao odao=new CricketerDao();
	  Cricketer obj=new Cricketer();
	  obj.setC_name("Rohit");
	  obj.setC_team("Mumbai");
	 odao.saveOrder(obj);
//	  List<Order>list=odao.listAllOrders();
//	  list.forEach(dt->System.out.println(dt.getId()+" "+dt.getO_name()+" "+dt.getO_quantity()+" "+dt.getO_price()));
//	  System.out.println("Done.");
  }
}
