package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.JobDao;
import io.mymanager.desktop.data.dao.impl.JobDaoImpl;
import io.mymanager.desktop.data.models.Job;
import io.mymanager.desktop.service.JobService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class JobServiceImpl implements JobService {


  private final JobDao jobDao;

  public JobServiceImpl() {
    super();
    this.jobDao = new JobDaoImpl();
  }

  @Override
  public List<Job> getAllJobs() throws Exception {
    return jobDao.findAllJobs();
  }

  @Override
  public List<Job> getAllJobs(int limit, int offset) throws Exception {
    return jobDao.findAllJobs(limit, offset);
  }

  @Override
  public List<Job> getAllJobsBetweenSalary(float minSalary, float maxSalary) throws Exception {
    return jobDao.findAllJobsBetweenSalary(minSalary, maxSalary);
  }

  @Override
  public List<Job> getAllJobsByTitle(String jobTitle) throws Exception {
    return jobDao.findAllJobsByTitle(jobTitle);
  }

  @Override
  public Job getJob(int jobId) throws Exception {
    return jobDao.findJob(jobId);
  }

  @Override
  public int updateJob(Job oldJob, Job newJob) throws Exception {
    return jobDao.updateJob(oldJob, newJob);
  }

  @Override
  public int saveJob(Job job) throws Exception {
    return jobDao.saveJob(job);
  }

  @Override
  public int deleteJob(Job job) throws Exception {
    return jobDao.deleteJob(job);
  }

}
