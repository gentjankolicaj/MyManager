package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.User;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface UserAccess {

	public abstract List<User> findAllUsers() throws Exception;

	public abstract List<User> findAllUsers(int limit, int offset) throws Exception;

	public abstract List<String> findAllUserIds() throws Exception;

	public abstract List<User> findUsersByFirstName(String firstName) throws Exception;

	public abstract List<User> findUsersByLastName(String lastName) throws Exception;

	public abstract List<User> findUsersByUserType(String userType) throws Exception;

	public abstract List<User> findUsersByRights(String rights) throws Exception;

	public abstract User findUser(String userId) throws Exception;

	public abstract int updateUser(User oldUser, User newUser) throws Exception;

	public abstract int saveUser(User user) throws Exception;

	public abstract int deleteUser(User user) throws Exception;

}
