package com.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServletProgram
 */
public class FirstServletProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	public void init() throws ServletException {
			super.init();
			System.out.println("Servlet is initialized");
	}
	
    public FirstServletProgram() {
        super();
    }

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int num1 = 0;
		int num2 = 0;
		try {
			num1 = Integer.parseInt(request.getParameter("number1"));
		} catch (Exception e) {
			System.out.println("Number 1 should be numeric value");
		}
		try {
			num2 = Integer.parseInt(request.getParameter("number2"));
		} catch (Exception e) {
			System.out.println("Number 2 should be numeric value");
		}
		int sum = num1 + num2;
		out.println("Sum of " + num1 + " and " + num2 + " is:" + sum);
		out.println("<br><a href='index.html'>Calculate Again</a>");
	}
}
