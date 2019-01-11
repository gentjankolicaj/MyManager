package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.UserAccessObject;
import com.mymanager.data.data_access.interfaces.UserAccess;
import com.mymanager.data.models.User;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class UserServiceImpl implements UserService {
	
	private UserAccess userAccess;
	
	public UserServiceImpl() {
		super();
		this.userAccess=new UserAccessObject();
	}

	@Override
	public List<User> getAllUsers() throws Exception {
		return userAccess.findAllUsers();
	}

	@Override
	public List<User> getAllUsers(int limit, int offset) throws Exception {
		return userAccess.findAllUsers(limit, offset);
	}

	@Override
	public List<String> getAllUsersId() throws Exception {
		return userAccess.findAllUsersId();
	}

	@Override
	public List<User> getUsersByFirstName(String firstName) throws Exception {
		return userAccess.findUsersByFirstName(firstName);
	}

	@Override
	public List<User> getUsersByLastName(String lastName) throws Exception {
		return userAccess.findUsersByLastName(lastName);
	}

	@Override
	public List<User> getUsersByUserType(String userType) throws Exception {
		return userAccess.findUsersByUserType(userType);
	}

	@Override
	public List<User> getUsersByRights(String rights) throws Exception {
		return userAccess.findUsersByRights(rights);
	}

	@Override
	public User getUser(String userId) throws Exception {
		return userAccess.findUser(userId);
	}

	@Override
	public int updateUser(User oldUser, User newUser) throws Exception {
		return userAccess.updateUser(oldUser, newUser);
	}

	@Override
	public int saveUser(User user) throws Exception {
		return userAccess.saveUser(user);
	}

	@Override
	public int deleteUser(User user) throws Exception {
		return userAccess.deleteUser(user);
	}

	@Override
	public boolean validatePassword(String password, User user) {
		String userPassword=user.getPassword();
		if(userPassword.equals(password))
			return true;
		else return false;
	}

}
