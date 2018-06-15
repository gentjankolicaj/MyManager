package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.CountryAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
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

	/**
	 * 
	 */
	public CountryAccessObject() {
		super();
	}

	@Override
	public List<Country> readAllCountries() throws Exception {
		List<Country> countryList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM countries";

		results = database.selectStatement(query);
		while (results.next()) {
			Country temp = new Country(results.getString("country"));
			countryList.add(temp);

		}
		PrintUtils.print(countryList, PrintType.QUERY_RESULTS);
		return countryList;
	}

	@Override
	public List<Country> readCountries(String countryName) throws Exception {
		List<Country> countryList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM countries WHERE country LIKE'" + countryName + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			Country temp = new Country(results.getString("country"));
			countryList.add(temp);

		}
		PrintUtils.print(countryList, PrintType.QUERY_RESULTS);
		return countryList;
	}

	@Override
	public int updateCountry(Country country) throws Exception {
		String query = "UPDATE countries SET country=? WHERE country=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, country.getUpdatedCountryName());
		pstmt.setString(2, country.getCountryName());

		return pstmt.executeUpdate();

	}

	@Override
	public int insertCountry(Country country) throws Exception {
		String query = "INSERT INTO countries (country) VALUES (?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, country.getCountryName());

		return pstmt.executeUpdate();

	}

	@Override
	public int deleteCountry(Country country) throws Exception {
		String query = "DELETE FROM countries WHERE country=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, country.getCountryName());

		return pstmt.executeUpdate();

	}

}
