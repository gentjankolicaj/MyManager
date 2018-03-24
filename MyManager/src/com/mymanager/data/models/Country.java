package com.mymanager.data.models;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class Country {

	private String countryName;

	/**
	 * 
	 */
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param countryName
	 */
	public Country(String countryName) {
		super();
		this.countryName = countryName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
