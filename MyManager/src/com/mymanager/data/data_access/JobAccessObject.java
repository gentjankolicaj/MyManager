package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.JobAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Job;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

public class JobAccessObject implements JobAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public JobAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public JobAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<Job> readAllJobs() throws Exception {
		List<Job> jobList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.jobs";
		else
			query = "SELECT * FROM mymanager.jobs_history";

		results = database.selectStatement(query);
		while (results.next()) {
			Job temp = new Job(results.getInt("job_id"), results.getString("job_title"), results.getFloat("max_salary"),
					results.getFloat("min_salary"), results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			jobList.add(temp);

		}
		PrintUtils.print(jobList, PrintType.QUERY_RESULTS);
		return jobList;

	}

	@Override
	public List<Job> readAllJobsBetweenSalary(float minSalary, float maxSalary) throws Exception {
		List<Job> jobList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.jobs WHERE min_salary > " + minSalary + " AND max_salary < " + maxSalary;
		else
			query = "SELECT * FROM mymanager.jobs_history WHERE min_salary > " + minSalary + " AND max_salary < "
					+ maxSalary;

		results = database.selectStatement(query);
		while (results.next()) {
			Job temp = new Job(results.getInt("job_id"), results.getString("job_title"), results.getFloat("max_salary"),
					results.getFloat("min_salary"), results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			jobList.add(temp);

		}
		PrintUtils.print(jobList, PrintType.QUERY_RESULTS);
		return jobList;
	}

	@Override
	public List<Job> readAllJobsByTitle(String jobTitle) throws Exception {
		List<Job> jobList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.jobs WHERE job_title LIKE '" + jobTitle + "%'";
		else
			query = "SELECT * FROM mymanager.jobs_history WHERE job_title LIKE '" + jobTitle + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			Job temp = new Job(results.getInt("job_id"), results.getString("job_title"), results.getFloat("max_salary"),
					results.getFloat("min_salary"), results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			jobList.add(temp);

		}
		PrintUtils.print(jobList, PrintType.QUERY_RESULTS);
		return jobList;
	}

	@Override
	public Job readJob(Job job) throws Exception {
		ResultSet results = null;
		Job temp = null;
		String query = "SELECT * FROM mymanager.jobs WHERE job_id=" + job.getJobId();

		results = database.selectStatement(query);
		while (results.next()) {
			temp = new Job(results.getInt("job_id"), results.getString("job_title"), results.getFloat("max_salary"),
					results.getFloat("min_salary"), results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());

		}
		PrintUtils.print(temp, PrintType.QUERY_RESULTS);
		return temp;
	}

	@Override
	public int updateJob(Job oldJob, Job newJob) throws Exception {
		String query = "UPDATE mymanager.jobs SET job_id=?,job_title=?,min_salary=?,max_salary=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE job_id=?";

		setQueryType(QueryType.NORMAL);
		Job temp = readJob(oldJob);
		savePreviousRow(temp);

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, newJob.getJobId());
		pstmt.setString(2, newJob.getJobTitle());
		pstmt.setFloat(3, newJob.getMinSalary());
		pstmt.setFloat(4, newJob.getMaxSalary());
		pstmt.setString(5, newJob.getCreatedBy());
		pstmt.setObject(6, newJob.getCreatedDate());
		pstmt.setString(7, newJob.getUpdatedBy());
		pstmt.setObject(8, newJob.getUpdatedDate());
		pstmt.setInt(9, oldJob.getJobId());

		return pstmt.executeUpdate();

	}

	@Override
	public int insertJob(Job job) throws Exception {
		String query = "INSERT INTO mymanager.jobs (job_id,job_title,min_salary,max_salary,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, job.getJobId());
		pstmt.setString(2, job.getJobTitle());
		pstmt.setFloat(3, job.getMinSalary());
		pstmt.setFloat(4, job.getMaxSalary());
		pstmt.setString(5, job.getCreatedBy());
		pstmt.setObject(6, job.getCreatedDate());
		pstmt.setString(7, job.getUpdatedBy());
		pstmt.setObject(8, job.getUpdatedDate());

		return pstmt.executeUpdate();

	}

	@Override
	public int deleteJob(Job job) throws Exception {
		String query = "DELETE FROM mymanager.jobs WHERE job_id=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, job.getJobId());

		return pstmt.executeUpdate();

	}

	public int savePreviousRow(Job job) throws Exception {
		String query = "INSERT INTO mymanager.jobs_history (job_id,job_title,min_salary,max_salary,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, job.getJobId());
		pstmt.setString(2, job.getJobTitle());
		pstmt.setFloat(3, job.getMinSalary());
		pstmt.setFloat(4, job.getMaxSalary());
		pstmt.setString(5, job.getCreatedBy());
		pstmt.setObject(6, job.getCreatedDate());
		pstmt.setString(7, job.getUpdatedBy());
		pstmt.setObject(8, job.getUpdatedDate());

		return pstmt.executeUpdate();
	}

}
