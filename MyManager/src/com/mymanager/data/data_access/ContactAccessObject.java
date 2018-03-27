package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.ContactAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Contact;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class ContactAccessObject implements ContactAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public ContactAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public ContactAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

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
