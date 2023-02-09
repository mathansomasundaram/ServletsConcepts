package com.countryfetcher.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDetails {

	private static String localHost="jdbc:mysql://localhost:3306/world";
	private static String userName="root";
	private static String userPassword="root";
	public static List<String> countryDetails = new ArrayList<>();
	
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
		}

		return countryDetails;
	}
	
	
}
