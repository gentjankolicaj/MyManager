package com.mymanager.data.data_access;

import java.time.LocalDate;
import java.util.List;

import com.mymanager.data.data_access.interfaces.JobHistoryAccess;
import com.mymanager.data.models.JobHistory;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class JobHistoryAccessObject implements JobHistoryAccess {

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
