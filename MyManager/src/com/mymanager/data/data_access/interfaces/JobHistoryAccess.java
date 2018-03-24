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

	public abstract List<JobHistory> readAllJobHistories();

	public abstract List<JobHistory> readAllJobHistoryBetweenDates(LocalDate startDate, LocalDate endDate);

	public abstract List<JobHistory> readAllJobHistoryByJobId(String jobId);

	public abstract List<JobHistory> readAllJobHistoryByDepartmentId(String departmentId);

	public abstract List<JobHistory> readAllJobHistoryByEmployeeId(String employeeId);

	public abstract int updateJobHistory(JobHistory jobHistory);

	public abstract int insertJobHistory(JobHistory jobHistory);

	public abstract int deleteJobHistory(JobHistory jobHistory);

}
