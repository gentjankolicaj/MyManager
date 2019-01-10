package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.JobAccessObject;
import com.mymanager.data.data_access.interfaces.JobAccess;
import com.mymanager.data.models.Job;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class JobServiceImpl implements JobService {

	
	private JobAccess jobAccess;
	
	public JobServiceImpl() {
		super();
		this.jobAccess=new JobAccessObject();
	}
	
	@Override
	public List<Job> getAllJobs() throws Exception {
		return jobAccess.findAllJobs();
	}

	@Override
	public List<Job> getAllJobs(int limit, int offset) throws Exception {
		return jobAccess.findAllJobs(limit, offset);
	}

	@Override
	public List<Job> getAllJobsBetweenSalary(float minSalary, float maxSalary) throws Exception {
		return jobAccess.findAllJobsBetweenSalary(minSalary, maxSalary);
	}

	@Override
	public List<Job> getAllJobsByTitle(String jobTitle) throws Exception {
		return jobAccess.findAllJobsByTitle(jobTitle);
	}

	@Override
	public Job getJob(int jobId) throws Exception {
		return jobAccess.findJob(jobId);
	}

	@Override
	public int updateJob(Job oldJob, Job newJob) throws Exception {
		return jobAccess.updateJob(oldJob, newJob);
	}

	@Override
	public int saveJob(Job job) throws Exception {
	   return jobAccess.saveJob(job);
	}

	@Override
	public int deleteJob(Job job) throws Exception {
		return jobAccess.deleteJob(job);
	}

}
