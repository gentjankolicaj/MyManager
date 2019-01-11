package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.EmployeeContactAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.EmployeeContact;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class EmployeeContactAccessObject implements EmployeeContactAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	
	public EmployeeContactAccessObject() {
		super();
		this.queryType=QueryType.NORMAL;
	}
	
	public EmployeeContactAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<EmployeeContact> findAllContacts() throws Exception {
		List<EmployeeContact> contactList = new ArrayList<>();
		ResultSet results = null;
		String query = null;

			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.employee_contact";
			else
				query = "SELECT * FROM mymanager.employee_contact_history";

			results = database.selectStatement(query);
			while (results.next()) {
				EmployeeContact temp = new EmployeeContact(results.getInt("contact_id"), results.getString("employee_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;
	}

	@Override
	public List<EmployeeContact> findAllContacts(int limit, int offset) throws Exception {
		List<EmployeeContact> contactList = new ArrayList<>();
		ResultSet results = null;
		String query = null;

			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.employee_contact LIMIT " + limit + " OFFSET " + offset;
			else
				query = "SELECT * FROM mymanager.employee_contact_history LIMIT " + limit + " OFFSET " + offset;

			results = database.selectStatement(query);
			while (results.next()) {
				EmployeeContact temp = new EmployeeContact(results.getInt("contact_id"), results.getString("employee_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;

	}

	@Override
	public List<EmployeeContact> findContactsByCelular(int celular) throws Exception {
		List<EmployeeContact> contactList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.employee_contact WHERE celular LIKE '" + celular + "%'";
			else
				query = "SELECT * FROM mymanager.employee_contact_history WHERE celular LIKE '" + celular + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				EmployeeContact temp = new EmployeeContact(results.getInt("contact_id"), results.getString("employee_id"),
						results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
						results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				contactList.add(temp);
			}
			PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
			return contactList;
	}

	@Override
	public List<EmployeeContact> findContactsByEmail(String email) throws Exception {
		List<EmployeeContact> contactList = new ArrayList<>();
		ResultSet results = null;
		String query = null;

		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.employee_contact WHERE email LIKE '" + email + "%'";
		else
			query = "SELECT * FROM mymanager.employee_contact_history email LIKE '" + email + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			EmployeeContact temp = new EmployeeContact(results.getInt("contact_id"), results.getString("employee_id"),
					results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
					results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			contactList.add(temp);
		}
		PrintUtils.print(contactList, PrintType.QUERY_RESULTS);
		return contactList;
	}

	@Override
	public EmployeeContact findContactByPersonId(String personId) throws Exception {
		EmployeeContact contact = null;
		ResultSet results = null;
		String query = null;

		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.employee_contact WHERE employee_id LIKE '" + personId + "'";
		else
			query = "SELECT * FROM mymanager.employee_contact_history WHERE employee_id LIKE '" + personId + "'";

		results = database.selectStatement(query);
		while (results.next()) {
			contact = new EmployeeContact(results.getInt("contact_id"), results.getString("employee_id"),
					results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
					results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
		}
		PrintUtils.print(contact, PrintType.QUERY_RESULTS);
		return contact;
	}

	@Override
	public EmployeeContact findContact(int contactId) throws Exception {
		EmployeeContact contact = null;
		ResultSet results = null;

		String query = "SELECT * FROM mymanager.employee_contact WHERE contact_id=" + contactId;

		results = database.selectStatement(query);
		while (results.next()) {
			contact = new EmployeeContact(results.getInt("contact_id"), results.getString("employee_id"),
					results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
					results.getString("fax"), results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
		}
		PrintUtils.print(contact, PrintType.QUERY_RESULTS);
		return contact;
	}

	@Override
	public int updateContact(EmployeeContact oldContact, EmployeeContact newContact) throws Exception {

		String query = "UPDATE mymanager.employee_contact SET contact_id=?,employee_id=?,telephone=?,celular=?,email=?,fax=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE contact_id=?";

		setQueryType(QueryType.NORMAL);

		// finds previous row and saves it into history tables
		EmployeeContact temp = findContact(oldContact.getContactId());
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
	public int saveContact(EmployeeContact contact) throws Exception {
		String query = "INSERT INTO mymanager.employee_contact (employee_id,telephone,celular,email,fax,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, contact.getPersonId());
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
	public int deleteContact(EmployeeContact contact) throws Exception {
		String query = "DELETE FROM mymanager.employee_contact WHERE contact_id=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, contact.getContactId());

		return pstmt.executeUpdate();
	}

	public int savePreviousRow(EmployeeContact contact) throws Exception {
		String query = "INSERT INTO mymanager.employee_contact_history (contact_id,employee_id,telephone,celular,email,fax,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

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
