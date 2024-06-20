package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.Country;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface CountryDao {

  List<Country> findAllCountries() throws Exception;

  List<Country> findCountries(String countryName) throws Exception;

  Country findCountry(String countryName) throws Exception;

  int updateCountry(Country oldCountry, Country newCountry) throws Exception;

  int saveCountry(Country country) throws Exception;

  int deleteCountry(Country country) throws Exception;

}
