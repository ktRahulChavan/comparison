package com.cdac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSucessServlet
 */
//@WebServlet("/sucess")


public class LoginSucessServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		String name=(String) request.getAttribute("name");
		out.println("login sucess <br>");
		out.println("welcome "+ name);
		
		RequestDispatcher rd= request.getRequestDispatcher("Welcome.html");
		rd.include(request, response);
		
			
		
	}

}
