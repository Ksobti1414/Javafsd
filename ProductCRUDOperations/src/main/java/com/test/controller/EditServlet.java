package com.test.controller;

import java.io.IOException;

import com.test.dao.ProductDaoImpl;
import com.test.model.Product;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		int i = Integer.parseInt(id);
		
		ProductDaoImpl pimpl = new ProductDaoImpl();
		
		Product pr = pimpl.getProductById(i);
		
		ServletContext ctx = getServletContext();
		
		ctx.setAttribute("data", pr);
		
		
		response.sendRedirect("editproduct.jsp");
	}

}

