package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.CountryAccessObject;
import com.mymanager.data.data_access.interfaces.CountryAccess;
import com.mymanager.data.models.Country;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class CountryServiceImpl implements CountryService{
	
	private CountryAccess countryAccess;
	
	public CountryServiceImpl() {
		super();
		this.countryAccess=new CountryAccessObject();
	}

	@Override
	public List<Country> getAllCountries() throws Exception {
		return countryAccess.findAllCountries();
	}

	@Override
	public List<Country> getCountries(String countryName) throws Exception {
		return countryAccess.findCountries(countryName);
	}

	@Override
	public Country getCountry(String countryName) throws Exception {
		return countryAccess.findCountry(countryName);
	}

	@Override
	public int updateCountry(Country oldCountry, Country newCountry) throws Exception {
		return countryAccess.updateCountry(oldCountry, newCountry);
	}

	@Override
	public int saveCountry(Country country) throws Exception {
		return countryAccess.saveCountry(country);
	}

	@Override
	public int deleteCountry(Country country) throws Exception {
		return countryAccess.deleteCountry(country);
	}
	
	

}
