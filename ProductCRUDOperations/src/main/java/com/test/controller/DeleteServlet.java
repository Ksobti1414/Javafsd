package com.test.controller;

import java.io.IOException;

import com.test.dao.ProductDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		ProductDaoImpl pimpl = new ProductDaoImpl();
		
		int x = pimpl.deleteProductById(id);
		
		response.sendRedirect("ListProducts");
	}

}
