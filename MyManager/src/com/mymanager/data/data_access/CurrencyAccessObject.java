package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.CurrencyAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
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

		List<Currency> currencyList = new ArrayList<>();

		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM currencies";
		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Currency temp = new Currency(results.getString("currency"));
				currencyList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(currencyList, PrintType.QUERY_RESULTS);

		return currencyList;
	}

	@Override
	public List<Currency> readCurrencies(String currencyName) {

		List<Currency> currencyList = new ArrayList<>();

		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM currencies WHERE currency LIKE'" + currencyName + "%'";
		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Currency temp = new Currency(results.getString("currency"));
				currencyList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(currencyList, PrintType.QUERY_RESULTS);

		return currencyList;
	}

	@Override
	public int updateCurrency(Currency currency) {

		String query = "UPDATE currencies SET currency=? WHERE currency=?";

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, currency.getUpdatedCurrencyName());
			pstmt.setString(2, currency.getCurrencyName());
			pstmt.executeUpdate();
			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

	@Override
	public int insertCurrency(Currency currency) {

		String query = "INSERT INTO currencies (currency) VALUES (?)";

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, currency.getCurrencyName());

			pstmt.executeUpdate();
			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

	@Override
	public int deleteCurrency(Currency currency) {

		String query = "DELETE FROM currencies WHERE currency=?";

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, currency.getCurrencyName());
			pstmt.executeUpdate();

			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

}
