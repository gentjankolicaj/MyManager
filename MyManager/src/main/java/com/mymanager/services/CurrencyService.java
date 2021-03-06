package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.Currency;
/**
 * 
 * @author gentjan koli�aj
 *
 */
public interface CurrencyService {

	public abstract List<Currency> getAllCurrencies() throws Exception;

	public abstract List<Currency> getCurrencies(String currencyName) throws Exception;

	public abstract int updateCurrency(Currency oldCurrency, Currency newCurrency) throws Exception;

	public abstract int saveCurrency(Currency currency) throws Exception;

	public abstract int deleteCurrency(Currency currency) throws Exception;
}
