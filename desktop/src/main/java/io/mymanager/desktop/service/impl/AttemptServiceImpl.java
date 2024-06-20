package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.AttemptDao;
import io.mymanager.desktop.data.dao.impl.AttemptDaoImpl;
import io.mymanager.desktop.data.models.Attempt;
import io.mymanager.desktop.data.models.Status;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.AttemptService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class AttemptServiceImpl implements AttemptService {


  private final AttemptDao attemptDao;


  public AttemptServiceImpl() {
    super();
    this.attemptDao = new AttemptDaoImpl();
  }

  @Override
  public List<Attempt> getAllAttempts() throws Exception {
    return attemptDao.findAllAttempts();
  }

  @Override
  public List<Attempt> getAllAttempts(int limit, int offset) throws Exception {
    return attemptDao.findAllAttempts(limit, offset);
  }

  @Override
  public List<Attempt> getAttempts(User user) throws Exception {
    return attemptDao.findAttempts(user);
  }

  @Override
  public List<Attempt> getAttempts(String id) throws Exception {
    return attemptDao.findAttempts(id);
  }

  @Override
  public List<Attempt> getAttempts(Status status) throws Exception {
    return attemptDao.findAttempts(status);
  }

  @Override
  public int saveAttempt(Attempt attempt) throws Exception {
    return attemptDao.saveAttempt(attempt);
  }

  @Override
  public int deleteAttempt(Attempt attempt) throws Exception {
    return attemptDao.deleteAttempt(attempt);
  }

}
