package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.UserContactDao;
import io.mymanager.desktop.data.dao.impl.UserContactDaoImpl;
import io.mymanager.desktop.data.models.UserContact;
import io.mymanager.desktop.service.UserContactService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class UserContactServiceImpl implements UserContactService {

  private final UserContactDao userContactDao;

  public UserContactServiceImpl() {
    super();
    this.userContactDao = new UserContactDaoImpl();
  }

  @Override
  public List<UserContact> getAllContacts() throws Exception {
    return userContactDao.findAllContacts();
  }

  @Override
  public List<UserContact> getAllContacts(int limit, int offset) throws Exception {
    return userContactDao.findAllContacts(limit, offset);
  }

  @Override
  public List<UserContact> getContactsByCelular(int celular) throws Exception {
    return userContactDao.findContactsByCelular(celular);
  }

  @Override
  public List<UserContact> getContactsByEmail(String email) throws Exception {
    return userContactDao.findContactsByEmail(email);
  }

  @Override
  public UserContact getContactByPersonId(String personId) throws Exception {
    return userContactDao.findContactByPersonId(personId);
  }

  @Override
  public UserContact getContact(int contactId) throws Exception {
    return userContactDao.findContact(contactId);
  }

  @Override
  public int updateContact(UserContact oldContact, UserContact newContact) throws Exception {
    return userContactDao.updateContact(oldContact, newContact);
  }

  @Override
  public int saveContact(UserContact contact) throws Exception {
    return userContactDao.saveContact(contact);
  }

  @Override
  public int deleteContact(UserContact contact) throws Exception {
    return userContactDao.deleteContact(contact);
  }


}
