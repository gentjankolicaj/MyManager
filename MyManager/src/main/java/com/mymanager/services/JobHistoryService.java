package com.mymanager.services;

import java.time.LocalDate;
import java.util.List;

import com.mymanager.data.models.JobHistory;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface JobHistoryService {
	
	public abstract List<JobHistory> getAllJobHistories() throws Exception;

	public abstract List<JobHistory> getAllJobHistories(int limit, int offset) throws Exception;

	public abstract List<JobHistory> getAllJobHistoryBetweenDates(LocalDate startDate, LocalDate endDate)
			throws Exception;

	public abstract List<JobHistory> getAllJobHistoryByJobId(String jobId) throws Exception;

	public abstract List<JobHistory> getAllJobHistoryByDepartmentId(String departmentId) throws Exception;


	public abstract List<JobHistory> getJobHistoryByEmployeeId(String employeeId) throws Exception;

	public abstract int updateJobHistory(JobHistory oldJobHistory, JobHistory newJobHistory) throws Exception;

	public abstract int saveJobHistory(JobHistory jobHistory) throws Exception;

	public abstract int deleteJobHistory(JobHistory jobHistory) throws Exception;

}
