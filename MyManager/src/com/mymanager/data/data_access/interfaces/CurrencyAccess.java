package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Currency;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface CurrencyAccess {

	public abstract List<Currency> readAllCurrencies();

	public abstract List<Currency> readCurrencies(String currencyName);

	public abstract int updateCurrency(Currency currency);

	public abstract int insertCurrency(Currency currency);

	public abstract int deleteCurrency(Currency currency);

}
