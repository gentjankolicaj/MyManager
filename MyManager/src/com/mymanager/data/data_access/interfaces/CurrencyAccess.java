package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Currency;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface CurrencyAccess {

	public abstract List<Currency> readAllCurrencies() throws Exception;

	public abstract List<Currency> readCurrencies(String currencyName) throws Exception;

	public abstract int updateCurrency(Currency oldCurrency, Currency newCurrency) throws Exception;

	public abstract int insertCurrency(Currency currency) throws Exception;

	public abstract int deleteCurrency(Currency currency) throws Exception;

}
