package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.UserAdress;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface UserAdressService {

  List<UserAdress> getAllAdresses() throws Exception;

  List<UserAdress> getAllAdresses(int limit, int offset) throws Exception;

  UserAdress getAdressesByPersonId(String personId) throws Exception;

  List<UserAdress> getAdressesByCity(String city) throws Exception;

  List<UserAdress> getAdressesByCountry(String country) throws Exception;

  List<UserAdress> getAdressesByStreet(String streetName) throws Exception;

  UserAdress getAdress(int adressId) throws Exception;

  int updateAdress(UserAdress oldAdress, UserAdress newAdress) throws Exception;

  int saveAdress(UserAdress adress) throws Exception;

  int deleteAdress(UserAdress adress) throws Exception;

}
