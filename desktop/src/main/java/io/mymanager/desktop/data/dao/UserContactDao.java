package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.UserContact;
import java.util.List;

public interface UserContactDao {

  List<UserContact> findAllContacts() throws Exception;

  List<UserContact> findAllContacts(int limit, int offset) throws Exception;

  List<UserContact> findContactsByCelular(int celular) throws Exception;

  List<UserContact> findContactsByEmail(String email) throws Exception;

  UserContact findContactByPersonId(String personId) throws Exception;

  UserContact findContact(int contactId) throws Exception;

  int updateContact(UserContact oldContact, UserContact newContact) throws Exception;

  int saveContact(UserContact contact) throws Exception;

  int deleteContact(UserContact contact) throws Exception;
}
