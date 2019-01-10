package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.Job;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface JobService {

	public abstract List<Job> getAllJobs() throws Exception;

	public abstract List<Job> getAllJobs(int limit, int offset) throws Exception;

	public abstract List<Job> getAllJobsBetweenSalary(float minSalary, float maxSalary) throws Exception;

	public abstract List<Job> getAllJobsByTitle(String jobTitle) throws Exception;

	public abstract Job getJob(int jobId) throws Exception;

	public abstract int updateJob(Job oldJob, Job newJob) throws Exception;

	public abstract int saveJob(Job job) throws Exception;

	public abstract int deleteJob(Job job) throws Exception;
}
