package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.UserAdress;
import com.mymanager.data.models.AdressType;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface AdressAccess {

	public abstract List<UserAdress> readAllAdresses() throws Exception;

	public abstract List<UserAdress> readAllAdresses(int limit, int offset) throws Exception;

	public abstract UserAdress readAdressesByPersonId(String personId) throws Exception;

	public abstract List<UserAdress> readAdressesByCity(String city) throws Exception;

	public abstract List<UserAdress> readAdressesByCountry(String country) throws Exception;

	public abstract List<UserAdress> readAdressesByStreet(String street) throws Exception;

	public abstract UserAdress readAdress(int adressId) throws Exception;

	public abstract int updateAdress(UserAdress oldAdress, UserAdress newAdress) throws Exception;

	public abstract int insertAdress(UserAdress adress) throws Exception;

	public abstract int deleteAdress(UserAdress adress) throws Exception;

	public void setQueryType(QueryType queryType);

	public void setAdressType(AdressType adressType);
}
