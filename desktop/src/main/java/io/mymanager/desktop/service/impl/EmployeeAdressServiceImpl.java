package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.EmployeeAdressDao;
import io.mymanager.desktop.data.dao.impl.EmployeeAdressDaoImpl;
import io.mymanager.desktop.data.models.EmployeeAdress;
import io.mymanager.desktop.service.EmployeeAdressService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class EmployeeAdressServiceImpl implements EmployeeAdressService {

  private final EmployeeAdressDao employeeAdressDao;

  public EmployeeAdressServiceImpl() {
    super();
    this.employeeAdressDao = new EmployeeAdressDaoImpl();
  }

  @Override
  public List<EmployeeAdress> getAllAdresses() throws Exception {
    return employeeAdressDao.findAllAdresses();
  }

  @Override
  public List<EmployeeAdress> getAllAdresses(int limit, int offset) throws Exception {
    return employeeAdressDao.findAllAdresses(limit, offset);
  }

  @Override
  public EmployeeAdress getAdressesByPersonId(String personId) throws Exception {
    return employeeAdressDao.findAdressesByPersonId(personId);
  }

  @Override
  public List<EmployeeAdress> getAdressesByCity(String city) throws Exception {
    return employeeAdressDao.findAdressesByCity(city);
  }

  @Override
  public List<EmployeeAdress> getAdressesByCountry(String country) throws Exception {
    return employeeAdressDao.findAdressesByCountry(country);
  }

  @Override
  public List<EmployeeAdress> getAdressesByStreet(String streetName) throws Exception {
    return employeeAdressDao.findAdressesByStreet(streetName);
  }

  @Override
  public EmployeeAdress getAdress(int adressId) throws Exception {
    return employeeAdressDao.findAdress(adressId);
  }

  @Override
  public int updateAdress(EmployeeAdress oldAdress, EmployeeAdress newAdress) throws Exception {
    return employeeAdressDao.updateAdress(oldAdress, newAdress);
  }

  @Override
  public int saveAdress(EmployeeAdress adress) throws Exception {
    return employeeAdressDao.saveAdress(adress);
  }

  @Override
  public int deleteAdress(EmployeeAdress adress) throws Exception {
    return employeeAdressDao.deleteAdress(adress);
  }

}
