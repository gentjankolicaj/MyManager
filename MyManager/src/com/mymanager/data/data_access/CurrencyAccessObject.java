package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.CurrencyAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.models.Currency;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class CurrencyAccessObject implements CurrencyAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	public CurrencyAccessObject() {
		super();

	}

	@Override
	public List<Currency> findAllCurrencies() throws Exception {
		List<Currency> currencyList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM mymanager.currencies";

		results = database.selectStatement(query);
		while (results.next()) {
			Currency temp = new Currency(results.getString("currency"));
			currencyList.add(temp);

		}
		PrintUtils.print(currencyList, PrintType.QUERY_RESULTS);
		return currencyList;
	}

	@Override
	public List<Currency> findCurrencies(String currencyName) throws Exception {
		List<Currency> currencyList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM mymanager.currencies WHERE currency LIKE'" + currencyName + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			Currency temp = new Currency(results.getString("currency"));
			currencyList.add(temp);

		}
		PrintUtils.print(currencyList, PrintType.QUERY_RESULTS);
		return currencyList;
	}

	@Override
	public int updateCurrency(Currency oldCurrency, Currency newCurrency) throws Exception {
		String query = "UPDATE mymanager.currencies SET currency=? WHERE currency=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, newCurrency.getCurrencyName());
		pstmt.setString(2, oldCurrency.getCurrencyName());

		return pstmt.executeUpdate();

	}

	@Override
	public int saveCurrency(Currency currency) throws Exception {
		String query = "INSERT INTO mymanager.currencies (currency) VALUES (?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, currency.getCurrencyName());

		return pstmt.executeUpdate();

	}

	@Override
	public int deleteCurrency(Currency currency) throws Exception {
		String query = "DELETE FROM mymanager.currencies WHERE currency=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, currency.getCurrencyName());

		return pstmt.executeUpdate();

	}

}
