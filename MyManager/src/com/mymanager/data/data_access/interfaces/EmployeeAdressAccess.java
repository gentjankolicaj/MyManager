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
	
	public abstract List<EmployeeAdress> readAllAdresses() throws Exception;

	public abstract List<EmployeeAdress> readAllAdresses(int limit, int offset) throws Exception;

	public abstract EmployeeAdress readAdressesByPersonId(String personId) throws Exception;

	public abstract List<EmployeeAdress> readAdressesByCity(String city) throws Exception;

	public abstract List<EmployeeAdress> readAdressesByCountry(String country) throws Exception;

	public abstract List<EmployeeAdress> readAdressesByStreet(String streetName) throws Exception;

	public abstract EmployeeAdress readAdress(int adressId) throws Exception;

	public abstract int updateAdress(EmployeeAdress oldAdress, EmployeeAdress newAdress) throws Exception;

	public abstract int insertAdress(EmployeeAdress adress) throws Exception;

	public abstract int deleteAdress(EmployeeAdress adress) throws Exception;

	public void setQueryType(QueryType queryType);


}
