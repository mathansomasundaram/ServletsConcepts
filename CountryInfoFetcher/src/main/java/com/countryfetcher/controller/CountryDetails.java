package com.countryfetcher.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.country.CountryInformation;

public class CountryDetails {

	private static String localHost="jdbc:mysql://localhost:3306/world";
	private static String userName="root";
	private static String userPassword="root";
	protected static List<String> countryDetails = new ArrayList<>();
	
	private Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection
					(CountryDetails.localHost, CountryDetails.userName,CountryDetails.userPassword);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}

	public List<String> getCountryDetailsFromDB() {

		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select DISTINCT UPPER(NAME) as CountryName  from country");

			while (rs.next()) {
				countryDetails.add(rs.getString("CountryName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection != null)
					connection.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			}catch(Exception e) {}
		}

		return countryDetails;
	}

	public CountryInformation getCountryInfo(String countryName) {

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		CountryInformation countryInfo=null;
		String query="SELECT country.code, country.name, country.Continent, country.Region, "
				+ "country.governmentForm, country.headOfState, city.name as capital, subquery.district_count "
				+ "FROM country "
				+ "JOIN city ON city.CountryCode = country.code AND country.capital = city.id "
				+ "JOIN (SELECT CountryCode, count(distinct(district)) as district_count FROM city,country GROUP BY CountryCode) as subquery "
				+ "ON subquery.CountryCode = country.code "
				+ "WHERE UPPER(country.name) = UPPER(?)";
		
		try {
			connection = getConnection();
			stmt=connection.prepareStatement(query);
			stmt.setString(1, countryName);
			rs=stmt.executeQuery();
			
			while (rs.next()) {
				countryInfo=new CountryInformation();
				countryInfo.setCountryCode(rs.getString(1));
				countryInfo.setCountryName(rs.getString(2));
				countryInfo.setCountryContinent(rs.getString(3));
				countryInfo.setCountryRegion(rs.getString(4));
				countryInfo.setCountryGovernmentForm(rs.getString(5));
				countryInfo.setCountryHeadOfState(rs.getString(6));
				countryInfo.setCountryCapital(rs.getString(7));
				countryInfo.setTotalStates(rs.getInt(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection != null)
					connection.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			}catch(Exception e) {}
		}
		
		return countryInfo;
	}
	
	
}
