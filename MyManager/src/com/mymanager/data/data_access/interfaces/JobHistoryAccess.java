package com.mymanager.data.data_access.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.mymanager.data.models.JobHistory;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface JobHistoryAccess {

	public abstract List<JobHistory> findAllJobHistories() throws Exception;

	public abstract List<JobHistory> findAllJobHistories(int limit, int offset) throws Exception;

	public abstract List<JobHistory> findAllJobHistoryBetweenDates(LocalDate startDate, LocalDate endDate)
			throws Exception;

	public abstract List<JobHistory> findAllJobHistoryByJobId(String jobId) throws Exception;

	public abstract List<JobHistory> findAllJobHistoryByDepartmentId(String departmentId) throws Exception;

	public abstract List<JobHistory> findAllJobHistoryByEmployeeId(String employeeId) throws Exception;

	public abstract List<JobHistory> findJobHistoryByEmployeeId(String employeeId) throws Exception;

	public abstract int updateJobHistory(JobHistory oldJobHistory, JobHistory newJobHistory) throws Exception;

	public abstract int saveJobHistory(JobHistory jobHistory) throws Exception;

	public abstract int deleteJobHistory(JobHistory jobHistory) throws Exception;

}
