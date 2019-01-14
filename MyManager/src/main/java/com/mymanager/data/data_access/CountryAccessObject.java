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
import com.mymanager.utils.PrintUtil;

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
	public List<Country> findAllCountries() throws Exception {
		List<Country> countryList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM mymanager.countries";

		results = database.selectStatement(query);
		while (results.next()) {
			Country temp = new Country(results.getString("country"));
			countryList.add(temp);

		}
		PrintUtil.print(countryList, PrintType.QUERY_RESULTS);
		return countryList;
	}

	@Override
	public List<Country> findCountries(String countryName) throws Exception {
		List<Country> countryList = new ArrayList<>();
		ResultSet results = null;
		String query = "SELECT * FROM mymanager.countries WHERE country LIKE'" + countryName + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			Country temp = new Country(results.getString("country"));
			countryList.add(temp);
		}
		PrintUtil.print(countryList, PrintType.QUERY_RESULTS);
		return countryList;
	}

	@Override
	public Country findCountry(String countryName) throws Exception {
		Country country = null;
		ResultSet results = null;
		String query = "SELECT * FROM mymanager.countries WHERE country=" + countryName;

		results = database.selectStatement(query);
		while (results.next()) {
			country = new Country(results.getString("country"));
		}
		PrintUtil.print(country, PrintType.QUERY_RESULTS);
		return country;
	}

	@Override
	public int updateCountry(Country oldCountry, Country newCountry) throws Exception {
		String query = "UPDATE mymanager.countries SET country=? WHERE country=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, newCountry.getCountryName());
		pstmt.setString(2, oldCountry.getCountryName());

		return pstmt.executeUpdate();

	}

	@Override
	public int saveCountry(Country country) throws Exception {
		String query = "INSERT INTO mymanager.countries (country) VALUES (?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, country.getCountryName());

		return pstmt.executeUpdate();

	}

	@Override
	public int deleteCountry(Country country) throws Exception {
		String query = "DELETE FROM mymanager.countries WHERE country=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, country.getCountryName());

		return pstmt.executeUpdate();

	}

}
