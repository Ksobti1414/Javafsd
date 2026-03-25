package com.test;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.*;
/**
 * Application Lifecycle Listener implementation class Mylistener
 *
 */
@WebListener
public class Mylistener implements HttpSessionListener {
    public static ServletContext ctx=null;
    public static int current,total=0;
    /**
     * Default constructor. 
     */
    public Mylistener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	total++;
    	current++;
    	ctx=se.getSession().getServletContext();
    	ctx.setAttribute("tusers",total);
    	ctx.setAttribute("cusers",current);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	current--;
    	ctx.setAttribute("cusers", current);
    }
	
}
