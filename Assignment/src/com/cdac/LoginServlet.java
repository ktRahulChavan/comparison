package com.cdac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
			
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		if(name.equals("admin") &&  password.equals("admin"))
		{
			
		    request.setAttribute("name", name);
			RequestDispatcher rd= request.getRequestDispatcher("LoginSucess");
			rd.include(request, response);
						
				}
		
		else
		{
		     out.println("incorrect Login please login");
		
			
			RequestDispatcher rd1= request.getRequestDispatcher("Login.html");
			rd1.include(request, response);
			
			
			
		}
		
	
	}

}
