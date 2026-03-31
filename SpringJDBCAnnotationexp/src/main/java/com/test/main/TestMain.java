package com.test.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.DBconfig;
import com.test.dao.BookDao;
import com.test.model.Book;

public class TestMain {
public static void main(String[]args) {
	ApplicationContext ctx=new AnnotationConfigApplicationContext(DBconfig.class);
	BookDao dao=ctx.getBean(BookDao.class);
	Book book=new Book();
	book.setId(301);
	book.setB_name("Quotes of mR v");
	book.setB_author("Vivekanand");
	book.setB_price(900);
	//dao.saveBooks(book); 
	//dao.updateBooks(book);
	dao.deleteBook(book);
	System.out.println("Done");
}
}
