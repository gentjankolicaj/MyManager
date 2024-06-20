package io.mymanager.desktop.data.dao.impl;

import io.mymanager.commons.db.Database;
import io.mymanager.desktop.data.dao.AttemptDao;
import io.mymanager.desktop.data.models.Attempt;
import io.mymanager.desktop.data.models.Status;
import io.mymanager.desktop.data.models.User;
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
public class AttemptDaoImpl implements AttemptDao {

  protected static Database database = DatabaseManager.getDb();

  public AttemptDaoImpl() {
    super();

  }

  @Override
  public List<Attempt> findAllAttempts() throws Exception {
    List<Attempt> atemptList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    query = "SELECT * FROM mymanager.attempts";

    results = database.selectStatement(query);
    while (results.next()) {
      Attempt temp = new Attempt(results.getInt("index"), results.getString("user"),
          results.getString("password"), Status.valueOf(results.getString("status")),
          results.getString("description"), results.getTimestamp("date_time").toLocalDateTime());
      atemptList.add(temp);

    }
    PrintUtils.print(atemptList, PrintType.QUERY_RESULTS);
    return atemptList;
  }

  @Override
  public List<Attempt> findAllAttempts(int limit, int offset) throws Exception {
    List<Attempt> atemptList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    query = "SELECT * FROM mymanager.attempts LIMIT " + limit + " OFFSET " + offset;

    results = database.selectStatement(query);
    while (results.next()) {
      Attempt temp = new Attempt(results.getInt("index"), results.getString("user"),
          results.getString("password"), Status.valueOf(results.getString("status")),
          results.getString("description"), results.getTimestamp("date_time").toLocalDateTime());
      atemptList.add(temp);

    }
    PrintUtils.print(atemptList, PrintType.QUERY_RESULTS);
    return atemptList;
  }

  @Override
  public List<Attempt> findAttempts(User user) throws Exception {
    List<Attempt> atemptList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    query = "SELECT * FROM mymanager.attempts where user LIKE '" + user.getUserId() + "%'";

    results = database.selectStatement(query);
    while (results.next()) {
      Attempt temp = new Attempt(results.getInt("index"), results.getString("user"),
          results.getString("password"), Status.valueOf(results.getString("status")),
          results.getString("description"), results.getTimestamp("date_time").toLocalDateTime());
      atemptList.add(temp);

    }
    PrintUtils.print(atemptList, PrintType.QUERY_RESULTS);
    return atemptList;
  }

  @Override
  public List<Attempt> findAttempts(Status status) throws Exception {
    List<Attempt> atemptList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    query = "SELECT * FROM mymanager.attempts where status LIKE '" + status.name() + "'";

    results = database.selectStatement(query);
    while (results.next()) {
      Attempt temp = new Attempt(results.getInt("index"), results.getString("user"),
          results.getString("password"), Status.valueOf(results.getString("status")),
          results.getString("description"), results.getTimestamp("date_time").toLocalDateTime());
      atemptList.add(temp);
    }
    PrintUtils.print(atemptList, PrintType.QUERY_RESULTS);
    return atemptList;
  }

  @Override
  public List<Attempt> findAttempts(String id) throws Exception {
    List<Attempt> attemptList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    query =
        "SELECT * FROM mymanager.attempts where `index` LIKE '" + id + "' OR `index` LIKE '" + id
            + "%'";

    results = database.selectStatement(query);
    while (results.next()) {
      Attempt attempt = new Attempt(results.getInt("index"), results.getString("user"),
          results.getString("password"), Status.valueOf(results.getString("status")),
          results.getString("description"), results.getTimestamp("date_time").toLocalDateTime());
      attemptList.add(attempt);
    }
    PrintUtils.print(attemptList, PrintType.QUERY_RESULTS);
    return attemptList;
  }

  @Override
  public int saveAttempt(Attempt atempt) throws Exception {
    String query = "INSERT INTO mymanager.attempts (user,password,status,description,date_time) VALUES (?,?,?,?,?)";
    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, atempt.getUser());
    pstmt.setString(2, atempt.getPassword());
    pstmt.setString(3, atempt.getStatus().name());
    pstmt.setString(4, atempt.getDescription());
    pstmt.setObject(5, atempt.getDateTime());

    return pstmt.executeUpdate();

  }

  @Override
  public int deleteAttempt(Attempt atempt) throws Exception {
    String query = "DELETE FROM mymanager.attempts WHERE `index`=?";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setInt(1, atempt.getIndex());

    return pstmt.executeUpdate();

  }

}
