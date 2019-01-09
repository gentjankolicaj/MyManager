package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.UserContact;

public interface UserContactAccess {

	public abstract List<UserContact> findAllContacts() throws Exception;

	public abstract List<UserContact> findAllContacts(int limit, int offset) throws Exception;

	public abstract List<UserContact> findContactsByCelular(int celular) throws Exception;

	public abstract List<UserContact> findContactsByEmail(String email) throws Exception;

	public abstract UserContact findContactByPersonId(String personId) throws Exception;

	public abstract UserContact findContact(int contactId) throws Exception;

	public abstract int updateContact(UserContact oldContact, UserContact newContact) throws Exception;

	public abstract int saveContact(UserContact contact) throws Exception;

	public abstract int deleteContact(UserContact contact) throws Exception;
}
