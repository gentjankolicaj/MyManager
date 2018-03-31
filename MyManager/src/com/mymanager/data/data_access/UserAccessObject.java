package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.UserAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Gender;
import com.mymanager.data.models.Rights;
import com.mymanager.data.models.User;
import com.mymanager.data.models.UserType;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class UserAccessObject implements UserAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public UserAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public UserAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<User> readAllUsers() {
		List<User> userList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM users";
		else
			query = "SELECT * FROM users_history";

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				User temp = new User(results.getString("user_id"), UserType.valueOf(results.getString("user_type")),
						results.getString("first_name"), results.getString("last_name"), results.getString("password"),
						results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
						Gender.valueOf(results.getString("gender")), Rights.valueOf(results.getString("rights")),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				userList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(userList, PrintType.QUERY_RESULTS);

		return userList;

	}

	@Override
	public List<User> readUsersByFirstName(String firstName) {
		List<User> userList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM users WHERE first_name LIKE '" + firstName + "%'";
		else
			query = "SELECT * FROM users_history WHERE first_name LIKE '" + firstName + "%'";

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				User temp = new User(results.getString("user_id"), UserType.valueOf(results.getString("user_type")),
						results.getString("first_name"), results.getString("last_name"), results.getString("password"),
						results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
						Gender.valueOf(results.getString("gender")), Rights.valueOf(results.getString("rights")),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				userList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(userList, PrintType.QUERY_RESULTS);

		return userList;

	}

	@Override
	public List<User> readUsersByLastName(String lastName) {
		List<User> userList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM users WHERE last_name LIKE '" + lastName + "%'";
		else
			query = "SELECT * FROM users_history WHERE last_name LIKE '" + lastName + "%'";

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				User temp = new User(results.getString("user_id"), UserType.valueOf(results.getString("user_type")),
						results.getString("first_name"), results.getString("last_name"), results.getString("password"),
						results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
						Gender.valueOf(results.getString("gender")), Rights.valueOf(results.getString("rights")),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				userList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(userList, PrintType.QUERY_RESULTS);

		return userList;
	}

	@Override
	public List<User> readUsersByUserType(UserType userType) {
		List<User> userList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM users WHERE user_type=" + userType.name();
		else
			query = "SELECT * FROM users_history WHERE user_type=" + userType.name();

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				User temp = new User(results.getString("user_id"), UserType.valueOf(results.getString("user_type")),
						results.getString("first_name"), results.getString("last_name"), results.getString("password"),
						results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
						Gender.valueOf(results.getString("gender")), Rights.valueOf(results.getString("rights")),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				userList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(userList, PrintType.QUERY_RESULTS);

		return userList;
	}

	@Override
	public List<User> readUsersByRights(Rights rights) {
		List<User> userList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM users WHERE rights=" + rights.name();
		else
			query = "SELECT * FROM users_history WHERE rights=" + rights.name();
		try {
			results = database.selectStatement(query);
			while (results.next()) {
				User temp = new User(results.getString("user_id"), UserType.valueOf(results.getString("user_type")),
						results.getString("first_name"), results.getString("last_name"), results.getString("password"),
						results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
						Gender.valueOf(results.getString("gender")), Rights.valueOf(results.getString("rights")),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				userList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(userList, PrintType.QUERY_RESULTS);

		return userList;
	}

	@Override
	public User readUser(User user) {
		ResultSet results = null;
		User temp = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM users WHERE user_id=" + user.getUserId();
		else
			query = "SELECT * FROM users_history WHERE user_id=" + user.getUserId();

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				temp = new User(results.getString("user_id"), UserType.valueOf(results.getString("user_type")),
						results.getString("first_name"), results.getString("last_name"), results.getString("password"),
						results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
						Gender.valueOf(results.getString("gender")), Rights.valueOf(results.getString("rights")),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(temp, PrintType.QUERY_RESULTS);

		return temp;

	}

	@Override
	public int updateUser(User user) {
		String query = "UPDATE users SET" + " user_type =?," + "first_name=?," + "last_name=?," + "password=?,"
				+ "birthday=?," + "birthplace=?," + "gender=?," + "rights=?," + "created_by=?," + "created_date=?,"
				+ "updated_by=?," + "updated_date=? WHERE user_id=?";
		setQueryType(QueryType.NORMAL);
		User temp = readUser(user);
		savePreviousRow(temp);

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, user.getUserType().name());
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getPassword());
			pstmt.setObject(5, user.getBirthday());
			pstmt.setString(6, user.getBirthplace());
			pstmt.setString(7, user.getGender().name());
			pstmt.setString(8, user.getRights().name());
			pstmt.setString(9, user.getCreatedBy());
			pstmt.setObject(10, user.getCreatedDate());
			pstmt.setString(11, user.getUpdatedBy());
			pstmt.setObject(12, user.getUpdatedDate());
			pstmt.setString(13, user.getUserId());

			pstmt.executeUpdate();
			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

	@Override
	public int insertUser(User user) {
		String query = "INSERT INTO users (user_id,user_type,first_name,last_name,password,"
				+ "birthday,birthplace,gender,rights,created_by,created_date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserType().name());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setString(5, user.getPassword());
			pstmt.setObject(6, user.getBirthday());
			pstmt.setString(7, user.getBirthplace());
			pstmt.setString(8, user.getGender().name());
			pstmt.setString(9, user.getRights().name());
			pstmt.setString(10, user.getCreatedBy());
			pstmt.setObject(11, user.getCreatedDate());

			pstmt.executeUpdate();
			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

	@Override
	public int deleteUser(User user) {
		String query = "DELETE FROM users WHERE user_id=?";

		User temp = readUser(user);
		savePreviousRow(temp);

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, user.getUserId());

			pstmt.executeUpdate();
			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

	public int savePreviousRow(User user) {
		String query = "INSERT INTO users_history (user_id,user_type,first_name,last_name,password,"
				+ "birthday,birthplace,gender,rights,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserType().name());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setString(5, user.getPassword());
			pstmt.setObject(6, user.getBirthday());
			pstmt.setString(7, user.getBirthplace());
			pstmt.setString(8, user.getGender().name());
			pstmt.setString(9, user.getRights().name());
			pstmt.setString(10, user.getCreatedBy());
			pstmt.setObject(11, user.getCreatedDate());
			pstmt.setString(12, user.getUpdatedBy());
			pstmt.setObject(13, user.getUpdatedDate());

			pstmt.executeUpdate();
			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

}
