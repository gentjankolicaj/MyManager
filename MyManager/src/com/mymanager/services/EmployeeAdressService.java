package com.mymanager.services;

import java.util.List;


import com.mymanager.data.models.EmployeeAdress;

public interface EmployeeAdressService {

	public abstract List<EmployeeAdress> getAllAdresses() throws Exception;

	public abstract List<EmployeeAdress> getAllAdresses(int limit, int offset) throws Exception;

	public abstract EmployeeAdress getAdressesByPersonId(String personId) throws Exception;

	public abstract List<EmployeeAdress> getAdressesByCity(String city) throws Exception;

	public abstract List<EmployeeAdress> getAdressesByCountry(String country) throws Exception;

	public abstract List<EmployeeAdress> getAdressesByStreet(String streetName) throws Exception;

	public abstract EmployeeAdress getAdress(int adressId) throws Exception;

	public abstract int updateAdress(EmployeeAdress oldAdress, EmployeeAdress newAdress) throws Exception;

	public abstract int saveAdress(EmployeeAdress adress) throws Exception;

	public abstract int deleteAdress(EmployeeAdress adress) throws Exception;

	
}
