package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.ContactAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Contact;
import com.mymanager.data.models.ContactType;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class ContactAccessObject implements ContactAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;
	private ContactType contactType;

	/**
	 * 
	 */
	public ContactAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	public ContactAccessObject(ContactType contactType) {
		super();
		this.contactType = contactType;
	}

	public ContactAccessObject(QueryType queryType, ContactType contactType) {
		super();
		this.queryType = queryType;
		this.contactType = contactType;
	}

	public ContactAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<Contact> readAllContacts() throws Exception {
		List<Contact> contactList = new ArrayList<>();
		ResultSet results = null;
		String query = null;

		if (contactType.equals(ContactType.EMPLOYEE_CONTACT)) {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.employee_contact";
			else
				query = "SELECT * FROM mymanager.employee_contact_history";

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getInt("contact_id"), results.getString("employee_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;

		} else {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.user_contact";
			else
				query = "SELECT * FROM mymanager.user_contact_history";

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getInt("contact_id"), results.getString("user_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;
		}

	}

	@Override
	public List<Contact> readContactsByCelular(int celular) throws Exception {
		List<Contact> contactList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (contactType.equals(ContactType.EMPLOYEE_CONTACT)) {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.employee_contact WHERE celular LIKE '" + celular + "%'";
			else
				query = "SELECT * FROM mymanager.employee_contact_history WHERE celular LIKE '" + celular + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getInt("contact_id"), results.getString("employee_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;

		} else {

			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.user_contact WHERE celular LIKE'" + celular + "%'";
			else
				query = "SELECT * FROM mymanager.user_contact_history WHERE celular LIKE'" + celular + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getInt("contact_id"), results.getString("user_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;

		}

	}

	@Override
	public List<Contact> readContactsByEmail(String email) throws Exception {
		List<Contact> contactList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (contactType.equals(ContactType.EMPLOYEE_CONTACT)) {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.employee_contact WHERE email LIKE '" + email + "%'";
			else
				query = "SELECT * FROM mymanager.employee_contact_history email LIKE '" + email + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getInt("contact_id"), results.getString("employee_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;

		} else {

			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.user_contact WHERE email LIKE '" + email + "%'";
			else
				query = "SELECT * FROM mymanager.user_contact_history WHERE email LIKE '" + email + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getInt("contact_id"), results.getString("user_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;
		}
	}

	@Override
	public List<Contact> readContactByPersonId(String personId) throws Exception {
		List<Contact> contactList = new ArrayList<>();
		ResultSet results = null;
		String query = null;

		if (contactType.equals(ContactType.EMPLOYEE_CONTACT)) {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.employee_contact WHERE employee_id=" + personId;
			else
				query = "SELECT * FROM mymanager.employee_contact_history WHERE employee_id=" + personId;

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getInt("contact_id"), results.getString("employee_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;

		} else {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.user_contact WHERE user_id=" + personId;
			else
				query = "SELECT * FROM mymanager.user_contact_history WHERE user_id=" + personId;

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getInt("contact_id"), results.getString("user_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;
		}
	}

	@Override
	public Contact readContact(int contactId) throws Exception {
		Contact contact = null;
		ResultSet results = null;
		String query = null;

		if (contactType.equals(ContactType.EMPLOYEE_CONTACT)) {
			query = "SELECT * FROM mymanager.employee_contact WHERE contact_id=" + contactId;

			results = database.selectStatement(query);
			while (results.next()) {
				contact = new Contact(results.getInt("contact_id"), results.getString("employee_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
			}
			PrintUtils.print(contact, PrintType.QUERY_RESULTS);
			return contact;

		} else {

			query = "SELECT * FROM mymanager.user_contact WHERE contact_id=" + contactId;
			results = database.selectStatement(query);
			while (results.next()) {
				contact = new Contact(results.getInt("contact_id"), results.getString("user_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
			}
			PrintUtils.print(contact, PrintType.QUERY_RESULTS);
			return contact;
		}
	}

	@Override
	public int updateContact(Contact oldContact, Contact newContact) throws Exception {
		String query = null;
		if (contactType.equals(ContactType.EMPLOYEE_CONTACT))
			query = "UPDATE mymanager.employee_contact SET contact_id=?,employee_id=?,telephone=?,celular=?,email=?,fax=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE contact_id=?";
		else
			query = "UPDATE mymanager.user_contact SET contact_id=?,user_id=?,telephone=?,celular=?,email=?,fax=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE contact_id=?";

		setQueryType(QueryType.NORMAL);
		Contact temp = readContact(oldContact.getContactId());
		savePreviousRow(temp);

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, newContact.getContactId());
		pstmt.setString(2, newContact.getPersonId());
		pstmt.setInt(3, newContact.getTelephone());
		pstmt.setInt(4, newContact.getCelular());
		pstmt.setString(5, newContact.getEmail());
		pstmt.setString(6, newContact.getFax());
		pstmt.setString(7, newContact.getCreatedBy());
		pstmt.setObject(8, newContact.getCreatedDate());
		pstmt.setString(9, newContact.getUpdatedBy());
		pstmt.setObject(10, newContact.getUpdatedDate());
		pstmt.setInt(11, oldContact.getContactId());

		return pstmt.executeUpdate();

	}

	@Override
	public int insertContact(Contact contact) throws Exception {
		String query = null;
		if (contactType.equals(ContactType.EMPLOYEE_CONTACT))
			query = "INSERT INTO mymanager.employee_contact (contact_id,employee_id,telephone,celular,email,fax,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";
		else
			query = "INSERT INTO mymanager.user_contact (contact_id,user_id,telephone,celular,email,fax,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, contact.getContactId());
		pstmt.setString(2, contact.getPersonId());
		pstmt.setInt(3, contact.getTelephone());
		pstmt.setInt(4, contact.getCelular());
		pstmt.setString(5, contact.getEmail());
		pstmt.setString(6, contact.getFax());
		pstmt.setString(7, contact.getCreatedBy());
		pstmt.setObject(8, contact.getCreatedDate());
		pstmt.setString(9, contact.getUpdatedBy());
		pstmt.setObject(10, contact.getUpdatedDate());

		return pstmt.executeUpdate();

	}

	@Override
	public int deleteContact(Contact contact) throws Exception {
		String query = null;
		if (contactType.equals(ContactType.EMPLOYEE_CONTACT))
			query = "DELETE FROM mymanager.employee_contact WHERE contact_id=?";
		else
			query = "DELETE FROM mymanager.user_contact WHERE contact_id=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, contact.getContactId());

		return pstmt.executeUpdate();

	}

	public int savePreviousRow(Contact contact) throws Exception {
		String query = null;
		if (contactType.equals(ContactType.EMPLOYEE_CONTACT))
			query = "INSERT INTO mymanager.employee_contact_history (contact_id,employee_id,telephone,celular,email,fax,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";
		else
			query = "INSERT INTO mymanager.user_contact_history (contact_id,user_id,telephone,celular,email,fax,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, contact.getContactId());
		pstmt.setString(2, contact.getPersonId());
		pstmt.setInt(3, contact.getTelephone());
		pstmt.setInt(4, contact.getCelular());
		pstmt.setString(5, contact.getEmail());
		pstmt.setString(6, contact.getFax());
		pstmt.setString(7, contact.getCreatedBy());
		pstmt.setObject(8, contact.getCreatedDate());
		pstmt.setString(9, contact.getUpdatedBy());
		pstmt.setObject(10, contact.getUpdatedDate());

		return pstmt.executeUpdate();

	}

}
