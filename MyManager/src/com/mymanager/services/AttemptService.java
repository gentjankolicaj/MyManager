package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.Attempt;
import com.mymanager.data.models.Status;
import com.mymanager.data.models.User;

public interface AttemptService {

	public abstract List<Attempt> getAllAttempts() throws Exception;

	public abstract List<Attempt> getAllAttempts(int limit, int offset) throws Exception;

	public abstract List<Attempt> getAttempts(User user) throws Exception;

	public abstract List<Attempt> getAttempts(String id) throws Exception;

	public abstract List<Attempt> getAttempts(Status status) throws Exception;

	public abstract int saveAttempt(Attempt attempt) throws Exception;

	public abstract int deleteAttempt(Attempt attempt) throws Exception;
}
