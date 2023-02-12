package com.countryfetcher.model;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.country.CountryInformation;
import com.countryfetcher.controller.CountryDetails;

public class CountryIdentityModel implements Serializable{

	private static final long serialVersionUID = 1L;
	CountryDetails detailsFromDB=new CountryDetails();
	public List<String> getTotalCountryList() {
		return detailsFromDB.getCountryDetailsFromDB();
	}
	
	public CountryInformation getCountryInfo(String countryName) {
		return detailsFromDB.getCountryInfo(countryName);
	}

}
