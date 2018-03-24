package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Country;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface CountryAccess {

	public abstract List<Country> readAllCountries();

	public abstract List<Country> readCountries(String countryName);

	public abstract int updateCountry(Country country);

	public abstract int insertCountry(Country country);

	public abstract int deleteCountry(Country country);

}
