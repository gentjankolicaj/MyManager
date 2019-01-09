package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.AttemptAccessObject;
import com.mymanager.data.data_access.interfaces.AttemptAccess;
import com.mymanager.data.models.Attempt;
import com.mymanager.data.models.Status;
import com.mymanager.data.models.User;

public class AttemptServiceImpl implements AttemptService {
	
	
	private AttemptAccess attemptAccess;
	
	

	public AttemptServiceImpl() {
		super();
		this.attemptAccess=new AttemptAccessObject();
	}

	@Override
	public List<Attempt> getAllAttempts() throws Exception {
		return attemptAccess.findAllAttempts();
	}

	@Override
	public List<Attempt> getAllAttempts(int limit, int offset) throws Exception {
		return attemptAccess.findAllAttempts(limit,offset);
	}

	@Override
	public List<Attempt> getAttempts(User user) throws Exception {
		return attemptAccess.findAttempts(user);
	}

	@Override
	public List<Attempt> getAttempts(String id) throws Exception {
		return attemptAccess.findAttempts(id);
	}

	@Override
	public List<Attempt> getAttempts(Status status) throws Exception {
		return attemptAccess.findAttempts(status);
	}

	@Override
	public int saveAttempt(Attempt attempt) throws Exception {
		return attemptAccess.saveAttempt(attempt);
	}

	@Override
	public int deleteAttempt(Attempt attempt) throws Exception {
		return attemptAccess.deleteAttempt(attempt);
	}

}
