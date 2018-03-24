package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Contact;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface ContactAccess {

	public abstract List<Contact> readAllContacts();

	public abstract List<Contact> readContacts(int celular);

	public abstract List<Contact> readContacts(String email);

	public abstract Contact readContact(String ownerId);

	public abstract int updateContact(Contact contact);

	public abstract int insertContact(Contact contact);

	public abstract int deleteContact(Contact contact);

}
