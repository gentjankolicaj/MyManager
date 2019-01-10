package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Job;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface JobAccess {

	public abstract List<Job> findAllJobs() throws Exception;

	public abstract List<Job> findAllJobs(int limit, int offset) throws Exception;

	public abstract List<Job> findAllJobsBetweenSalary(float minSalary, float maxSalary) throws Exception;

	public abstract List<Job> findAllJobsByTitle(String jobTitle) throws Exception;

	public abstract Job findJob(int jobId) throws Exception;

	public abstract int updateJob(Job oldJob, Job newJob) throws Exception;

	public abstract int saveJob(Job job) throws Exception;

	public abstract int deleteJob(Job job) throws Exception;

}
