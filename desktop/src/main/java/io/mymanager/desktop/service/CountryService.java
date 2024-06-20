package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.Country;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface CountryService {

  List<Country> getAllCountries() throws Exception;

  List<Country> getCountries(String countryName) throws Exception;

  Country getCountry(String countryName) throws Exception;

  int updateCountry(Country oldCountry, Country newCountry) throws Exception;

  int saveCountry(Country country) throws Exception;

  int deleteCountry(Country country) throws Exception;
}
