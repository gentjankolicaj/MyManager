package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.CountryAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Country;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class CountryAccessObject implements CountryAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public CountryAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public CountryAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<Country> readAllCountries() {

		List<Country> countryList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM countries";
		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Country temp = new Country(results.getString("country"));
				countryList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(countryList, PrintType.QUERY_RESULTS);

		return countryList;
	}

	@Override
	public List<Country> readCountries(String countryName) {

		List<Country> countryList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM countries WHERE country LIKE'" + countryName + "%'";
		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Country temp = new Country(results.getString("country"));
				countryList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(countryList, PrintType.QUERY_RESULTS);

		return countryList;
	}

	@Override
	public int updateCountry(Country country) {

		String query = "UPDATE countries SET country=? WHERE country=?";

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, country.getUpdatedCountryName());
			pstmt.setString(2, country.getCountryName());
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
	public int insertCountry(Country country) {
		String query = "INSERT INTO countries (country) VALUES (?)";

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, country.getCountryName());

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
	public int deleteCountry(Country country) {
		String query = "DELETE FROM countries WHERE country=?";

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, country.getCountryName());
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
