package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.ContactAccess;
import com.mymanager.data.models.Contact;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class ContactAccessObject implements ContactAccess {

	@Override
	public List<Contact> readAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> readContacts(int celular) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> readContacts(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact readContact(String ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertContact(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteContact(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

}
