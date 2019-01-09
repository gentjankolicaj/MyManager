package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.EmployeeContact;

public interface EmployeeContactAccess {
	
	public abstract List<EmployeeContact> findAllContacts() throws Exception;

	public abstract List<EmployeeContact> findAllContacts(int limit, int offset) throws Exception;

	public abstract List<EmployeeContact> findContactsByCelular(int celular) throws Exception;

	public abstract List<EmployeeContact> findContactsByEmail(String email) throws Exception;

	public abstract EmployeeContact findContactByPersonId(String personId) throws Exception;

	public abstract EmployeeContact findContact(int contactId) throws Exception;

	public abstract int updateContact(EmployeeContact oldContact, EmployeeContact newContact) throws Exception;

	public abstract int saveContact(EmployeeContact contact) throws Exception;

	public abstract int deleteContact(EmployeeContact contact) throws Exception;

}
