package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Country;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface CountryAccess {

	public abstract List<Country> readAllCountries() throws Exception;

	public abstract List<Country> readCountries(String countryName) throws Exception;

	public abstract Country readCountry(String countryName) throws Exception;

	public abstract int updateCountry(Country oldCountry, Country newCountry) throws Exception;

	public abstract int insertCountry(Country country) throws Exception;

	public abstract int deleteCountry(Country country) throws Exception;

}
