package io.gentjankolicaj.app.mymanager.desktop.data.dao.impl;

import io.gentjankolicaj.app.mymanager.desktop.data.dao.CurrencyDao;
import io.gentjankolicaj.app.mymanager.desktop.data.models.Currency;
import io.gentjankolicaj.app.mymanager.desktop.db.custom.Database;
import io.gentjankolicaj.app.mymanager.desktop.db.custom.DatabaseManager;
import io.gentjankolicaj.app.mymanager.desktop.db.custom.DatabasePool;
import io.gentjankolicaj.app.mymanager.desktop.enums.PrintType;
import io.gentjankolicaj.app.mymanager.desktop.util.PrintUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class CurrencyDaoImpl implements CurrencyDao {

    protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

    public CurrencyDaoImpl() {
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
