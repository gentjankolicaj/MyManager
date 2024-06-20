package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.UserDao;
import io.mymanager.desktop.data.dao.impl.UserDaoImpl;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.UserService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  public UserServiceImpl() {
    super();
    this.userDao = new UserDaoImpl();
  }

  @Override
  public List<User> getAllUsers() throws Exception {
    return userDao.findAllUsers();
  }

  @Override
  public List<User> getAllUsers(int limit, int offset) throws Exception {
    return userDao.findAllUsers(limit, offset);
  }

  @Override
  public List<String> getAllUserIds() throws Exception {
    return userDao.findAllUserIds();
  }

  @Override
  public List<User> getUsersByFirstName(String firstName) throws Exception {
    return userDao.findUsersByFirstName(firstName);
  }

  @Override
  public List<User> getUsersByLastName(String lastName) throws Exception {
    return userDao.findUsersByLastName(lastName);
  }

  @Override
  public List<User> getUsersByUserType(String userType) throws Exception {
    return userDao.findUsersByUserType(userType);
  }

  @Override
  public List<User> getUsersByRights(String rights) throws Exception {
    return userDao.findUsersByRights(rights);
  }

  @Override
  public User getUser(String userId) throws Exception {
    return userDao.findUser(userId);
  }

  @Override
  public int updateUser(User oldUser, User newUser) throws Exception {
    return userDao.updateUser(oldUser, newUser);
  }

  @Override
  public int saveUser(User user) throws Exception {
    return userDao.saveUser(user);
  }

  @Override
  public int deleteUser(User user) throws Exception {
    return userDao.deleteUser(user);
  }

  @Override
  public boolean validatePassword(String password, User user) {
    String userPassword = user.getPassword();
    return userPassword.equals(password);
  }

}
