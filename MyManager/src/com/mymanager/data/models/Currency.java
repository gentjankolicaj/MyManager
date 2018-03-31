package com.mymanager.data.models;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class Currency {

	private String currencyName;
	private String updatedCurrencyName;

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

	/**
	 * @param currencyName
	 * @param updatedCurrencyName
	 */
	public Currency(String currencyName, String updatedCurrencyName) {
		super();
		this.currencyName = currencyName;
		this.updatedCurrencyName = updatedCurrencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getUpdatedCurrencyName() {
		return updatedCurrencyName;
	}

	public void setUpdatedCurrencyName(String updatedCurrencyName) {
		this.updatedCurrencyName = updatedCurrencyName;
	}

}
