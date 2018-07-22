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

	public abstract List<Attempt> readAllAttempts() throws Exception;

	public abstract List<Attempt> readAtempts(User user) throws Exception;

	public abstract List<Attempt> readAtempts(String id) throws Exception;

	public abstract List<Attempt> readAtempts(Status status) throws Exception;

	public abstract int insertAttempt(Attempt attempt) throws Exception;

	public abstract int deleteAttempt(Attempt attempt) throws Exception;

}
