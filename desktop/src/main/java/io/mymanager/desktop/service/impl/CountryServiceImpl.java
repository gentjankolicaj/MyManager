package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.CountryDao;
import io.mymanager.desktop.data.dao.impl.CountryDaoImpl;
import io.mymanager.desktop.data.models.Country;
import io.mymanager.desktop.service.CountryService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class CountryServiceImpl implements CountryService {

  private final CountryDao countryDao;

  public CountryServiceImpl() {
    super();
    this.countryDao = new CountryDaoImpl();
  }

  @Override
  public List<Country> getAllCountries() throws Exception {
    return countryDao.findAllCountries();
  }

  @Override
  public List<Country> getCountries(String countryName) throws Exception {
    return countryDao.findCountries(countryName);
  }

  @Override
  public Country getCountry(String countryName) throws Exception {
    return countryDao.findCountry(countryName);
  }

  @Override
  public int updateCountry(Country oldCountry, Country newCountry) throws Exception {
    return countryDao.updateCountry(oldCountry, newCountry);
  }

  @Override
  public int saveCountry(Country country) throws Exception {
    return countryDao.saveCountry(country);
  }

  @Override
  public int deleteCountry(Country country) throws Exception {
    return countryDao.deleteCountry(country);
  }


}
