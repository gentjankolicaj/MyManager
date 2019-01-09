package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.UserContact;

public interface UserContactService {
	
	
	public abstract List<UserContact> getAllContacts() throws Exception;

	public abstract List<UserContact> getAllContacts(int limit, int offset) throws Exception;

	public abstract List<UserContact> getContactsByCelular(int celular) throws Exception;

	public abstract List<UserContact> getContactsByEmail(String email) throws Exception;

	public abstract UserContact getContactByPersonId(String personId) throws Exception;

	public abstract UserContact getContact(int contactId) throws Exception;

	public abstract int updateContact(UserContact oldContact, UserContact newContact) throws Exception;

	public abstract int saveContact(UserContact contact) throws Exception;

	public abstract int deleteContact(UserContact contact) throws Exception;

}
