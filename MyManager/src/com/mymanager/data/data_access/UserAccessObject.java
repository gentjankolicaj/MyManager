package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.UserAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Rights;
import com.mymanager.data.models.User;
import com.mymanager.data.models.UserType;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class UserAccessObject implements UserAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	@Override
	public List<User> readAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readUsersByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readUsersByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readUsersByUserType(UserType userType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readUsersByRights(Rights rights) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readUser(String userId) {
		// TODO Auto-generated method stub
		return null;
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
