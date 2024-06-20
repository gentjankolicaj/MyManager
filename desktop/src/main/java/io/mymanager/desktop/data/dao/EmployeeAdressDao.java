package io.mymanager.desktop.data.dao;

import io.mymanager.commons.enums.QueryType;
import io.mymanager.desktop.data.models.EmployeeAdress;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface EmployeeAdressDao {

  List<EmployeeAdress> findAllAdresses() throws Exception;

  List<EmployeeAdress> findAllAdresses(int limit, int offset) throws Exception;

  EmployeeAdress findAdressesByPersonId(String personId) throws Exception;

  List<EmployeeAdress> findAdressesByCity(String city) throws Exception;

  List<EmployeeAdress> findAdressesByCountry(String country) throws Exception;

  List<EmployeeAdress> findAdressesByStreet(String streetName) throws Exception;

  EmployeeAdress findAdress(int adressId) throws Exception;

  int updateAdress(EmployeeAdress oldAdress, EmployeeAdress newAdress) throws Exception;

  int saveAdress(EmployeeAdress adress) throws Exception;

  int deleteAdress(EmployeeAdress adress) throws Exception;

  void setQueryType(QueryType queryType);


}
