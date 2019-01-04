package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.EmployeeContact;

public interface EmployeeContactAccess {
	
	public abstract List<EmployeeContact> readAllContacts() throws Exception;

	public abstract List<EmployeeContact> readAllContacts(int limit, int offset) throws Exception;

	public abstract List<EmployeeContact> readContactsByCelular(int celular) throws Exception;

	public abstract List<EmployeeContact> readContactsByEmail(String email) throws Exception;

	public abstract EmployeeContact readContactByPersonId(String personId) throws Exception;

	public abstract EmployeeContact readContact(int contactId) throws Exception;

	public abstract int updateContact(EmployeeContact oldContact, EmployeeContact newContact) throws Exception;

	public abstract int insertContact(EmployeeContact contact) throws Exception;

	public abstract int deleteContact(EmployeeContact contact) throws Exception;

}
