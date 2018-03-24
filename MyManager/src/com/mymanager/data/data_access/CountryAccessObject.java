package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.CountryAccess;
import com.mymanager.data.models.Country;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class CountryAccessObject implements CountryAccess {

	@Override
	public List<Country> readAllCountries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> readCountries(String countryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCountry(Country country) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertCountry(Country country) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCountry(Country country) {
		// TODO Auto-generated method stub
		return 0;
	}

}
