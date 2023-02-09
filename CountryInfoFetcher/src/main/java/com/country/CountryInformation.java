package com.country;

public class CountryInformation {

	private String CountryName;
	private String CountryContinent;
	private String CountryCapital;
	private String CountryRegion;
	private int TotalLanguageSpoken;
	private int TotalStates;
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
	public int getTotalLanguageSpoken() {
		return TotalLanguageSpoken;
	}
	public void setTotalLanguageSpoken(int totalLanguageSpoken) {
		TotalLanguageSpoken = totalLanguageSpoken;
	}
	public int getTotalStates() {
		return TotalStates;
	}
	public void setTotalStates(int totalStates) {
		TotalStates = totalStates;
	}
	@Override
	public String toString() {
		return "CountryInformation [CountryName=" + CountryName + ", CountryContinent=" + CountryContinent
				+ ", CountryCapital=" + CountryCapital + ", CountryRegion=" + CountryRegion + ", TotalLanguageSpoken="
				+ TotalLanguageSpoken + ", TotalStates=" + TotalStates + "]";
	}
}
