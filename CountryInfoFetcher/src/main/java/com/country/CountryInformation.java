package com.country;

import java.io.Serializable;

public class CountryInformation implements Serializable{

	private static final long serialVersionUID = 1L;
	private String CountryCode;
	private String CountryName;
	private String CountryContinent;
	private String CountryRegion;
	private String CountryGovernmentForm;
	private String CountryHeadOfState;	
	private int TotalStates;
	private String CountryCapital;
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public String getCountryContinent() {
		return CountryContinent;
	}
	public void setCountryContinent(String countryContinent) {
		CountryContinent = countryContinent;
	}
	public String getCountryCapital() {
		return CountryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		CountryCapital = countryCapital;
	}
	public String getCountryRegion() {
		return CountryRegion;
	}
	public void setCountryRegion(String countryRegion) {
		CountryRegion = countryRegion;
	}
	
	public int getTotalStates() {
		return TotalStates;
	}
	public void setTotalStates(int totalStates) {
		TotalStates = totalStates;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getCountryGovernmentForm() {
		return CountryGovernmentForm;
	}
	public void setCountryGovernmentForm(String countryGovernmentForm) {
		CountryGovernmentForm = countryGovernmentForm;
	}
	public String getCountryHeadOfState() {
		return CountryHeadOfState;
	}
	public void setCountryHeadOfState(String countryHeadOfState) {
		CountryHeadOfState = countryHeadOfState;
	}
	@Override
	public String toString() {
		return "CountryInformation [CountryCode=" + CountryCode + ", CountryName=" + CountryName + ", CountryContinent="
				+ CountryContinent + ", CountryRegion=" + CountryRegion + ", CountryGovernmentForm="
				+ CountryGovernmentForm + ", CountryHeadOfState=" + CountryHeadOfState + ", TotalStates=" + TotalStates
				+ ", CountryCapital=" + CountryCapital + "]";
	}
}
