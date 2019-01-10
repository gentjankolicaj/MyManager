package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Attempt;
import com.mymanager.data.models.Status;
import com.mymanager.data.models.User;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface AttemptAccess {

	public abstract List<Attempt> findAllAttempts() throws Exception;

	public abstract List<Attempt> findAllAttempts(int limit, int offset) throws Exception;

	public abstract List<Attempt> findAttempts(User user) throws Exception;

	public abstract List<Attempt> findAttempts(String id) throws Exception;

	public abstract List<Attempt> findAttempts(Status status) throws Exception;

	public abstract int saveAttempt(Attempt attempt) throws Exception;

	public abstract int deleteAttempt(Attempt attempt) throws Exception;

}
