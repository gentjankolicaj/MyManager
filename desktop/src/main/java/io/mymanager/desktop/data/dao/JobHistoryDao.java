package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.JobHistory;
import java.time.LocalDate;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface JobHistoryDao {

  List<JobHistory> findAllJobHistories() throws Exception;

  List<JobHistory> findAllJobHistories(int limit, int offset) throws Exception;

  List<JobHistory> findAllJobHistoryBetweenDates(LocalDate startDate, LocalDate endDate)
      throws Exception;

  List<JobHistory> findAllJobHistoryByJobId(String jobId) throws Exception;

  List<JobHistory> findAllJobHistoryByDepartmentId(String departmentId) throws Exception;

  List<JobHistory> findJobHistoryByEmployeeId(String employeeId) throws Exception;

  int updateJobHistory(JobHistory oldJobHistory, JobHistory newJobHistory) throws Exception;

  int saveJobHistory(JobHistory jobHistory) throws Exception;

  int deleteJobHistory(JobHistory jobHistory) throws Exception;

}
