package com.servlet.servletcontext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UserDetailServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	
    	ServletContext context=getServletContext();
    	/*
    	 * We can get the ServletContext object from ServletConfig object
    	 * getServletConfig().getServletContext()
    	 */
    	
    	String userName=context.getInitParameter("name");
    	String userAddress=context.getInitParameter("address");
    	
    	
    	out.println("Name: "+userName);
    	out.println("<br>Address: "+userAddress);
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
