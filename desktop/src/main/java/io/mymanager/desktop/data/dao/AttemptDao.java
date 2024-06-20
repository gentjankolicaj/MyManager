package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.Attempt;
import io.mymanager.desktop.data.models.Status;
import io.mymanager.desktop.data.models.User;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface AttemptDao {

  List<Attempt> findAllAttempts() throws Exception;

  List<Attempt> findAllAttempts(int limit, int offset) throws Exception;

  List<Attempt> findAttempts(User user) throws Exception;

  List<Attempt> findAttempts(String id) throws Exception;

  List<Attempt> findAttempts(Status status) throws Exception;

  int saveAttempt(Attempt attempt) throws Exception;

  int deleteAttempt(Attempt attempt) throws Exception;

}
