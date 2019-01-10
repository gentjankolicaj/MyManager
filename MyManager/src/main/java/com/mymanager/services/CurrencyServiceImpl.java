package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.CurrencyAccessObject;
import com.mymanager.data.data_access.interfaces.CurrencyAccess;
import com.mymanager.data.models.Currency;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class CurrencyServiceImpl implements CurrencyService {
	
	private CurrencyAccess currencyAccess;
	
	public CurrencyServiceImpl() {
		super();
		this.currencyAccess=new CurrencyAccessObject();
	}

	@Override
	public List<Currency> getAllCurrencies() throws Exception {
		return currencyAccess.findAllCurrencies();
	}

	@Override
	public List<Currency> getCurrencies(String currencyName) throws Exception {
		return currencyAccess.findCurrencies(currencyName);
	}

	@Override
	public int updateCurrency(Currency oldCurrency, Currency newCurrency) throws Exception {
		return currencyAccess.updateCurrency(oldCurrency, newCurrency);
	}

	@Override
	public int saveCurrency(Currency currency) throws Exception {
		return currencyAccess.saveCurrency(currency);
	}

	@Override
	public int deleteCurrency(Currency currency) throws Exception {
		return currencyAccess.deleteCurrency(currency);
	}

}
