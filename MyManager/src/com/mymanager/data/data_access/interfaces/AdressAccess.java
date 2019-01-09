package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Adress;
import com.mymanager.data.models.AdressType;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface AdressAccess {

	public abstract List<Adress> readAllAdresses() throws Exception;

	public abstract List<Adress> readAllAdresses(int limit, int offset) throws Exception;

	public abstract Adress readAdressesByPersonId(String personId) throws Exception;

	public abstract List<Adress> readAdressesByCity(String city) throws Exception;

	public abstract List<Adress> readAdressesByCountry(String country) throws Exception;

	public abstract List<Adress> readAdressesByStreet(String street) throws Exception;

	public abstract Adress readAdress(int adressId) throws Exception;

	public abstract int updateAdress(Adress oldAdress, Adress newAdress) throws Exception;

	public abstract int insertAdress(Adress adress) throws Exception;

	public abstract int deleteAdress(Adress adress) throws Exception;

	public void setQueryType(QueryType queryType);

	public void setAdressType(AdressType adressType);
}
