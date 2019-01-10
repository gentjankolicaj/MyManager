package com.mymanager.services;

import java.time.LocalDate;
import java.util.List;

import com.mymanager.data.data_access.JobHistoryAccessObject;
import com.mymanager.data.data_access.interfaces.JobHistoryAccess;
import com.mymanager.data.models.JobHistory;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class JobHistoryServiceImpl implements JobHistoryService {

	
	private JobHistoryAccess jobHistoryAccess;
	
	public JobHistoryServiceImpl() {
		super();
		this.jobHistoryAccess=new JobHistoryAccessObject();
	}
	
	
	@Override
	public List<JobHistory> getAllJobHistories() throws Exception {
		return jobHistoryAccess.findAllJobHistories();
	}

	@Override
	public List<JobHistory> getAllJobHistories(int limit, int offset) throws Exception {
	return jobHistoryAccess.findAllJobHistories(limit, offset);
	}

	@Override
	public List<JobHistory> getAllJobHistoryBetweenDates(LocalDate startDate, LocalDate endDate) throws Exception {
		return jobHistoryAccess.findAllJobHistoryBetweenDates(startDate, endDate);
	}

	@Override
	public List<JobHistory> getAllJobHistoryByJobId(String jobId) throws Exception {
		return jobHistoryAccess.findAllJobHistoryByJobId(jobId);
	}

	@Override
	public List<JobHistory> getAllJobHistoryByDepartmentId(String departmentId) throws Exception {
	  return jobHistoryAccess.findAllJobHistoryByDepartmentId(departmentId);
	}


	@Override
	public List<JobHistory> getJobHistoryByEmployeeId(String employeeId) throws Exception {
		return jobHistoryAccess.findJobHistoryByEmployeeId(employeeId);
	}

	@Override
	public int updateJobHistory(JobHistory oldJobHistory, JobHistory newJobHistory) throws Exception {
		return jobHistoryAccess.updateJobHistory(oldJobHistory, newJobHistory);
	}

	@Override
	public int saveJobHistory(JobHistory jobHistory) throws Exception {
		return jobHistoryAccess.saveJobHistory(jobHistory);
	}

	@Override
	public int deleteJobHistory(JobHistory jobHistory) throws Exception {
		return jobHistoryAccess.deleteJobHistory(jobHistory);
	}

}
