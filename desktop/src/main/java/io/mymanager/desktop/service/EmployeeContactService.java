package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.EmployeeContact;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface EmployeeContactService {

  List<EmployeeContact> getAllContacts() throws Exception;

  List<EmployeeContact> getAllContacts(int limit, int offset) throws Exception;

  List<EmployeeContact> getContactsByCelular(int celular) throws Exception;

  List<EmployeeContact> getContactsByEmail(String email) throws Exception;

  EmployeeContact getContactByPersonId(String personId) throws Exception;

  EmployeeContact getContact(int contactId) throws Exception;

  int updateContact(EmployeeContact oldContact, EmployeeContact newContact) throws Exception;

  int saveContact(EmployeeContact contact) throws Exception;

  int deleteContact(EmployeeContact contact) throws Exception;
}
