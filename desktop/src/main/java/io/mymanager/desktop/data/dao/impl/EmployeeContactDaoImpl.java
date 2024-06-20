package io.mymanager.desktop.data.dao.impl;

import io.mymanager.commons.db.Database;
import io.mymanager.commons.enums.QueryType;
import io.mymanager.desktop.data.dao.EmployeeContactDao;
import io.mymanager.desktop.data.models.EmployeeContact;
import io.mymanager.desktop.db.DatabaseManager;
import io.mymanager.desktop.enums.PrintType;
import io.mymanager.desktop.util.PrintUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class EmployeeContactDaoImpl implements EmployeeContactDao {

  protected static Database database = DatabaseManager.getDb();

  private QueryType queryType;


  public EmployeeContactDaoImpl() {
    super();
    this.queryType = QueryType.NORMAL;
  }

  public EmployeeContactDaoImpl(QueryType queryType) {
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

    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_contact";
    } else {
      query = "SELECT * FROM mymanager.employee_contact_history";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      EmployeeContact temp = new EmployeeContact(results.getInt("contact_id"),
          results.getString("employee_id"),
          results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
          results.getString("fax"), results.getString("created_by"),
          results.getString("updated_by"),
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

    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_contact LIMIT " + limit + " OFFSET " + offset;
    } else {
      query =
          "SELECT * FROM mymanager.employee_contact_history LIMIT " + limit + " OFFSET " + offset;
    }

    results = database.selectStatement(query);
    while (results.next()) {
      EmployeeContact temp = new EmployeeContact(results.getInt("contact_id"),
          results.getString("employee_id"),
          results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
          results.getString("fax"), results.getString("created_by"),
          results.getString("updated_by"),
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

    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_contact WHERE celular LIKE '" + celular + "%'";
    } else {
      query =
          "SELECT * FROM mymanager.employee_contact_history WHERE celular LIKE '" + celular + "%'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      EmployeeContact temp = new EmployeeContact(results.getInt("contact_id"),
          results.getString("employee_id"),
          results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
          results.getString("fax"), results.getString("created_by"),
          results.getString("updated_by"),
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

    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_contact WHERE email LIKE '" + email + "%'";
    } else {
      query = "SELECT * FROM mymanager.employee_contact_history email LIKE '" + email + "%'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      EmployeeContact temp = new EmployeeContact(results.getInt("contact_id"),
          results.getString("employee_id"),
          results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
          results.getString("fax"), results.getString("created_by"),
          results.getString("updated_by"),
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

    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_contact WHERE employee_id LIKE '" + personId + "'";
    } else {
      query = "SELECT * FROM mymanager.employee_contact_history WHERE employee_id LIKE '" + personId
          + "'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      contact = new EmployeeContact(results.getInt("contact_id"), results.getString("employee_id"),
          results.getInt("telephone"), results.getInt("celular"), results.getString("email"),
          results.getString("fax"), results.getString("created_by"),
          results.getString("updated_by"),
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
          results.getString("fax"), results.getString("created_by"),
          results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
    }
    PrintUtils.print(contact, PrintType.QUERY_RESULTS);
    return contact;
  }

  @Override
  public int updateContact(EmployeeContact oldContact, EmployeeContact newContact)
      throws Exception {

    String query = "UPDATE mymanager.employee_contact SET employee_id=?,telephone=?,celular=?,email=?,fax=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE contact_id=?";

    setQueryType(QueryType.NORMAL);

    // finds previous row and saves it into history tables
    EmployeeContact temp = findContact(oldContact.getContactId());
    savePreviousRow(temp);

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, newContact.getPersonId());
    pstmt.setInt(2, newContact.getTelephone());
    pstmt.setInt(3, newContact.getCelular());
    pstmt.setString(4, newContact.getEmail());
    pstmt.setString(5, newContact.getFax());
    pstmt.setString(6, newContact.getCreatedBy());
    pstmt.setObject(7, newContact.getCreatedDate());
    pstmt.setString(8, newContact.getUpdatedBy());
    pstmt.setObject(9, newContact.getUpdatedDate());
    pstmt.setInt(10, oldContact.getContactId());

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
