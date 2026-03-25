package com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;
import java.io.*;
import java.sql.*;
/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("fname");
		String usr=request.getParameter("user");
		String pas=request.getParameter("pwd");
		User obj=new User();
		obj.setFname(name);
		obj.setUsername(usr);
		obj.setPassword(pas);
		String sql="insert into mlauser(full_name,u_name,u_password) values(?,?,?)";
		PreparedStatement pst=DBConnection.getCon().prepareStatement(sql);
		pst.setString(1,obj.getFname());
		pst.setString(2,obj.getUsername());
		pst.setString(3,obj.getPassword());
		pst.execute();
		if(Pattern.matches("[a-zA-Z]+", name)&&Pattern.matches("[a-zA-Z]+", usr)&&Pattern.matches("[a-zA-Z]+", pas)) {
			response.sendRedirect("login.jsp");
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
