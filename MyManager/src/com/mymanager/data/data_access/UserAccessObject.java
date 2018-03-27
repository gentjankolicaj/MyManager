package com.mymanager.data.data_access;

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
		String query = "Select * from users";
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
		String query = "Select * from users where first_name like '" + firstName + "%'";
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
		String query = "Select * from users where last_name like '" + lastName + "%'";
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
		String query = "Select * from users where user_type=" + userType.name();
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
		String query = "Select * from users where rights=" + rights.name();
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
	public User readUser(String userId) {
		ResultSet results = null;
		User temp = null;
		String query = "Select * from users where user_id=" + userId;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
