package com.countryfetcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.countryfetcher.model.CountryIdentityModel;


@WebServlet("/GetCountryDetails")
public class GetCountryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCountryDetails() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		@SuppressWarnings("unchecked")
		List<String> countryDetailsList = (List<String>) session.getAttribute("countryName");

		if (countryDetailsList != null && countryDetailsList.isEmpty()) {
			CountryIdentityModel countryDetails = new CountryIdentityModel();
			countryDetailsList = countryDetails.getTotalCountryList();
		}

		displayCountryDetails(response, countryDetailsList);
	}

	private void displayCountryDetails(HttpServletResponse response, List<String> countryDetailsList) {

		response.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>S.No</th>");
			out.println("<th>Country Name</th>");
			out.println("</tr>");

			int count = 1;
			for (String countryName : countryDetailsList) {
				out.println("<tr>");
				out.println("<td>" + (count++) + "</td>");
				out.println("<td>" + countryName + "</td>");
				out.println("</tr>");
			}

			out.println("</table></br>");

			out.println("<form action='index.html'>");
			out.println("<input type='submit' value='Back'>");
			out.println("</form>");

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
