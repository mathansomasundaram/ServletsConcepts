package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SucessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SucessServlet() {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String userName=(String) session.getAttribute("userName");
		
		/*
		 * String userName=request.getParameter("userName")
		 * userName will be null here as both the request are 
		 * two different one.
		 */
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("Welcome "+userName);
	}

}
