package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.Job;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface JobService {

  List<Job> getAllJobs() throws Exception;

  List<Job> getAllJobs(int limit, int offset) throws Exception;

  List<Job> getAllJobsBetweenSalary(float minSalary, float maxSalary) throws Exception;

  List<Job> getAllJobsByTitle(String jobTitle) throws Exception;

  Job getJob(int jobId) throws Exception;

  int updateJob(Job oldJob, Job newJob) throws Exception;

  int saveJob(Job job) throws Exception;

  int deleteJob(Job job) throws Exception;
}
