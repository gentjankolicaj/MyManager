package com.mymanager.data.data_access;

import java.time.LocalDate;
import java.util.List;

import com.mymanager.data.data_access.interfaces.JobHistoryAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.JobHistory;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class JobHistoryAccessObject implements JobHistoryAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public JobHistoryAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public JobHistoryAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<JobHistory> readAllJobHistories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobHistory> readAllJobHistoryBetweenDates(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobHistory> readAllJobHistoryByJobId(String jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobHistory> readAllJobHistoryByDepartmentId(String departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobHistory> readAllJobHistoryByEmployeeId(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateJobHistory(JobHistory jobHistory) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertJobHistory(JobHistory jobHistory) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteJobHistory(JobHistory jobHistory) {
		// TODO Auto-generated method stub
		return 0;
	}

}
