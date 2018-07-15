package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.User;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface UserAccess {

	public abstract List<User> readAllUsers() throws Exception;

	public abstract List<User> readAllUsersId() throws Exception;

	public abstract List<User> readUsersByFirstName(String firstName) throws Exception;

	public abstract List<User> readUsersByLastName(String lastName) throws Exception;

	public abstract List<User> readUsersByUserType(String userType) throws Exception;

	public abstract List<User> readUsersByRights(String rights) throws Exception;

	public abstract User readUser(String userId) throws Exception;

	public abstract int updateUser(User oldUser, User newUser) throws Exception;

	public abstract int insertUser(User user) throws Exception;

	public abstract int deleteUser(User user) throws Exception;

}
