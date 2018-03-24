package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.CurrencyAccess;
import com.mymanager.data.models.Currency;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class CurrencyAccessObject implements CurrencyAccess {

	@Override
	public List<Currency> readAllCurrencies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Currency> readCurrencies(String currencyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCurrency(Currency currency) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertCurrency(Currency currency) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCurrency(Currency currency) {
		// TODO Auto-generated method stub
		return 0;
	}

}
