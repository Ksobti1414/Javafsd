package com.test;
import jakarta.servlet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("from servlet");
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String usr=request.getParameter("user");
		//Cookie ck=new Cookie("info",usr);
		//response.addCookie(ck);
		HttpSession session=request.getSession();
		ServletContext ctx=getServletContext();
		session.setAttribute("info", usr);
		int total=(int)ctx.getAttribute("tusers");
		int current=(int)ctx.getAttribute("cusers");
		out.println("<h3>");
		out.println("Total users: "+total);
		out.println("Current users: "+current);
		out.println("</h3>");
        out.println("from login page: "+usr);
		out.println("<br><a href='Logout'>logout here</a>");
	}

}
