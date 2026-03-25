package com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * Servlet implementation class Listusers
 */
@WebServlet("/Listusers")
public class Listusers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listusers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String sql="select * from mlauser";
			PreparedStatement pst=DBConnection.getCon().prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			List<User>listusers=new ArrayList<>();
			while(rs.next()) {
				User obj=new User();
				obj.setId(rs.getInt(1));
				obj.setFname(rs.getString(2));
				obj.setUsername(rs.getString(3));
				obj.setPassword(rs.getString(4));
				listusers.add(obj);
			}
			ServletContext ctx=getServletContext();
			ctx.setAttribute("info",listusers);
			if(listusers.size()>0) {
				response.sendRedirect("listusers.jsp");
			}
			else {
				out.println("<center><font color='red'>No data available please add users></font></center>");
				RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
				rd.include(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
