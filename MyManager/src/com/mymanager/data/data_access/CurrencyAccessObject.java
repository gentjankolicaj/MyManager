package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.CurrencyAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Currency;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class CurrencyAccessObject implements CurrencyAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public CurrencyAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public CurrencyAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

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
