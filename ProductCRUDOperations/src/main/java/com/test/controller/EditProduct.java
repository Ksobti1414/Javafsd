package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.test.dao.ProductDaoImpl;
import com.test.model.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		int i = Integer.parseInt(id);
		
		String name = request.getParameter("name");
		
		String brand = request.getParameter("brand");
		
		String price = request.getParameter("price");
		
		Product pr = new Product();
		
		pr.setId(i);
		pr.setP_name(name);
		pr.setP_brand(brand);
		pr.setP_price(price);
		
		ProductDaoImpl pimpl = new ProductDaoImpl();
		
		int x = pimpl.updateProduct(pr);
		
		if(x > 0)
		{
			response.sendRedirect("ListProducts");
		}
		else
		{
			out.println("<font color = 'red' > Product Not Updated.</font>");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			
			rd.include(request, response);
		}
	}

}
