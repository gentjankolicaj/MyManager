package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.UserAdressAccessObject;
import com.mymanager.data.data_access.interfaces.UserAdressAccess;
import com.mymanager.data.models.UserAdress;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class UserAdressServiceImpl implements UserAdressService {
	
	private UserAdressAccess userAdressAccess;
	
	public UserAdressServiceImpl() {
		super();
		this.userAdressAccess=new UserAdressAccessObject();
	}

	@Override
	public List<UserAdress> getAllAdresses() throws Exception {
		return userAdressAccess.findAllAdresses();
	}

	@Override
	public List<UserAdress> getAllAdresses(int limit, int offset) throws Exception {
		return userAdressAccess.findAllAdresses(limit, offset);
	}

	@Override
	public UserAdress getAdressesByPersonId(String personId) throws Exception {
		return userAdressAccess.findAdressesByPersonId(personId);
	}

	@Override
	public List<UserAdress> getAdressesByCity(String city) throws Exception {
		return userAdressAccess.findAdressesByCity(city);
	}

	@Override
	public List<UserAdress> getAdressesByCountry(String country) throws Exception {
	  return userAdressAccess.findAdressesByCountry(country);
	}

	@Override
	public List<UserAdress> getAdressesByStreet(String streetName) throws Exception {
		return userAdressAccess.findAdressesByStreet(streetName);
	}

	@Override
	public UserAdress getAdress(int adressId) throws Exception {
		return userAdressAccess.findAdress(adressId);
	}

	@Override
	public int updateAdress(UserAdress oldAdress, UserAdress newAdress) throws Exception {
		return userAdressAccess.updateAdress(oldAdress, newAdress);
	}

	@Override
	public int saveAdress(UserAdress adress) throws Exception {
		return userAdressAccess.saveAdress(adress);
	}

	@Override
	public int deleteAdress(UserAdress adress) throws Exception {
	   return userAdressAccess.deleteAdress(adress);
	}

	
	

}
