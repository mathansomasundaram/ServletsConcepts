package com.countryfetcher.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.countryfetcher.controller.CountryDetails;

public class CountryIdentityModel {

	CountryDetails detailsFromDB=new CountryDetails();
	public List<String> getTotalCountryList() {
		return detailsFromDB.getCountryDetailsFromDB();
	}

}
