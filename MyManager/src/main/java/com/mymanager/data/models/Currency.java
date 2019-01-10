package com.mymanager.data.models;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class Currency extends MyModel {

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

	public String getCurrencyName() {
		return currencyName;
	}

	public Currency(String currencyName) {
		super();
		this.currencyName = currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	@Override
	public String toString() {
		return "Currency [currencyName=" + currencyName + "]";
	}

}
