package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.EmployeeAdressAcessObject;
import com.mymanager.data.data_access.interfaces.EmployeeAdressAccess;
import com.mymanager.data.models.EmployeeAdress;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class EmployeeAdressServiceImpl implements EmployeeAdressService {
	
	private EmployeeAdressAccess employeeAdressAccess;
	
	public EmployeeAdressServiceImpl() {
		super();
		this.employeeAdressAccess=new EmployeeAdressAcessObject();
	}

	@Override
	public List<EmployeeAdress> getAllAdresses() throws Exception {
		return employeeAdressAccess.findAllAdresses();
	}

	@Override
	public List<EmployeeAdress> getAllAdresses(int limit, int offset) throws Exception {
		return employeeAdressAccess.findAllAdresses(limit,offset);
	}

	@Override
	public EmployeeAdress getAdressesByPersonId(String personId) throws Exception {
		return employeeAdressAccess.findAdressesByPersonId(personId);
	}

	@Override
	public List<EmployeeAdress> getAdressesByCity(String city) throws Exception {
		return employeeAdressAccess.findAdressesByCity(city);
	}

	@Override
	public List<EmployeeAdress> getAdressesByCountry(String country) throws Exception {
		return employeeAdressAccess.findAdressesByCountry(country);
	}

	@Override
	public List<EmployeeAdress> getAdressesByStreet(String streetName) throws Exception {
		return employeeAdressAccess.findAdressesByStreet(streetName);
	}

	@Override
	public EmployeeAdress getAdress(int adressId) throws Exception {
		return employeeAdressAccess.findAdress(adressId);
	}

	@Override
	public int updateAdress(EmployeeAdress oldAdress, EmployeeAdress newAdress) throws Exception {
		return employeeAdressAccess.updateAdress(oldAdress, newAdress);
	}

	@Override
	public int saveAdress(EmployeeAdress adress) throws Exception {
		return employeeAdressAccess.saveAdress(adress);
	}

	@Override
	public int deleteAdress(EmployeeAdress adress) throws Exception {
		return employeeAdressAccess.deleteAdress(adress);
	}

}
