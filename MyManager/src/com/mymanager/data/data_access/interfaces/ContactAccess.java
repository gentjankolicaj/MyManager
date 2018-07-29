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

	public abstract List<Contact> readAllContacts(int limit, int offset) throws Exception;

	public abstract List<Contact> readContactsByCelular(int celular) throws Exception;

	public abstract List<Contact> readContactsByEmail(String email) throws Exception;

	public abstract List<Contact> readContactByPersonId(String personId) throws Exception;

	public abstract Contact readContact(int contactId) throws Exception;

	public abstract int updateContact(Contact oldContact, Contact newContact) throws Exception;

	public abstract int insertContact(Contact contact) throws Exception;

	public abstract int deleteContact(Contact contact) throws Exception;

}
