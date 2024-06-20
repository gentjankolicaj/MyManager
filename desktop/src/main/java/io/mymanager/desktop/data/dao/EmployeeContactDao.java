package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.EmployeeContact;
import java.util.List;

public interface EmployeeContactDao {

  List<EmployeeContact> findAllContacts() throws Exception;

  List<EmployeeContact> findAllContacts(int limit, int offset) throws Exception;

  List<EmployeeContact> findContactsByCelular(int celular) throws Exception;

  List<EmployeeContact> findContactsByEmail(String email) throws Exception;

  EmployeeContact findContactByPersonId(String personId) throws Exception;

  EmployeeContact findContact(int contactId) throws Exception;

  int updateContact(EmployeeContact oldContact, EmployeeContact newContact) throws Exception;

  int saveContact(EmployeeContact contact) throws Exception;

  int deleteContact(EmployeeContact contact) throws Exception;

}
