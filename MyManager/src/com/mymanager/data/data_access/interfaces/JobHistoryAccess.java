package com.mymanager.data.data_access.interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.mymanager.data.models.JobHistory;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface JobHistoryAccess {

	public abstract List<JobHistory> readAllJobHistories() throws Exception;

	public abstract List<JobHistory> readAllJobHistories(int limit, int offset) throws Exception;

	public abstract List<JobHistory> readAllJobHistoryBetweenDates(LocalDate startDate, LocalDate endDate)
			throws Exception;

	public abstract List<JobHistory> readAllJobHistoryByJobId(String jobId) throws Exception;

	public abstract List<JobHistory> readAllJobHistoryByDepartmentId(String departmentId) throws Exception;

	public abstract List<JobHistory> readAllJobHistoryByEmployeeId(String employeeId) throws Exception;

	public abstract JobHistory readJobHistoryByEmployeeId(String employeeId, LocalDateTime createDate) throws Exception;

	public abstract int updateJobHistory(JobHistory oldJobHistory, JobHistory newJobHistory) throws Exception;

	public abstract int insertJobHistory(JobHistory jobHistory) throws Exception;

	public abstract int deleteJobHistory(JobHistory jobHistory) throws Exception;

}
