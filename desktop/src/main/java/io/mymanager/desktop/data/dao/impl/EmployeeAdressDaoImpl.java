package io.mymanager.desktop.data.dao.impl;

import io.mymanager.commons.db.Database;
import io.mymanager.commons.enums.QueryType;
import io.mymanager.desktop.data.dao.EmployeeAdressDao;
import io.mymanager.desktop.data.models.Country;
import io.mymanager.desktop.data.models.EmployeeAdress;
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
public class EmployeeAdressDaoImpl implements EmployeeAdressDao {

  protected static Database database = DatabaseManager.getDb();

  private QueryType queryType;

  /**
   * @param queryType
   */
  public EmployeeAdressDaoImpl(QueryType queryType) {
    super();
    this.queryType = queryType;
  }


  public EmployeeAdressDaoImpl() {
    super();
    this.queryType = QueryType.NORMAL;
  }


  @Override
  public List<EmployeeAdress> findAllAdresses() throws Exception {
    List<EmployeeAdress> adressList = new ArrayList<>();
    ResultSet results = null;
    String query = null;

    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_adress";
    } else {
      query = "SELECT * FROM mymanager.employee_adress_history";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      EmployeeAdress temp = new EmployeeAdress(results.getInt("adress_id"),
          results.getString("employee_id"),
          new Country(results.getString("country")), results.getString("city"),
          results.getString("street_name"), results.getInt("zipcode"),
          results.getString("building"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      adressList.add(temp);

    }
    PrintUtils.print(adressList, PrintType.QUERY_RESULTS);
    return adressList;
  }

  @Override
  public List<EmployeeAdress> findAllAdresses(int limit, int offset) throws Exception {
    List<EmployeeAdress> adressList = new ArrayList<>();
    ResultSet results = null;
    String query = null;

    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_adress LIMIT " + limit + " OFFSET " + offset;
    } else {
      query =
          "SELECT * FROM mymanager.employee_adress_history LIMIT " + limit + " OFFSET " + offset;
    }

    results = database.selectStatement(query);
    while (results.next()) {
      EmployeeAdress temp = new EmployeeAdress(results.getInt("adress_id"),
          results.getString("employee_id"),
          new Country(results.getString("country")), results.getString("city"),
          results.getString("street_name"), results.getInt("zipcode"),
          results.getString("building"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      adressList.add(temp);
    }
    PrintUtils.print(adressList, PrintType.QUERY_RESULTS);
    return adressList;
  }

  @Override
  public EmployeeAdress findAdressesByPersonId(String personId) throws Exception {
    EmployeeAdress adress = null;
    ResultSet results = null;
    String query = null;

    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_adress WHERE employee_id LIKE '" + personId + "'";
    } else {
      query = "SELECT * FROM mymanager.employee_adress_history WHERE employee_id LIKE '" + personId
          + "'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      adress = new EmployeeAdress(results.getInt("adress_id"), results.getString("employee_id"),
          new Country(results.getString("country")), results.getString("city"),
          results.getString("street_name"), results.getInt("zipcode"),
          results.getString("building"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
    }
    PrintUtils.print(adress, PrintType.QUERY_RESULTS);
    return adress;
  }

  @Override
  public List<EmployeeAdress> findAdressesByCity(String city) throws Exception {
    List<EmployeeAdress> adressList = new ArrayList<>();
    ResultSet results = null;
    String query = null;

    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_adress WHERE city LIKE '" + city + "%'";
    } else {
      query = "SELECT * FROM mymanager.employee_adress_history WHERE city LIKE '" + city + "%'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      EmployeeAdress temp = new EmployeeAdress(results.getInt("adress_id"),
          results.getString("employee_id"),
          new Country(results.getString("country")), results.getString("city"),
          results.getString("street_name"), results.getInt("zipcode"),
          results.getString("building"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      adressList.add(temp);
    }
    PrintUtils.print(adressList, PrintType.QUERY_RESULTS);
    return adressList;
  }

  @Override
  public List<EmployeeAdress> findAdressesByCountry(String country) throws Exception {
    List<EmployeeAdress> adressList = new ArrayList<>();
    ResultSet results = null;
    String query = null;

    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_adress WHERE country LIKE '" + country + "%'";
    } else {
      query =
          "SELECT * FROM mymanager.employee_adress_history WHERE country LIKE '" + country + "%'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      EmployeeAdress temp = new EmployeeAdress(results.getInt("adress_id"),
          results.getString("employee_id"),
          new Country(results.getString("country")), results.getString("city"),
          results.getString("street_name"), results.getInt("zipcode"),
          results.getString("building"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      adressList.add(temp);
    }
    PrintUtils.print(adressList, PrintType.QUERY_RESULTS);
    return adressList;
  }

  @Override
  public List<EmployeeAdress> findAdressesByStreet(String streetName) throws Exception {
    List<EmployeeAdress> adressList = new ArrayList<>();
    ResultSet results = null;
    String query = null;

    if (queryType.equals(QueryType.NORMAL)) {
      query =
          "SELECT * FROM mymanager.employee_adress WHERE street_name LIKE '" + streetName + "%'";
    } else {
      query =
          "SELECT * FROM mymanager.employee_adress_history WHERE street_name LIKE '" + streetName
              + "%'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      EmployeeAdress temp = new EmployeeAdress(results.getInt("adress_id"),
          results.getString("employee_id"),
          new Country(results.getString("country")), results.getString("city"),
          results.getString("street_name"), results.getInt("zipcode"),
          results.getString("building"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      adressList.add(temp);
    }
    PrintUtils.print(adressList, PrintType.QUERY_RESULTS);
    return adressList;
  }

  @Override
  public EmployeeAdress findAdress(int adressId) throws Exception {
    EmployeeAdress adress = null;
    ResultSet results = null;
    String query = "SELECT * FROM mymanager.employee_adress WHERE adress_id=" + adressId;
    results = database.selectStatement(query);
    while (results.next()) {
      adress = new EmployeeAdress(results.getInt("adress_id"), results.getString("employee_id"),
          new Country(results.getString("country")), results.getString("city"),
          results.getString("street_name"), results.getInt("zipcode"),
          results.getString("building"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
    }
    PrintUtils.print(adress, PrintType.QUERY_RESULTS);
    return adress;
  }

  @Override
  public int updateAdress(EmployeeAdress oldAdress, EmployeeAdress newAdress) throws Exception {

    String query = "UPDATE mymanager.employee_adress SET employee_id=?,country=?,city=?,street_name=?,zipcode=?,building=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE adress_id=?";

    setQueryType(QueryType.NORMAL);
    EmployeeAdress temp = findAdress(oldAdress.getAdressId());
    savePreviousRow(temp);

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, newAdress.getPersonId());
    pstmt.setString(2, newAdress.getCountry().getCountryName());
    pstmt.setString(3, newAdress.getCity());
    pstmt.setString(4, newAdress.getStreetName());
    pstmt.setInt(5, newAdress.getZipCode());
    pstmt.setString(6, newAdress.getBuilding());
    pstmt.setString(7, newAdress.getCreatedBy());
    pstmt.setObject(8, newAdress.getCreatedDate());
    pstmt.setString(9, newAdress.getUpdatedBy());
    pstmt.setObject(10, newAdress.getUpdatedDate());
    pstmt.setInt(11, oldAdress.getAdressId());

    return pstmt.executeUpdate();
  }

  @Override
  public int saveAdress(EmployeeAdress adress) throws Exception {
    String query = "INSERT INTO mymanager.employee_adress (employee_id,country,city,street_name,zipcode,building,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, adress.getPersonId());
    pstmt.setString(2, adress.getCountry().getCountryName());
    pstmt.setString(3, adress.getCity());
    pstmt.setString(4, adress.getStreetName());
    pstmt.setInt(5, adress.getZipCode());
    pstmt.setString(6, adress.getBuilding());
    pstmt.setString(7, adress.getCreatedBy());
    pstmt.setObject(8, adress.getCreatedDate());
    pstmt.setString(9, adress.getUpdatedBy());
    pstmt.setObject(10, adress.getUpdatedDate());

    return pstmt.executeUpdate();
  }

  @Override
  public int deleteAdress(EmployeeAdress adress) throws Exception {
    String query = "DELETE FROM mymanager.employee_adress WHERE adress_id=?";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setInt(1, adress.getAdressId());

    return pstmt.executeUpdate();
  }

  public int savePreviousRow(EmployeeAdress adress) throws Exception {
    String query = "INSERT INTO mymanager.employee_adress_history (adress_id,employee_id,country,city,street_name,zipcode,building,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setInt(1, adress.getAdressId());
    pstmt.setString(2, adress.getPersonId());
    pstmt.setString(3, adress.getCountry().getCountryName());
    pstmt.setString(4, adress.getCity());
    pstmt.setString(5, adress.getStreetName());
    pstmt.setInt(6, adress.getZipCode());
    pstmt.setString(7, adress.getBuilding());
    pstmt.setString(8, adress.getCreatedBy());
    pstmt.setObject(9, adress.getCreatedDate());
    pstmt.setString(10, adress.getUpdatedBy());
    pstmt.setObject(11, adress.getUpdatedDate());

    return pstmt.executeUpdate();

  }

  @Override
  public void setQueryType(QueryType queryType) {
    this.queryType = queryType;

  }


}
