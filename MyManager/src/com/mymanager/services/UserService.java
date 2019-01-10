package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.User;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface UserService {
	
	public abstract List<User> getAllUsers() throws Exception;

	public abstract List<User> getAllUsers(int limit, int offset) throws Exception;

	public abstract List<String> getAllUsersId() throws Exception;

	public abstract List<User> getUsersByFirstName(String firstName) throws Exception;

	public abstract List<User> getUsersByLastName(String lastName) throws Exception;

	public abstract List<User> getUsersByUserType(String userType) throws Exception;

	public abstract List<User> getUsersByRights(String rights) throws Exception;

	public abstract User getUser(String userId) throws Exception;

	public abstract int updateUser(User oldUser, User newUser) throws Exception;

	public abstract int saveUser(User user) throws Exception;

	public abstract int deleteUser(User user) throws Exception;


}
