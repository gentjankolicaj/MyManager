package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.EmployeeContact;

public interface EmployeeContactService {

	public abstract List<EmployeeContact> getAllContacts() throws Exception;

	public abstract List<EmployeeContact> getAllContacts(int limit, int offset) throws Exception;

	public abstract List<EmployeeContact> getContactsByCelular(int celular) throws Exception;

	public abstract List<EmployeeContact> getContactsByEmail(String email) throws Exception;

	public abstract EmployeeContact getContactByPersonId(String personId) throws Exception;

	public abstract EmployeeContact getContact(int contactId) throws Exception;

	public abstract int updateContact(EmployeeContact oldContact, EmployeeContact newContact) throws Exception;

	public abstract int saveContact(EmployeeContact contact) throws Exception;

	public abstract int deleteContact(EmployeeContact contact) throws Exception;
}
