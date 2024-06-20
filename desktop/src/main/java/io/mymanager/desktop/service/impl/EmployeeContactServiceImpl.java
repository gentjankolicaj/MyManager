package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.EmployeeContactDao;
import io.mymanager.desktop.data.dao.impl.EmployeeContactDaoImpl;
import io.mymanager.desktop.data.models.EmployeeContact;
import io.mymanager.desktop.service.EmployeeContactService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class EmployeeContactServiceImpl implements EmployeeContactService {

  private final EmployeeContactDao employeeContactDao;

  public EmployeeContactServiceImpl() {
    super();
    this.employeeContactDao = new EmployeeContactDaoImpl();
  }

  @Override
  public List<EmployeeContact> getAllContacts() throws Exception {
    return employeeContactDao.findAllContacts();
  }

  @Override
  public List<EmployeeContact> getAllContacts(int limit, int offset) throws Exception {
    return employeeContactDao.findAllContacts(limit, offset);
  }

  @Override
  public List<EmployeeContact> getContactsByCelular(int celular) throws Exception {
    return employeeContactDao.findContactsByCelular(celular);
  }

  @Override
  public List<EmployeeContact> getContactsByEmail(String email) throws Exception {
    return employeeContactDao.findContactsByEmail(email);
  }

  @Override
  public EmployeeContact getContactByPersonId(String personId) throws Exception {
    return employeeContactDao.findContactByPersonId(personId);
  }

  @Override
  public EmployeeContact getContact(int contactId) throws Exception {
    return employeeContactDao.findContact(contactId);
  }

  @Override
  public int updateContact(EmployeeContact oldContact, EmployeeContact newContact)
      throws Exception {
    return employeeContactDao.updateContact(oldContact, newContact);
  }

  @Override
  public int saveContact(EmployeeContact contact) throws Exception {
    return employeeContactDao.saveContact(contact);
  }

  @Override
  public int deleteContact(EmployeeContact contact) throws Exception {
    return employeeContactDao.deleteContact(contact);
  }

}
