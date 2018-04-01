package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public List<Job> readAllJobs() {
		List<Job> jobList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM jobs";
		else
			query = "SELECT * FROM jobs_history";

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Job temp = new Job(results.getInt("job_id"), results.getString("job_title"),
						results.getFloat("max_salary"), results.getFloat("min_salary"), results.getString("created_by"),
						results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				jobList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(jobList, PrintType.QUERY_RESULTS);

		return jobList;

	}

	@Override
	public List<Job> readAllJobsBetweenSalary(float minSalary, float maxSalary) {
		List<Job> jobList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM jobs WHERE min_salary>" + minSalary + " AND max_salary<" + maxSalary;
		else
			query = "SELECT * FROM jobs_history WHERE min_salary>" + minSalary + " AND max_salary<" + maxSalary;

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Job temp = new Job(results.getInt("job_id"), results.getString("job_title"),
						results.getFloat("max_salary"), results.getFloat("min_salary"), results.getString("created_by"),
						results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				jobList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(jobList, PrintType.QUERY_RESULTS);

		return jobList;
	}

	@Override
	public List<Job> readAllJobsByTitle(String jobTitle) {
		List<Job> jobList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM jobs WHERE job_title LIKE '" + jobTitle + "%'";
		else
			query = "SELECT * FROM jobs_history WHERE job_title LIKE '" + jobTitle + "%'";
		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Job temp = new Job(results.getInt("job_id"), results.getString("job_title"),
						results.getFloat("max_salary"), results.getFloat("min_salary"), results.getString("created_by"),
						results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				jobList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(jobList, PrintType.QUERY_RESULTS);

		return jobList;
	}

	@Override
	public Job readJob(Job job) {
		ResultSet results = null;
		Job temp = null;
		String query = null;

		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM jobs WHERE job_id=" + job.getJobId();
		else
			query = "SELECT * FROM jobs_history WHERE job_id=" + job.getJobId();
		try {
			results = database.selectStatement(query);
			while (results.next()) {
				temp = new Job(results.getInt("job_id"), results.getString("job_title"), results.getFloat("max_salary"),
						results.getFloat("min_salary"), results.getString("created_by"),
						results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(temp, PrintType.QUERY_RESULTS);

		return temp;
	}

	@Override
	public int updateJob(Job job) {
		String query = "UPDATE jobs SET " + "job_title=?," + "min_salary=?," + "max_salary=?,created_by=?,"
				+ "created_date=?," + "updated_by=?," + "updated_date=? WHERE job_id=?";
		setQueryType(QueryType.NORMAL);
		Job temp = readJob(job);
		savePreviousRow(temp);

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, job.getJobTitle());
			pstmt.setFloat(2, job.getMinSalary());
			pstmt.setFloat(3, job.getMaxSalary());
			pstmt.setString(4, job.getCreatedBy());
			pstmt.setObject(5, job.getCreatedDate());
			pstmt.setString(6, job.getUpdatedBy());
			pstmt.setObject(7, job.getUpdatedDate());
			pstmt.setInt(8, job.getJobId());

			pstmt.executeUpdate();
			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

	@Override
	public int insertJob(Job job) {
		String query = "INSERT INTO jobs (job_id,job_title,min_salary,max_salary,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?)";

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setInt(1, job.getJobId());
			pstmt.setString(2, job.getJobTitle());
			pstmt.setFloat(3, job.getMinSalary());
			pstmt.setFloat(4, job.getMaxSalary());
			pstmt.setString(5, job.getCreatedBy());
			pstmt.setObject(6, job.getCreatedDate());
			pstmt.setString(7, job.getUpdatedBy());
			pstmt.setObject(8, job.getUpdatedDate());

			pstmt.executeUpdate();
			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

	@Override
	public int deleteJob(Job job) {
		String query = "DELETE FROM jobs WHERE job_id=?";
		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setInt(1, job.getJobId());
			pstmt.executeUpdate();

			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

	public int savePreviousRow(Job job) {
		String query = "INSERT INTO jobs_history (job_id,job_title,min_salary,max_salary,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?)";
		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setInt(1, job.getJobId());
			pstmt.setString(2, job.getJobTitle());
			pstmt.setFloat(3, job.getMinSalary());
			pstmt.setFloat(4, job.getMaxSalary());
			pstmt.setString(5, job.getCreatedBy());
			pstmt.setObject(6, job.getCreatedDate());
			pstmt.setString(7, job.getUpdatedBy());
			pstmt.setObject(8, job.getUpdatedDate());

			pstmt.executeUpdate();
			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

}
