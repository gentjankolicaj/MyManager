package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.JobAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Job;

public class JobAccessObject implements JobAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public JobAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public JobAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<Job> readAllJobs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> readAllJobsBetweenSalary(float minSalary, float maxSalary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> readAllJobsByTitle(String jobTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Job readJob(int jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateJob(Job job) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertJob(Job job) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteJob(Job job) {
		// TODO Auto-generated method stub
		return 0;
	}

}
