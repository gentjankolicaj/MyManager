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
				query = "SELECT * FROM employee_contact";
			else
				query = "SELECT * FROM employee_contact_history";

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getString("employee_id"), results.getInt("telephone"),
						results.getInt("celular"), results.getString("email"), results.getString("fax"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;

		} else {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM user_contact";
			else
				query = "SELECT * FROM user_contact_history";

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getString("user_id"), results.getInt("telephone"),
						results.getInt("celular"), results.getString("email"), results.getString("fax"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;
		}

	}

	@Override
	public List<Contact> readContacts(int celular) throws Exception {
		List<Contact> contactList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (contactType.equals(ContactType.EMPLOYEE_CONTACT)) {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM employee_contact WHERE celular LIKE '" + celular + "%'";
			else
				query = "SELECT * FROM employee_contact_history WHERE celular LIKE '" + celular + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getString("employee_id"), results.getInt("telephone"),
						results.getInt("celular"), results.getString("email"), results.getString("fax"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;

		} else {

			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM user_contact WHERE celular LIKE'" + celular + "%'";
			else
				query = "SELECT * FROM user_contact_history WHERE celular LIKE'" + celular + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getString("user_id"), results.getInt("telephone"),
						results.getInt("celular"), results.getString("email"), results.getString("fax"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;

		}

	}

	@Override
	public List<Contact> readContacts(String email) throws Exception {
		List<Contact> contactList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (contactType.equals(ContactType.EMPLOYEE_CONTACT)) {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM employee_contact WHERE email LIKE '" + email + "%'";
			else
				query = "SELECT * FROM employee_contact_history email LIKE '" + email + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getString("employee_id"), results.getInt("telephone"),
						results.getInt("celular"), results.getString("email"), results.getString("fax"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;

		} else {

			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM user_contact WHERE email LIKE '" + email + "%'";
			else
				query = "SELECT * FROM user_contact_history WHERE email LIKE '" + email + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getString("user_id"), results.getInt("telephone"),
						results.getInt("celular"), results.getString("email"), results.getString("fax"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;
		}
	}

	@Override
	public List<Contact> readContact(Contact contact) throws Exception {
		List<Contact> contactList = new ArrayList<>();
		ResultSet results = null;
		String query = null;

		if (contactType.equals(ContactType.EMPLOYEE_CONTACT)) {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM employee_contact WHERE employee_id=" + contact.getId();
			else
				query = "SELECT * FROM employee_contact_history WHERE employee_id=" + contact.getId();

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getString("employee_id"), results.getInt("telephone"),
						results.getInt("celular"), results.getString("email"), results.getString("fax"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;

		} else {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM user_contact WHERE user_id=" + contact.getId();
			else
				query = "SELECT * FROM user_contact_history WHERE user_id=" + contact.getId();

			results = database.selectStatement(query);
			while (results.next()) {
				Contact temp = new Contact(results.getString("user_id"), results.getInt("telephone"),
						results.getInt("celular"), results.getString("email"), results.getString("fax"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;
		}
	}

	@Override
	public int updateContact(Contact contact) throws Exception {
		String query = null;
		if (contactType.equals(ContactType.EMPLOYEE_CONTACT))
			query = "UPDATE employee_contact SET telephone=?,celular=?,email=?,fax=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE employee_id=?";
		else
			query = "UPDATE user_contact SET telephone=?,celular=?,email=?,fax=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE user_id=?";

		setQueryType(QueryType.NORMAL);
		List<Contact> temp = readContact(contact);
		savePreviousRow(temp);

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, contact.getTelephone());
		pstmt.setInt(2, contact.getCelular());
		pstmt.setString(3, contact.getEmail());
		pstmt.setString(4, contact.getFax());
		pstmt.setString(5, contact.getCreatedBy());
		pstmt.setObject(6, contact.getCreatedDate());
		pstmt.setString(7, contact.getUpdatedBy());
		pstmt.setObject(8, contact.getUpdatedDate());
		pstmt.setString(9, contact.getId());

		return pstmt.executeUpdate();

	}

	@Override
	public int insertContact(Contact contact) throws Exception {
		String query = null;
		if (contactType.equals(ContactType.EMPLOYEE_CONTACT))
			query = "INSERT INTO employee_contact (employee_id,telephone,celular,email,fax,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?)";
		else
			query = "INSERT INTO user_contact (user_id,telephone,celular,email,fax,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, contact.getId());
		pstmt.setInt(2, contact.getTelephone());
		pstmt.setInt(3, contact.getCelular());
		pstmt.setString(4, contact.getEmail());
		pstmt.setString(5, contact.getFax());
		pstmt.setString(6, contact.getCreatedBy());
		pstmt.setObject(7, contact.getCreatedDate());
		pstmt.setString(8, contact.getUpdatedBy());
		pstmt.setObject(9, contact.getUpdatedDate());

		return pstmt.executeUpdate();

	}

	@Override
	public int deleteContact(Contact contact) throws Exception {
		String query = null;
		if (contactType.equals(ContactType.EMPLOYEE_CONTACT))
			query = "DELETE FROM employee_contact WHERE employee_id=?" + contact.getId();
		else
			query = "DELETE FROM user_contact WHERE user_id=?" + contact.getId();

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, contact.getId());

		return pstmt.executeUpdate();

	}

	public int savePreviousRow(List<Contact> contactList) throws Exception {
		String query = null;
		if (contactType.equals(ContactType.EMPLOYEE_CONTACT))
			query = "INSERT INTO employee_contact_history (employee_id,telephone,celular,email,fax,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?)";
		else
			query = "INSERT INTO user_contact_history (user_id,telephone,celular,email,fax,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?)";
		Contact temp = contactList.get(0);

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, temp.getId());
		pstmt.setInt(2, temp.getTelephone());
		pstmt.setInt(3, temp.getCelular());
		pstmt.setString(4, temp.getEmail());
		pstmt.setString(5, temp.getFax());
		pstmt.setString(6, temp.getCreatedBy());
		pstmt.setObject(7, temp.getCreatedDate());
		pstmt.setString(8, temp.getUpdatedBy());
		pstmt.setObject(9, temp.getUpdatedDate());

		return pstmt.executeUpdate();

	}

}
