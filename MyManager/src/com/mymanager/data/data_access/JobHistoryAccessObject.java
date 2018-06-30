package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mymanager.data.data_access.interfaces.JobHistoryAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.JobHistory;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class JobHistoryAccessObject implements JobHistoryAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public JobHistoryAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public JobHistoryAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<JobHistory> readAllJobHistories() throws Exception {
		List<JobHistory> jobHistoryList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.job_history";
		else
			query = "SELECT * FROM mymanager.job_history_history";

		results = database.selectStatement(query);
		while (results.next()) {
			JobHistory temp = new JobHistory(results.getString("employee_id"),
					results.getDate("start_date").toLocalDate(), results.getDate("end_date").toLocalDate(),
					results.getString("job_id"), results.getString("department_id"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			jobHistoryList.add(temp);

		}
		PrintUtils.print(jobHistoryList, PrintType.QUERY_RESULTS);
		return jobHistoryList;
	}

	@Override
	public List<JobHistory> readAllJobHistoryBetweenDates(LocalDate startDate, LocalDate endDate) throws Exception {
		List<JobHistory> jobHistoryList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.job_history WHERE start_date > ? AND end_date < ?";
		else
			query = "SELECT * FROM mymanager.job_history_history WHERE start_date > ? AND end_date < ?";

		List<Object> list = Arrays.asList(startDate, endDate);
		results = database.selectStatement(query, list);
		while (results.next()) {
			JobHistory temp = new JobHistory(results.getString("employee_id"),
					results.getDate("start_date").toLocalDate(), results.getDate("end_date").toLocalDate(),
					results.getString("job_id"), results.getString("department_id"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			jobHistoryList.add(temp);

		}
		PrintUtils.print(jobHistoryList, PrintType.QUERY_RESULTS);
		return jobHistoryList;
	}

	@Override
	public List<JobHistory> readAllJobHistoryByJobId(String jobId) throws Exception {
		List<JobHistory> jobHistoryList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.job_history WHERE job_id=" + jobId;
		else
			query = "SELECT * FROM mymanager.job_history_history WHERE job_id=" + jobId;

		results = database.selectStatement(query);
		while (results.next()) {
			JobHistory temp = new JobHistory(results.getString("employee_id"),
					results.getDate("start_date").toLocalDate(), results.getDate("end_date").toLocalDate(),
					results.getString("job_id"), results.getString("department_id"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			jobHistoryList.add(temp);

		}
		PrintUtils.print(jobHistoryList, PrintType.QUERY_RESULTS);
		return jobHistoryList;
	}

	@Override
	public List<JobHistory> readAllJobHistoryByDepartmentId(String departmentId) throws Exception {
		List<JobHistory> jobHistoryList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.job_history WHERE department_id=" + departmentId;
		else
			query = "SELECT * FROM mymanager.job_history_history WHERE department_id=" + departmentId;

		results = database.selectStatement(query);
		while (results.next()) {
			JobHistory temp = new JobHistory(results.getString("employee_id"),
					results.getDate("start_date").toLocalDate(), results.getDate("end_date").toLocalDate(),
					results.getString("job_id"), results.getString("department_id"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			jobHistoryList.add(temp);

		}
		PrintUtils.print(jobHistoryList, PrintType.QUERY_RESULTS);
		return jobHistoryList;
	}

	@Override
	public List<JobHistory> readAllJobHistoryByEmployeeId(String employeeId) throws Exception {
		List<JobHistory> jobHistoryList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.job_history WHERE employee_id=" + employeeId;
		else
			query = "SELECT * FROM mymanager.job_history_history WHERE employee_id=" + employeeId;

		results = database.selectStatement(query);
		while (results.next()) {
			JobHistory temp = new JobHistory(results.getString("employee_id"),
					results.getDate("start_date").toLocalDate(), results.getDate("end_date").toLocalDate(),
					results.getString("job_id"), results.getString("department_id"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			jobHistoryList.add(temp);

		}
		PrintUtils.print(jobHistoryList, PrintType.QUERY_RESULTS);
		return jobHistoryList;
	}

	@Override
	public JobHistory readJobHistoryByEmployeeId(String employeeId, LocalDateTime createdDateTime) throws Exception {
		JobHistory jobHistory = null;
		ResultSet results = null;
		String query = "SELECT * FROM mymanager.job_history WHERE employee_id=? AND created_date=?";

		results = database.selectStatement(query, Arrays.asList(employeeId, createdDateTime));
		while (results.next()) {
			jobHistory = new JobHistory(results.getString("employee_id"), results.getDate("start_date").toLocalDate(),
					results.getDate("end_date").toLocalDate(), results.getString("job_id"),
					results.getString("department_id"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
		}
		PrintUtils.print(jobHistory, PrintType.QUERY_RESULTS);
		return jobHistory;
	}

	@Override
	public int updateJobHistory(JobHistory oldJobHistory, JobHistory newJobHistory) throws Exception {
		String query = "UPDATE mymanager.job_history SET employee_id=?,start_date=?,end_date=?,job_id=?,department_id=?,"
				+ "created_by=?,created_date=?,updated_by=?,updated_date=? WHERE employee_id=? AND created_date=?";

		setQueryType(QueryType.NORMAL);
		JobHistory temp = readJobHistoryByEmployeeId(oldJobHistory.getDepartmentId(), oldJobHistory.getCreatedDate());
		savePreviousRow(temp);

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, newJobHistory.getEmployeeId());
		pstmt.setObject(2, newJobHistory.getStartDate());
		pstmt.setObject(3, newJobHistory.getEndDate());
		pstmt.setString(4, newJobHistory.getJobId());
		pstmt.setString(5, newJobHistory.getDepartmentId());
		pstmt.setString(6, newJobHistory.getCreatedBy());
		pstmt.setObject(7, newJobHistory.getCreatedDate());
		pstmt.setString(8, newJobHistory.getUpdatedBy());
		pstmt.setObject(9, newJobHistory.getUpdatedDate());
		pstmt.setString(10, oldJobHistory.getEmployeeId());
		pstmt.setObject(11, oldJobHistory.getCreatedDate());

		return pstmt.executeUpdate();

	}

	@Override
	public int insertJobHistory(JobHistory jobHistory) throws Exception {
		String query = "INSERT INTO mymanager.job_history (employee_id,start_date,end_date,job_id,department_id,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, jobHistory.getEmployeeId());
		pstmt.setObject(2, jobHistory.getStartDate());
		pstmt.setObject(3, jobHistory.getEmployeeId());
		pstmt.setString(4, jobHistory.getJobId());
		pstmt.setString(5, jobHistory.getDepartmentId());
		pstmt.setString(6, jobHistory.getCreatedBy());
		pstmt.setObject(7, jobHistory.getCreatedDate());
		pstmt.setString(8, jobHistory.getUpdatedBy());
		pstmt.setObject(9, jobHistory.getUpdatedDate());

		return pstmt.executeUpdate();
	}

	@Override
	public int deleteJobHistory(JobHistory jobHistory) throws Exception {
		String query = "DELETE FROM mymanager.job_history WHERE employee_id=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, jobHistory.getEmployeeId());

		return pstmt.executeUpdate();
	}

	public int savePreviousRow(JobHistory jobHistory) throws Exception {
		String query = "INSERT INTO mymanager.job_history_history (employee_id,start_date,end_date,job_id,department_id,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, jobHistory.getEmployeeId());
		pstmt.setObject(2, jobHistory.getStartDate());
		pstmt.setObject(3, jobHistory.getEmployeeId());
		pstmt.setString(4, jobHistory.getJobId());
		pstmt.setString(5, jobHistory.getDepartmentId());
		pstmt.setString(6, jobHistory.getCreatedBy());
		pstmt.setObject(7, jobHistory.getCreatedDate());
		pstmt.setString(8, jobHistory.getUpdatedBy());
		pstmt.setObject(9, jobHistory.getUpdatedDate());

		return pstmt.executeUpdate();
	}

}
