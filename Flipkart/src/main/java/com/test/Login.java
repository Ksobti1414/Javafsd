package com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.io.*;
import java.sql.*;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String usr=request.getParameter("user");
		String pas=request.getParameter("pwd");
		User obj=new User();
		obj.setUsername(usr);
		obj.setPassword(pas);
		String sql="select u_name,u_password from mlauser where u_name=? and u_password=?";
		PreparedStatement pst=DBConnection.getCon().prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		User dobj=new User();
		while(rs.next()) {
			dobj.setUsername(rs.getString(1));
			dobj.setPassword(rs.getString(2));
		}
		if(obj.getUsername().equals("mohit")&& obj.getPassword().equals("java"))
		{
			response.sendRedirect("home.jsp");
		}
		else {
			out.println("<center><font color='red'>Invalid Credentials</font></center>");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
