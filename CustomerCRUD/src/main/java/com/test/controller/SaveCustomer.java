package com.test.controller;

import java.io.*;

import com.test.dao.CustomerDao;
import com.test.dao.CustomerDaoImpl;
import com.test.model.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class SaveCustomer
 */
@WebServlet("/SaveCustomer")
public class SaveCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SaveCustomer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("test/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String city=request.getParameter("city");
		Customer obj=new Customer();
		obj.setName(name);
		obj.setEmail(email);
		obj.setCity(city);
		CustomerDaoImpl daoObj=new CustomerDaoImpl();
		int x=daoObj.saveCustomer(obj);
		if(x>0) {
			response.sendRedirect("index.jsp");
		}
		else {
			out.println("<font color='red'>Customer Not Saved.</font>");
			RequestDispatcher rd=request.getRequestDispatcher("customerform.jsp");
			rd.include(request, response);
		}
	}

}
