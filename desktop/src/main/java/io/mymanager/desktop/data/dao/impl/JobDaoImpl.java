package io.mymanager.desktop.data.dao.impl;

import io.mymanager.commons.db.Database;
import io.mymanager.commons.enums.QueryType;
import io.mymanager.desktop.data.dao.JobDao;
import io.mymanager.desktop.data.models.Job;
import io.mymanager.desktop.db.DatabaseManager;
import io.mymanager.desktop.enums.PrintType;
import io.mymanager.desktop.util.PrintUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JobDaoImpl implements JobDao {

  protected static Database database = DatabaseManager.getDb();

  private QueryType queryType;

  /**
   *
   */
  public JobDaoImpl() {
    super();
    this.queryType = QueryType.NORMAL;
  }

  /**
   * @param queryType
   */
  public JobDaoImpl(QueryType queryType) {
    super();
    this.queryType = queryType;
  }

  public void setQueryType(QueryType queryType) {
    this.queryType = queryType;
  }

  @Override
  public List<Job> findAllJobs() throws Exception {
    List<Job> jobList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.jobs";
    } else {
      query = "SELECT * FROM mymanager.jobs_history";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      Job temp = new Job(results.getInt("job_id"), results.getString("job_title"),
          results.getFloat("max_salary"),
          results.getFloat("min_salary"), results.getString("created_by"),
          results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      jobList.add(temp);

    }
    PrintUtils.print(jobList, PrintType.QUERY_RESULTS);
    return jobList;

  }

  @Override
  public List<Job> findAllJobs(int limit, int offset) throws Exception {
    List<Job> jobList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.jobs LIMIT " + limit + " OFFSET " + offset;
    } else {
      query = "SELECT * FROM mymanager.jobs_history LIMIT " + limit + " OFFSET " + offset;
    }

    results = database.selectStatement(query);
    while (results.next()) {
      Job temp = new Job(results.getInt("job_id"), results.getString("job_title"),
          results.getFloat("max_salary"),
          results.getFloat("min_salary"), results.getString("created_by"),
          results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      jobList.add(temp);

    }
    PrintUtils.print(jobList, PrintType.QUERY_RESULTS);
    return jobList;

  }

  @Override
  public List<Job> findAllJobsBetweenSalary(float minSalary, float maxSalary) throws Exception {
    List<Job> jobList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.jobs WHERE min_salary > " + minSalary + " AND max_salary < "
          + maxSalary;
    } else {
      query = "SELECT * FROM mymanager.jobs_history WHERE min_salary > " + minSalary
          + " AND max_salary < "
          + maxSalary;
    }

    results = database.selectStatement(query);
    while (results.next()) {
      Job temp = new Job(results.getInt("job_id"), results.getString("job_title"),
          results.getFloat("max_salary"),
          results.getFloat("min_salary"), results.getString("created_by"),
          results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      jobList.add(temp);

    }
    PrintUtils.print(jobList, PrintType.QUERY_RESULTS);
    return jobList;
  }

  @Override
  public List<Job> findAllJobsByTitle(String jobTitle) throws Exception {
    List<Job> jobList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.jobs WHERE job_title LIKE '" + jobTitle + "%'";
    } else {
      query = "SELECT * FROM mymanager.jobs_history WHERE job_title LIKE '" + jobTitle + "%'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      Job temp = new Job(results.getInt("job_id"), results.getString("job_title"),
          results.getFloat("max_salary"),
          results.getFloat("min_salary"), results.getString("created_by"),
          results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      jobList.add(temp);

    }
    PrintUtils.print(jobList, PrintType.QUERY_RESULTS);
    return jobList;
  }

  @Override
  public Job findJob(int jobId) throws Exception {
    ResultSet results = null;
    Job temp = null;
    String query = "SELECT * FROM mymanager.jobs WHERE job_id=" + jobId;

    results = database.selectStatement(query);
    while (results.next()) {
      temp = new Job(results.getInt("job_id"), results.getString("job_title"),
          results.getFloat("max_salary"),
          results.getFloat("min_salary"), results.getString("created_by"),
          results.getString("updated_by"),
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
    Job temp = findJob(oldJob.getJobId());
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
  public int saveJob(Job job) throws Exception {
    String query = "INSERT INTO mymanager.jobs (job_title,min_salary,max_salary,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?)";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, job.getJobTitle());
    pstmt.setFloat(2, job.getMinSalary());
    pstmt.setFloat(3, job.getMaxSalary());
    pstmt.setString(4, job.getCreatedBy());
    pstmt.setObject(5, job.getCreatedDate());
    pstmt.setString(6, job.getUpdatedBy());
    pstmt.setObject(7, job.getUpdatedDate());

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
