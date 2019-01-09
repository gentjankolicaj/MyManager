package com.mymanager.services;

import java.util.List;

import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.UserAdress;

public interface UserAdressService {
	
	public abstract List<UserAdress> getAllAdresses() throws Exception;

	public abstract List<UserAdress> getAllAdresses(int limit, int offset) throws Exception;

	public abstract UserAdress getAdressesByPersonId(String personId) throws Exception;

	public abstract List<UserAdress> getAdressesByCity(String city) throws Exception;

	public abstract List<UserAdress> getAdressesByCountry(String country) throws Exception;

	public abstract List<UserAdress> getAdressesByStreet(String streetName) throws Exception;

	public abstract UserAdress getAdress(int adressId) throws Exception;

	public abstract int updateAdress(UserAdress oldAdress, UserAdress newAdress) throws Exception;

	public abstract int saveAdress(UserAdress adress) throws Exception;

	public abstract int deleteAdress(UserAdress adress) throws Exception;

}
