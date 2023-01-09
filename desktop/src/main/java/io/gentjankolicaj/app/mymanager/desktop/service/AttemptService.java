package io.gentjankolicaj.app.mymanager.desktop.service;

import io.gentjankolicaj.app.mymanager.desktop.data.models.Attempt;
import io.gentjankolicaj.app.mymanager.desktop.data.models.Status;
import io.gentjankolicaj.app.mymanager.desktop.data.models.User;

import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface AttemptService {

    List<Attempt> getAllAttempts() throws Exception;

	List<Attempt> getAllAttempts(int limit, int offset) throws Exception;

	List<Attempt> getAttempts(User user) throws Exception;

	List<Attempt> getAttempts(String id) throws Exception;

	List<Attempt> getAttempts(Status status) throws Exception;

	int saveAttempt(Attempt attempt) throws Exception;

	int deleteAttempt(Attempt attempt) throws Exception;
}
