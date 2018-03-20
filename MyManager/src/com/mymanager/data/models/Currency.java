package com.mymanager.data.models;

public class Currency {

	private String currencyName;

	/**
	 * 
	 */
	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param currencyName
	 */
	public Currency(String currencyName) {
		super();
		this.currencyName = currencyName;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

}
