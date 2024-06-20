package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.User;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface UserDao {

  List<User> findAllUsers() throws Exception;

  List<User> findAllUsers(int limit, int offset) throws Exception;

  List<String> findAllUserIds() throws Exception;

  List<User> findUsersByFirstName(String firstName) throws Exception;

  List<User> findUsersByLastName(String lastName) throws Exception;

  List<User> findUsersByUserType(String userType) throws Exception;

  List<User> findUsersByRights(String rights) throws Exception;

  User findUser(String userId) throws Exception;

  int updateUser(User oldUser, User newUser) throws Exception;

  int saveUser(User user) throws Exception;

  int deleteUser(User user) throws Exception;

}
