package com.mymanager.data.models;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class Country {

	private String countryName;
	private String updatedCountryName;

	/**
	 * 
	 */
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(String countryName) {
		super();
		this.countryName = countryName;
	}

	/**
	 * @param countryName
	 * @param updatedCountryName
	 */
	public Country(String countryName, String updatedCountryName) {
		super();
		this.countryName = countryName;
		this.updatedCountryName = updatedCountryName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getUpdatedCountryName() {
		return updatedCountryName;
	}

	public void setUpdatedCountryName(String updatedCountryName) {
		this.updatedCountryName = updatedCountryName;
	}

}
