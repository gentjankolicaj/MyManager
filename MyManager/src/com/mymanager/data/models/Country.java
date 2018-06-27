package com.mymanager.data.models;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class Country extends MyModel {

	private String countryName;

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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toNormal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
