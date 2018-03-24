package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Job;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface JobAccess {

	public abstract List<Job> readAllJobs();

	public abstract List<Job> readAllJobsBetweenSalary(float minSalary, float maxSalary);

	public abstract List<Job> readAllJobsByTitle(String jobTitle);

	public abstract Job readJob(int jobId);

	public abstract int updateJob(Job job);

	public abstract int insertJob(Job job);

	public abstract int deleteJob(Job job);

}
