package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.UserAdressDao;
import io.mymanager.desktop.data.dao.impl.UserAdressDaoImpl;
import io.mymanager.desktop.data.models.UserAdress;
import io.mymanager.desktop.service.UserAdressService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class UserAdressServiceImpl implements UserAdressService {

  private final UserAdressDao userAdressDao;

  public UserAdressServiceImpl() {
    super();
    this.userAdressDao = new UserAdressDaoImpl();
  }

  @Override
  public List<UserAdress> getAllAdresses() throws Exception {
    return userAdressDao.findAllAdresses();
  }

  @Override
  public List<UserAdress> getAllAdresses(int limit, int offset) throws Exception {
    return userAdressDao.findAllAdresses(limit, offset);
  }

  @Override
  public UserAdress getAdressesByPersonId(String personId) throws Exception {
    return userAdressDao.findAdressesByPersonId(personId);
  }

  @Override
  public List<UserAdress> getAdressesByCity(String city) throws Exception {
    return userAdressDao.findAdressesByCity(city);
  }

  @Override
  public List<UserAdress> getAdressesByCountry(String country) throws Exception {
    return userAdressDao.findAdressesByCountry(country);
  }

  @Override
  public List<UserAdress> getAdressesByStreet(String streetName) throws Exception {
    return userAdressDao.findAdressesByStreet(streetName);
  }

  @Override
  public UserAdress getAdress(int adressId) throws Exception {
    return userAdressDao.findAdress(adressId);
  }

  @Override
  public int updateAdress(UserAdress oldAdress, UserAdress newAdress) throws Exception {
    return userAdressDao.updateAdress(oldAdress, newAdress);
  }

  @Override
  public int saveAdress(UserAdress adress) throws Exception {
    return userAdressDao.saveAdress(adress);
  }

  @Override
  public int deleteAdress(UserAdress adress) throws Exception {
    return userAdressDao.deleteAdress(adress);
  }


}
