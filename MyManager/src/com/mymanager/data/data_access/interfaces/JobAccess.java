package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Job;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface JobAccess {

	public abstract List<Job> readAllJobs() throws Exception;

	public abstract List<Job> readAllJobsBetweenSalary(float minSalary, float maxSalary) throws Exception;

	public abstract List<Job> readAllJobsByTitle(String jobTitle) throws Exception;

	public abstract Job readJob(int jobId) throws Exception;

	public abstract int updateJob(Job oldJob, Job newJob) throws Exception;

	public abstract int insertJob(Job job) throws Exception;

	public abstract int deleteJob(Job job) throws Exception;

}
