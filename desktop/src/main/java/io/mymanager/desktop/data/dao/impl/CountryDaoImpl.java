package io.mymanager.desktop.data.dao.impl;

import io.mymanager.commons.db.Database;
import io.mymanager.desktop.data.dao.CountryDao;
import io.mymanager.desktop.data.models.Country;
import io.mymanager.desktop.db.DatabaseManager;
import io.mymanager.desktop.enums.PrintType;
import io.mymanager.desktop.util.PrintUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class CountryDaoImpl implements CountryDao {

  protected static Database database = DatabaseManager.getDb();

  /**
   *
   */
  public CountryDaoImpl() {
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
    PrintUtils.print(countryList, PrintType.QUERY_RESULTS);
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
    PrintUtils.print(countryList, PrintType.QUERY_RESULTS);
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
    PrintUtils.print(country, PrintType.QUERY_RESULTS);
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
