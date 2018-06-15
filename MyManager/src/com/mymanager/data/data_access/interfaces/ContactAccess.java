package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Contact;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface ContactAccess {

	public abstract List<Contact> readAllContacts() throws Exception;

	public abstract List<Contact> readContacts(int celular) throws Exception;

	public abstract List<Contact> readContacts(String email) throws Exception;

	public abstract List<Contact> readContact(Contact contact) throws Exception;

	public abstract int updateContact(Contact contact) throws Exception;

	public abstract int insertContact(Contact contact) throws Exception;

	public abstract int deleteContact(Contact contact) throws Exception;

}
