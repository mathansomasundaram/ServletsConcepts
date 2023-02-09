package com.countryfetcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.countryfetcher.model.CountryIdentityModel;

@WebServlet("/SearchCountry")
public class SearchCountryInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static List<String> countryListFromDB=null;
    
    public SearchCountryInfo() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		CountryIdentityModel countryDetails=new CountryIdentityModel();
		PrintWriter out=null;
		RequestDispatcher rd=null;
		
		try {
			out=response.getWriter();
		}catch(Exception e) {
			System.out.println("Exception-->"+e);
		}
		
		String countryName=request.getParameter("countryName");

		if(countryListFromDB==null)
			countryListFromDB=countryDetails.getTotalCountryList();
		
		session.setAttribute("countryName", countryListFromDB);
		if(!countryListFromDB.contains(countryName.toUpperCase())) {
			try {
				rd = request.getRequestDispatcher("RefreshPage.html");
				out.print("<div style=\"width: 500px; margin: 0 auto;\">");
				out.print("<p><h3>Invalid Country Name provided.</h3></p>");
				out.print("</div>");
				rd.include(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	
	}

}
