package io.mymanager.desktop.data.dao.impl;

import io.mymanager.commons.db.Database;
import io.mymanager.commons.enums.QueryType;
import io.mymanager.desktop.data.dao.AdditionalDao;
import io.mymanager.desktop.data.models.Additional;
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
public class AdditionalDaoImpl implements AdditionalDao {

  protected static Database database = DatabaseManager.getDb();

  private QueryType queryType;

  public AdditionalDaoImpl() {
    this.queryType = QueryType.NORMAL;
  }

  public AdditionalDaoImpl(QueryType queryType) {
    this.queryType = queryType;
  }

  public void setQueryType(QueryType queryType) {
    this.queryType = queryType;

  }

  @Override
  public List<Additional> findAllAdditionals() throws Exception {
    List<Additional> additionalList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_additional";
    } else {
      query = "SELECT * FROM mymanager.employee_additional_history";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      Additional temp = new Additional(results.getString("employee_id"),
          results.getFloat("salary_amount"),
          results.getDate("hire_date").toLocalDate(), results.getString("created_by"),
          results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      additionalList.add(temp);

    }
    PrintUtils.print(additionalList, PrintType.QUERY_RESULTS);
    return additionalList;

  }

  @Override
  public List<Additional> findAllAdditionals(int limit, int offset) throws Exception {
    List<Additional> additionalList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_additional LIMIT " + limit + " OFFSET " + offset;
    } else {
      query = "SELECT * FROM mymanager.employee_additional_history LIMIT " + limit + " OFFSET "
          + offset;
    }

    results = database.selectStatement(query);
    while (results.next()) {
      Additional temp = new Additional(results.getString("employee_id"),
          results.getFloat("salary_amount"),
          results.getDate("hire_date").toLocalDate(), results.getString("created_by"),
          results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      additionalList.add(temp);

    }
    PrintUtils.print(additionalList, PrintType.QUERY_RESULTS);
    return additionalList;

  }

  @Override
  public Additional findAdditional(String employeeId) throws Exception {
    Additional additional = null;
    ResultSet results = null;
    String query = "SELECT * FROM mymanager.employee_additional WHERE employee_id=" + employeeId;

    results = database.selectStatement(query);
    while (results.next()) {
      additional = new Additional(results.getString("employee_id"),
          results.getFloat("salary_amount"),
          results.getDate("hire_date").toLocalDate(), results.getString("created_by"),
          results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
    }
    PrintUtils.print(additional, PrintType.QUERY_RESULTS);
    return additional;
  }

  @Override
  public int updateAdditional(Additional oldAdditional, Additional newAdditional) throws Exception {
    String query = "UPDATE mymanager.employee_additional SET employee_id=?,salary_amount=?,hire_date=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE employee_id=?";

    setQueryType(QueryType.NORMAL);
    Additional temp = findAdditional(oldAdditional.getEmployeeId());
    savePreviousRow(temp);

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, newAdditional.getEmployeeId());
    pstmt.setFloat(2, newAdditional.getSalaryAmount());
    pstmt.setObject(3, newAdditional.getHireDate());
    pstmt.setString(4, newAdditional.getCreatedBy());
    pstmt.setObject(5, newAdditional.getCreatedDate());
    pstmt.setString(6, newAdditional.getUpdatedBy());
    pstmt.setObject(7, newAdditional.getUpdatedDate());
    pstmt.setString(8, oldAdditional.getEmployeeId());

    return pstmt.executeUpdate();

  }

  @Override
  public int saveAdditional(Additional additional) throws Exception {
    String query = "INSERT INTO mymanager.employee_additional (employee_id,salary_amount,hire_date,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?)";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, additional.getEmployeeId());
    pstmt.setFloat(2, additional.getSalaryAmount());
    pstmt.setObject(3, additional.getHireDate());
    pstmt.setString(4, additional.getCreatedBy());
    pstmt.setObject(5, additional.getCreatedDate());
    pstmt.setString(6, additional.getUpdatedBy());
    pstmt.setObject(7, additional.getUpdatedDate());

    return pstmt.executeUpdate();

  }

  @Override
  public int deleteAdditional(Additional additional) throws Exception {
    String query = "DELETE FROM mymanager.employee_additional WHERE employee_id=?";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, additional.getEmployeeId());

    return pstmt.executeUpdate();

  }

  public int savePreviousRow(Additional additional) throws Exception {
    String query = "INSERT INTO mymanager.employee_additional_history (employee_id,salary_amount,hire_date,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?)";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, additional.getEmployeeId());
    pstmt.setFloat(2, additional.getSalaryAmount());
    pstmt.setObject(3, additional.getHireDate());
    pstmt.setString(4, additional.getCreatedBy());
    pstmt.setObject(5, additional.getCreatedDate());
    pstmt.setString(6, additional.getUpdatedBy());
    pstmt.setObject(7, additional.getUpdatedDate());

    return pstmt.executeUpdate();

  }

}
