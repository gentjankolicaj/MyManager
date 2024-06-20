package io.mymanager.desktop.data.dao;

import io.mymanager.commons.enums.QueryType;
import io.mymanager.desktop.data.models.UserAdress;
import java.util.List;


/**
 * @author gentjan kolicaj
 */
public interface UserAdressDao {

  List<UserAdress> findAllAdresses() throws Exception;

  List<UserAdress> findAllAdresses(int limit, int offset) throws Exception;

  UserAdress findAdressesByPersonId(String personId) throws Exception;

  List<UserAdress> findAdressesByCity(String city) throws Exception;

  List<UserAdress> findAdressesByCountry(String country) throws Exception;

  List<UserAdress> findAdressesByStreet(String streetName) throws Exception;

  UserAdress findAdress(int adressId) throws Exception;

  int updateAdress(UserAdress oldAdress, UserAdress newAdress) throws Exception;

  int saveAdress(UserAdress adress) throws Exception;

  int deleteAdress(UserAdress adress) throws Exception;

  void setQueryType(QueryType queryType);


}
