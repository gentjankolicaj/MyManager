package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.Job;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface JobDao {

  List<Job> findAllJobs() throws Exception;

  List<Job> findAllJobs(int limit, int offset) throws Exception;

  List<Job> findAllJobsBetweenSalary(float minSalary, float maxSalary) throws Exception;

  List<Job> findAllJobsByTitle(String jobTitle) throws Exception;

  Job findJob(int jobId) throws Exception;

  int updateJob(Job oldJob, Job newJob) throws Exception;

  int saveJob(Job job) throws Exception;

  int deleteJob(Job job) throws Exception;

}
