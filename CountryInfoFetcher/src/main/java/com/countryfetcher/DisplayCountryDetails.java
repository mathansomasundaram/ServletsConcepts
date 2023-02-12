package com.countryfetcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.country.CountryInformation;
import com.countryfetcher.model.CountryIdentityModel;


@WebServlet("/DisplayCountryDetails")
public class DisplayCountryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayCountryDetails() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String countryName=request.getParameter("countryName");
    	response.setContentType("text/html");
    	CountryInformation countryInfo=null;
    	HttpSession session=request.getSession();
    	try {
    		
    		long startTime=System.currentTimeMillis();
    		
    		countryInfo=(CountryInformation)session.getAttribute("countryDetail:"+countryName.toUpperCase());
    		if(countryInfo == null || (countryInfo.getCountryName() != null && !countryInfo.getCountryName().equalsIgnoreCase(countryName))) {

    			CountryIdentityModel countryDetails = new CountryIdentityModel();
    			countryInfo = countryDetails.getCountryInfo(countryName);
    			session.setAttribute("countryDetail:"+countryName.toUpperCase(), countryInfo);
    		}
    		long endTime=System.currentTimeMillis();
    		
    		System.out.println(countryName+" Time :"+(endTime-startTime));
    		displayCountryDetail(response,request,countryInfo);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
//    		Enumeration<String> attributes = request.getSession().getAttributeNames();
//    		while (attributes.hasMoreElements()) {
//    		    String attribute = (String) attributes.nextElement();
//    		}   
    }

    private void displayCountryDetail(HttpServletResponse response, HttpServletRequest request,
			CountryInformation countryInfo) {
    	response.setContentType("text/html");
    	PrintWriter out=null;

    	try {
    		out=response.getWriter();
    		out.println("<title>Country Information</title>");
    		
    		out.println("<div style='text-align:center;'>");
    		out.println("<table>");
    	    out.println("<tr>");
    	    out.println("<td><b>Country Code:</b></td>");
    	    out.println("<td>" + countryInfo.getCountryCode() + "</td>");
    	    out.println("</tr>");
    	    out.println("<tr>");
    	    out.println("<td><b>Country Name:</b></td>");
    	    out.println("<td>" + countryInfo.getCountryName() + "</td>");
    	    out.println("</tr>");
    	    out.println("<tr>");
    	    out.println("<td><b>Country Capital:</b></td>");
    	    out.println("<td>" + countryInfo.getCountryCapital() + "</td>");
    	    out.println("</tr>");
    	    out.println("<tr>");
    	    out.println("<td><b>Total States:</b></td>");
    	    out.println("<td>" + countryInfo.getTotalStates() + "</td>");
    	    out.println("</tr>");
    	    out.println("<tr>");
    	    out.println("<td><b>Country Region:</b></td>");
    	    out.println("<td>" + countryInfo.getCountryRegion() + "</td>");
    	    out.println("</tr>");
    	    out.println("<tr>");
    	    out.println("<td><b>Country Continent:</b></td>");
    	    out.println("<td>" + countryInfo.getCountryContinent() + "</td>");
    	    out.println("</tr>");
    	    out.println("<tr>");
    	    out.println("<td><b>Government Formation:</b></td>");
    	    out.println("<td>" + countryInfo.getCountryGovernmentForm() + "</td>");
    	    out.println("</tr>");
    	    out.println("<tr>");
    	    out.println("<td><b>Country Head:</b></td>");
    	    out.println("<td>" + countryInfo.getCountryHeadOfState() + "</td>");
    	    out.println("</tr>");
    	    out.println("</table>");
    	    out.println("</div>");
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		if(out!=null)
    			out.close();
    	}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
