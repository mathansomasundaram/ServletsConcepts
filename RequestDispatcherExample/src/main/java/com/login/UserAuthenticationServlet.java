package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class UserAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserAuthenticationServlet() {
        super();
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		
		HttpSession session=request.getSession();
		session.setAttribute("userName", userName);
		session.setAttribute("userPassword", userPassword);
		try {
			if (passwordValidation(userPassword)) {
				response.sendRedirect("sucess");
				/* SendRedirect will create a new HTTP Get Request */
			} else {
				out.println("Password Error");
				/* RequestDispatcher will invoke the same
				 * HTTP request that was used in original request
				 */
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	boolean passwordValidation(String userPassword) {
		return (userPassword.length()>8)?true:false;
	}
	
}
