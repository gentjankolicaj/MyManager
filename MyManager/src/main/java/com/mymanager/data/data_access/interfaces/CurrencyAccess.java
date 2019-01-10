package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Currency;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface CurrencyAccess {

	public abstract List<Currency> findAllCurrencies() throws Exception;

	public abstract List<Currency> findCurrencies(String currencyName) throws Exception;

	public abstract int updateCurrency(Currency oldCurrency, Currency newCurrency) throws Exception;

	public abstract int saveCurrency(Currency currency) throws Exception;

	public abstract int deleteCurrency(Currency currency) throws Exception;

}
