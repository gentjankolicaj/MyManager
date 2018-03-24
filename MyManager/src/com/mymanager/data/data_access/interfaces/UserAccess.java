package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Rights;
import com.mymanager.data.models.User;
import com.mymanager.data.models.UserType;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface UserAccess {

	public abstract List<User> readAllUsers();

	public abstract List<User> readUsersByFirstName(String firstName);

	public abstract List<User> readUsersByLastName(String lastName);

	public abstract List<User> readUsersByUserType(UserType userType);

	public abstract List<User> readUsersByRights(Rights rights);

	public abstract User readUser(String userId);

	public abstract int updateUser(User user);

	public abstract int insertUser(User user);

	public abstract int deleteUser(User user);

}
