package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.AdressType;
import com.mymanager.data.models.UserAdress;


/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface UserAdressAccess {
	
	public abstract List<UserAdress> findAllAdresses() throws Exception;

	public abstract List<UserAdress> findAllAdresses(int limit, int offset) throws Exception;

	public abstract UserAdress findAdressesByPersonId(String personId) throws Exception;

	public abstract List<UserAdress> findAdressesByCity(String city) throws Exception;

	public abstract List<UserAdress> findAdressesByCountry(String country) throws Exception;

	public abstract List<UserAdress> findAdressesByStreet(String streetName) throws Exception;

	public abstract UserAdress findAdress(int adressId) throws Exception;

	public abstract int updateAdress(UserAdress oldAdress, UserAdress newAdress) throws Exception;

	public abstract int saveAdress(UserAdress adress) throws Exception;

	public abstract int deleteAdress(UserAdress adress) throws Exception;

	public void setQueryType(QueryType queryType);


}
