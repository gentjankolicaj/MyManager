package io.mymanager.desktop.data.dao.impl;

import io.mymanager.commons.db.Database;
import io.mymanager.commons.enums.QueryType;
import io.mymanager.desktop.data.dao.UserDao;
import io.mymanager.desktop.data.models.Gender;
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
public class UserDaoImpl implements UserDao {

  protected static Database database = DatabaseManager.getDb();

  private QueryType queryType;

  /**
   *
   */
  public UserDaoImpl() {
    super();
    this.queryType = QueryType.NORMAL;
  }

  /**
   * @param queryType
   */
  public UserDaoImpl(QueryType queryType) {
    super();
    this.queryType = queryType;
  }

  public void setQueryType(QueryType queryType) {
    this.queryType = queryType;
  }

  @Override
  public List<User> findAllUsers() throws Exception {
    List<User> userList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.users";
    } else {
      query = "SELECT * FROM mymanager.users_history";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      User temp = new User(results.getString("user_id"), results.getString("user_type"),
          results.getString("first_name"), results.getString("last_name"),
          results.getString("password"),
          results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
          Gender.valueOf(results.getString("gender")), results.getString("rights"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      userList.add(temp);

    }
    PrintUtils.print(userList, PrintType.QUERY_RESULTS);
    return userList;
  }

  @Override
  public List<User> findAllUsers(int limit, int offset) throws Exception {
    List<User> userList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.users LIMIT " + limit + " OFFSET " + offset;
    } else {
      query = "SELECT * FROM mymanager.users_history LIMIT " + limit + " OFFSET " + offset;
    }

    results = database.selectStatement(query);
    while (results.next()) {
      User temp = new User(results.getString("user_id"), results.getString("user_type"),
          results.getString("first_name"), results.getString("last_name"),
          results.getString("password"),
          results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
          Gender.valueOf(results.getString("gender")), results.getString("rights"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      userList.add(temp);

    }
    PrintUtils.print(userList, PrintType.QUERY_RESULTS);
    return userList;
  }

  @Override
  public List<User> findUsersByFirstName(String firstName) throws Exception {
    List<User> userList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.users WHERE first_name LIKE '" + firstName + "%'";
    } else {
      query = "SELECT * FROM mymanager.users_history WHERE first_name LIKE '" + firstName + "%'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      User temp = new User(results.getString("user_id"), results.getString("user_type"),
          results.getString("first_name"), results.getString("last_name"),
          results.getString("password"),
          results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
          Gender.valueOf(results.getString("gender")), results.getString("rights"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      userList.add(temp);

    }
    PrintUtils.print(userList, PrintType.QUERY_RESULTS);
    return userList;
  }

  @Override
  public List<User> findUsersByLastName(String lastName) throws Exception {
    List<User> userList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.users WHERE last_name LIKE '" + lastName + "%'";
    } else {
      query = "SELECT * FROM mymanager.users_history WHERE last_name LIKE '" + lastName + "%'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      User temp = new User(results.getString("user_id"), results.getString("user_type"),
          results.getString("first_name"), results.getString("last_name"),
          results.getString("password"),
          results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
          Gender.valueOf(results.getString("gender")), results.getString("rights"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      userList.add(temp);

    }
    PrintUtils.print(userList, PrintType.QUERY_RESULTS);
    return userList;
  }

  @Override
  public List<User> findUsersByUserType(String userType) throws Exception {
    List<User> userList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.users WHERE user_type LIKE '" + userType + "%'";
    } else {
      query = "SELECT * FROM mymanager.users_history WHERE user_type LIKE '" + userType + "%'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      User temp = new User(results.getString("user_id"), results.getString("user_type"),
          results.getString("first_name"), results.getString("last_name"),
          results.getString("password"),
          results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
          Gender.valueOf(results.getString("gender")), results.getString("rights"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      userList.add(temp);

    }
    PrintUtils.print(userList, PrintType.QUERY_RESULTS);
    return userList;
  }

  @Override
  public List<User> findUsersByRights(String rights) throws Exception {
    List<User> userList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.users WHERE rights LIKE '%" + rights + "%'";
    } else {
      query = "SELECT * FROM mymanager.users_history WHERE rights LIKE '%" + rights + "%'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      User temp = new User(results.getString("user_id"), results.getString("user_type"),
          results.getString("first_name"), results.getString("last_name"),
          results.getString("password"),
          results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
          Gender.valueOf(results.getString("gender")), results.getString("rights"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());

      userList.add(temp);

    }
    PrintUtils.print(userList, PrintType.QUERY_RESULTS);
    return userList;
  }

  @Override
  public User findUser(String userId) throws Exception {
    ResultSet results = null;
    User userLocal = null;
    String query = "SELECT * FROM mymanager.users WHERE user_id LIKE '" + userId + "'";

    results = database.selectStatement(query);
    while (results.next()) {
      userLocal = new User(results.getString("user_id"), results.getString("user_type"),
          results.getString("first_name"), results.getString("last_name"),
          results.getString("password"),
          results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
          Gender.valueOf(results.getString("gender")), results.getString("rights"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());

    }
    PrintUtils.print(userLocal, PrintType.QUERY_RESULTS);
    return userLocal;
  }

  @Override
  public int updateUser(User oldUser, User newUser) throws Exception {
    String query =
        "UPDATE mymanager.users SET user_id=?,user_type =?,first_name=?,last_name=?,password=?,birthday=?,"
            + "birthplace=?,gender=?,rights=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE user_id=?";

    setQueryType(QueryType.NORMAL);
    User temp = findUser(oldUser.getUserId());
    savePreviousRow(temp);

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, newUser.getUserId());
    pstmt.setString(2, newUser.getUserType());
    pstmt.setString(3, newUser.getFirstName());
    pstmt.setString(4, newUser.getLastName());
    pstmt.setString(5, newUser.getPassword());
    pstmt.setObject(6, newUser.getBirthday());
    pstmt.setString(7, newUser.getBirthplace());
    pstmt.setString(8, newUser.getGender().name());
    pstmt.setString(9, newUser.getRights());
    pstmt.setString(10, newUser.getCreatedBy());
    pstmt.setObject(11, newUser.getCreatedDate());
    pstmt.setString(12, newUser.getUpdatedBy());
    pstmt.setObject(13, newUser.getUpdatedDate());
    pstmt.setString(14, oldUser.getUserId());

    return pstmt.executeUpdate();
  }

  @Override
  public int saveUser(User user) throws Exception {
    String query = "INSERT INTO mymanager.users (user_id,user_type,first_name,last_name,password,"
        + "birthday,birthplace,gender,rights,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, user.getUserId());
    pstmt.setString(2, user.getUserType());
    pstmt.setString(3, user.getFirstName());
    pstmt.setString(4, user.getLastName());
    pstmt.setString(5, user.getPassword());
    pstmt.setObject(6, user.getBirthday());
    pstmt.setString(7, user.getBirthplace());
    pstmt.setString(8, user.getGender().name());
    pstmt.setString(9, user.getRights());
    pstmt.setString(10, user.getCreatedBy());
    pstmt.setObject(11, user.getCreatedDate());
    pstmt.setString(12, user.getUpdatedBy());
    pstmt.setObject(13, user.getUpdatedDate());

    return pstmt.executeUpdate();
  }

  @Override
  public int deleteUser(User user) throws Exception {
    String query = "DELETE FROM mymanager.users WHERE user_id=?";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, user.getUserId());
    pstmt.executeUpdate();

    return pstmt.executeUpdate();
  }

  public int savePreviousRow(User user) throws Exception {
    String query =
        "INSERT INTO mymanager.users_history (user_id,user_type,first_name,last_name,password,"
            + "birthday,birthplace,gender,rights,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, user.getUserId());
    pstmt.setString(2, user.getUserType());
    pstmt.setString(3, user.getFirstName());
    pstmt.setString(4, user.getLastName());
    pstmt.setString(5, user.getPassword());
    pstmt.setObject(6, user.getBirthday());
    pstmt.setString(7, user.getBirthplace());
    pstmt.setString(8, user.getGender().name());
    pstmt.setString(9, user.getRights());
    pstmt.setString(10, user.getCreatedBy());
    pstmt.setObject(11, user.getCreatedDate());
    pstmt.setString(12, user.getUpdatedBy());
    pstmt.setObject(13, user.getUpdatedDate());

    return pstmt.executeUpdate();
  }

  @Override
  public List<String> findAllUserIds() throws Exception {
    List<String> userIdList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.users";
    } else {
      query = "SELECT * FROM mymanager.users_history";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      userIdList.add(results.getString("user_id"));


    }
    PrintUtils.print(userIdList, PrintType.QUERY_RESULTS);
    return userIdList;
  }

}
