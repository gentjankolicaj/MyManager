package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.UserContactAccessObject;
import com.mymanager.data.data_access.interfaces.UserContactAccess;
import com.mymanager.data.models.UserContact;

public class UserContactServiceImpl implements UserContactService{
	
	private UserContactAccess userContactAccess;
	
	public UserContactServiceImpl() {
		super();
		this.userContactAccess=new UserContactAccessObject();
	}

	@Override
	public List<UserContact> getAllContacts() throws Exception {
		return userContactAccess.findAllContacts();
	}

	@Override
	public List<UserContact> getAllContacts(int limit, int offset) throws Exception {
		return userContactAccess.findAllContacts(limit, offset);
	}

	@Override
	public List<UserContact> getContactsByCelular(int celular) throws Exception {
		return userContactAccess.findContactsByCelular(celular);
	}

	@Override
	public List<UserContact> getContactsByEmail(String email) throws Exception {
		return userContactAccess.findContactsByEmail(email);
	}

	@Override
	public UserContact getContactByPersonId(String personId) throws Exception {
		return userContactAccess.findContactByPersonId(personId);
	}

	@Override
	public UserContact getContact(int contactId) throws Exception {
		return userContactAccess.findContact(contactId);
	}

	@Override
	public int updateContact(UserContact oldContact, UserContact newContact) throws Exception {
		return userContactAccess.updateContact(oldContact, newContact);
	}

	@Override
	public int saveContact(UserContact contact) throws Exception {
		return userContactAccess.saveContact(contact);
	}

	@Override
	public int deleteContact(UserContact contact) throws Exception {
		return userContactAccess.deleteContact(contact);
	}


	

}
