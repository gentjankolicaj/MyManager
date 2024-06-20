package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.EmployeeAdress;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface EmployeeAdressService {

  List<EmployeeAdress> getAllAdresses() throws Exception;

  List<EmployeeAdress> getAllAdresses(int limit, int offset) throws Exception;

  EmployeeAdress getAdressesByPersonId(String personId) throws Exception;

  List<EmployeeAdress> getAdressesByCity(String city) throws Exception;

  List<EmployeeAdress> getAdressesByCountry(String country) throws Exception;

  List<EmployeeAdress> getAdressesByStreet(String streetName) throws Exception;

  EmployeeAdress getAdress(int adressId) throws Exception;

  int updateAdress(EmployeeAdress oldAdress, EmployeeAdress newAdress) throws Exception;

  int saveAdress(EmployeeAdress adress) throws Exception;

  int deleteAdress(EmployeeAdress adress) throws Exception;


}
