package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.EmployeeContactAccessObject;
import com.mymanager.data.data_access.interfaces.EmployeeContactAccess;
import com.mymanager.data.models.EmployeeContact;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class EmployeeContactServiceImpl implements EmployeeContactService {
	
	private EmployeeContactAccess employeeContactAccess;
	
	public EmployeeContactServiceImpl() {
		super();
		this.employeeContactAccess=new EmployeeContactAccessObject();
	}

	@Override
	public List<EmployeeContact> getAllContacts() throws Exception {
		return employeeContactAccess.findAllContacts();
	}

	@Override
	public List<EmployeeContact> getAllContacts(int limit, int offset) throws Exception {
	  return employeeContactAccess.findAllContacts(limit, offset);
	}

	@Override
	public List<EmployeeContact> getContactsByCelular(int celular) throws Exception {
		return employeeContactAccess.findContactsByCelular(celular);
	}

	@Override
	public List<EmployeeContact> getContactsByEmail(String email) throws Exception {
		return employeeContactAccess.findContactsByEmail(email);
	}

	@Override
	public EmployeeContact getContactByPersonId(String personId) throws Exception {
		return employeeContactAccess.findContactByPersonId(personId);
	}

	@Override
	public EmployeeContact getContact(int contactId) throws Exception {
		return employeeContactAccess.findContact(contactId);
	}

	@Override
	public int updateContact(EmployeeContact oldContact, EmployeeContact newContact) throws Exception {
		return employeeContactAccess.updateContact(oldContact, newContact);
	}

	@Override
	public int saveContact(EmployeeContact contact) throws Exception {
		return employeeContactAccess.saveContact(contact);
	}

	@Override
	public int deleteContact(EmployeeContact contact) throws Exception {
		return employeeContactAccess.deleteContact(contact);
	}

}
