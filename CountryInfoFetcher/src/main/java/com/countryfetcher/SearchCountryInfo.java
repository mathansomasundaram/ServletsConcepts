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
import com.mysql.cj.util.StringUtils;


@WebServlet("/SearchCountry")
public class SearchCountryInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> countryListFromDB=null;
    
    public SearchCountryInfo() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		CountryIdentityModel countryDetails = new CountryIdentityModel();
		RequestDispatcher rd = null;
		

		String countryName = request.getParameter("countryName");
		String displayMessage="";
		try {
			if (StringUtils.isNullOrEmpty(countryName)) {
				rd = request.getRequestDispatcher("index.html");
				displayMessage="Country Name cannot be Empty.";
				displayComment(request,response,rd,displayMessage);
				rd.include(request, response);
			} else {
				if (countryListFromDB == null)
					countryListFromDB = countryDetails.getTotalCountryList();

				session.setAttribute("countryName", countryListFromDB);
				if (!countryListFromDB.contains(countryName.toUpperCase())) {
					rd = request.getRequestDispatcher("RefreshPage.html");
					displayMessage="Invalid Country Name provided.";
					displayComment(request,response,rd,displayMessage);
					rd.include(request, response);
				} else {
					rd = request.getRequestDispatcher("DisplayCountryDetails");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void displayComment(HttpServletRequest request, HttpServletResponse response, RequestDispatcher rd,String displayMessage) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			out.print("<div style=\"width: 400px;margin: inherit;\">");
			out.print("<p><h3>"+displayMessage+"</h3></p>");
			out.print("</div>");
			rd.include(request, response);
		} catch (Exception e) {
			System.out.println("Exception-->" + e);
		}finally {
			if(out!=null)
				out.close();
		}
	}
	
	

}
