package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.AdressType;
import com.mymanager.data.models.EmployeeAdress;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface EmployeeAdressAccess {
	
	public abstract List<EmployeeAdress> findAllAdresses() throws Exception;

	public abstract List<EmployeeAdress> findAllAdresses(int limit, int offset) throws Exception;

	public abstract EmployeeAdress findAdressesByPersonId(String personId) throws Exception;

	public abstract List<EmployeeAdress> findAdressesByCity(String city) throws Exception;

	public abstract List<EmployeeAdress> findAdressesByCountry(String country) throws Exception;

	public abstract List<EmployeeAdress> findAdressesByStreet(String streetName) throws Exception;

	public abstract EmployeeAdress findAdress(int adressId) throws Exception;

	public abstract int updateAdress(EmployeeAdress oldAdress, EmployeeAdress newAdress) throws Exception;

	public abstract int saveAdress(EmployeeAdress adress) throws Exception;

	public abstract int deleteAdress(EmployeeAdress adress) throws Exception;

	public void setQueryType(QueryType queryType);


}
