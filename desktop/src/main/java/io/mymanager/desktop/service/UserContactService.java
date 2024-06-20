package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.UserContact;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface UserContactService {


  List<UserContact> getAllContacts() throws Exception;

  List<UserContact> getAllContacts(int limit, int offset) throws Exception;

  List<UserContact> getContactsByCelular(int celular) throws Exception;

  List<UserContact> getContactsByEmail(String email) throws Exception;

  UserContact getContactByPersonId(String personId) throws Exception;

  UserContact getContact(int contactId) throws Exception;

  int updateContact(UserContact oldContact, UserContact newContact) throws Exception;

  int saveContact(UserContact contact) throws Exception;

  int deleteContact(UserContact contact) throws Exception;

}
