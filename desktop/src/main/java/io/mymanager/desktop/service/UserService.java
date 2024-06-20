package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.User;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface UserService {

  List<User> getAllUsers() throws Exception;

  List<User> getAllUsers(int limit, int offset) throws Exception;

  List<String> getAllUserIds() throws Exception;

  List<User> getUsersByFirstName(String firstName) throws Exception;

  List<User> getUsersByLastName(String lastName) throws Exception;

  List<User> getUsersByUserType(String userType) throws Exception;

  List<User> getUsersByRights(String rights) throws Exception;

  User getUser(String userId) throws Exception;

  int updateUser(User oldUser, User newUser) throws Exception;

  int saveUser(User user) throws Exception;

  int deleteUser(User user) throws Exception;

  boolean validatePassword(String password, User user);


}
