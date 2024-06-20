package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.JobHistoryDao;
import io.mymanager.desktop.data.dao.impl.JobHistoryDaoImpl;
import io.mymanager.desktop.data.models.JobHistory;
import io.mymanager.desktop.service.JobHistoryService;
import java.time.LocalDate;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class JobHistoryServiceImpl implements JobHistoryService {


  private final JobHistoryDao jobHistoryDao;

  public JobHistoryServiceImpl() {
    super();
    this.jobHistoryDao = new JobHistoryDaoImpl();
  }


  @Override
  public List<JobHistory> getAllJobHistories() throws Exception {
    return jobHistoryDao.findAllJobHistories();
  }

  @Override
  public List<JobHistory> getAllJobHistories(int limit, int offset) throws Exception {
    return jobHistoryDao.findAllJobHistories(limit, offset);
  }

  @Override
  public List<JobHistory> getAllJobHistoryBetweenDates(LocalDate startDate, LocalDate endDate)
      throws Exception {
    return jobHistoryDao.findAllJobHistoryBetweenDates(startDate, endDate);
  }

  @Override
  public List<JobHistory> getAllJobHistoryByJobId(String jobId) throws Exception {
    return jobHistoryDao.findAllJobHistoryByJobId(jobId);
  }

  @Override
  public List<JobHistory> getAllJobHistoryByDepartmentId(String departmentId) throws Exception {
    return jobHistoryDao.findAllJobHistoryByDepartmentId(departmentId);
  }


  @Override
  public List<JobHistory> getJobHistoryByEmployeeId(String employeeId) throws Exception {
    return jobHistoryDao.findJobHistoryByEmployeeId(employeeId);
  }

  @Override
  public int updateJobHistory(JobHistory oldJobHistory, JobHistory newJobHistory) throws Exception {
    return jobHistoryDao.updateJobHistory(oldJobHistory, newJobHistory);
  }

  @Override
  public int saveJobHistory(JobHistory jobHistory) throws Exception {
    return jobHistoryDao.saveJobHistory(jobHistory);
  }

  @Override
  public int deleteJobHistory(JobHistory jobHistory) throws Exception {
    return jobHistoryDao.deleteJobHistory(jobHistory);
  }

}
