package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.UserContact;

public interface UserContactAccess {

	public abstract List<UserContact> readAllContacts() throws Exception;

	public abstract List<UserContact> readAllContacts(int limit, int offset) throws Exception;

	public abstract List<UserContact> readContactsByCelular(int celular) throws Exception;

	public abstract List<UserContact> readContactsByEmail(String email) throws Exception;

	public abstract UserContact readContactByPersonId(String personId) throws Exception;

	public abstract UserContact readContact(int contactId) throws Exception;

	public abstract int updateContact(UserContact oldContact, UserContact newContact) throws Exception;

	public abstract int insertContact(UserContact contact) throws Exception;

	public abstract int deleteContact(UserContact contact) throws Exception;
}
