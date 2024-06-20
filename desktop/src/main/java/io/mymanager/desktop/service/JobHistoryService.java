package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.JobHistory;
import java.time.LocalDate;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface JobHistoryService {

  List<JobHistory> getAllJobHistories() throws Exception;

  List<JobHistory> getAllJobHistories(int limit, int offset) throws Exception;

  List<JobHistory> getAllJobHistoryBetweenDates(LocalDate startDate, LocalDate endDate)
      throws Exception;

  List<JobHistory> getAllJobHistoryByJobId(String jobId) throws Exception;

  List<JobHistory> getAllJobHistoryByDepartmentId(String departmentId) throws Exception;


  List<JobHistory> getJobHistoryByEmployeeId(String employeeId) throws Exception;

  int updateJobHistory(JobHistory oldJobHistory, JobHistory newJobHistory) throws Exception;

  int saveJobHistory(JobHistory jobHistory) throws Exception;

  int deleteJobHistory(JobHistory jobHistory) throws Exception;

}
