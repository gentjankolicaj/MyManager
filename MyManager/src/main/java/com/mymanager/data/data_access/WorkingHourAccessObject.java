package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mymanager.data.data_access.interfaces.WorkingHourAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.WorkingHour;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtil;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class WorkingHourAccessObject implements WorkingHourAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public WorkingHourAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public WorkingHourAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<WorkingHour> findAllWorkingHour() throws Exception {
		List<WorkingHour> workingHoursList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.working_hours";
		else
			query = "SELECT * FROM mymanager.working_hours_history";

		results = database.selectStatement(query);
		while (results.next()) {
			WorkingHour temp = new WorkingHour(results.getInt("index"), results.getString("employee_id"),
					results.getDate("date").toLocalDate(), results.getFloat("amount"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			workingHoursList.add(temp);

		}
		PrintUtil.print(workingHoursList, PrintType.QUERY_RESULTS);
		return workingHoursList;
	}

	@Override
	public List<WorkingHour> findAllWorkingHour(int limit, int offset) throws Exception {
		List<WorkingHour> workingHoursList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.working_hours LIMIT " + limit + " OFFSET " + offset;
		else
			query = "SELECT * FROM mymanager.working_hours_history LIMIT " + limit + " OFFSET " + offset;

		results = database.selectStatement(query);
		while (results.next()) {
			WorkingHour temp = new WorkingHour(results.getInt("index"), results.getString("employee_id"),
					results.getDate("date").toLocalDate(), results.getFloat("amount"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			workingHoursList.add(temp);

		}
		PrintUtil.print(workingHoursList, PrintType.QUERY_RESULTS);
		return workingHoursList;
	}

	@Override
	public List<WorkingHour> findWorkingHourByEmplyeeId(String employeeId) throws Exception {
		List<WorkingHour> workingHoursList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.working_hours WHERE employee_id LIKE '" + employeeId + "'";
		else
			query = "SELECT * FROM mymanager.working_hours_history WHERE employee_id LIKE '" + employeeId + "'";

		results = database.selectStatement(query);
		while (results.next()) {
			WorkingHour temp = new WorkingHour(results.getInt("index"), results.getString("employee_id"),
					results.getDate("date").toLocalDate(), results.getFloat("amount"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			workingHoursList.add(temp);

		}
		PrintUtil.print(workingHoursList, PrintType.QUERY_RESULTS);
		return workingHoursList;
	}

	@Override
	public List<WorkingHour> findWorkingHourByDate(LocalDate date) throws Exception {
		List<WorkingHour> workingHoursList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.working_hours WHERE date="+date;
		else
			query = "SELECT * FROM mymanager.working_hours_history WHERE date="+date;

		results = database.selectStatement(query);
		while (results.next()) {
			WorkingHour temp = new WorkingHour(results.getInt("index"), results.getString("employee_id"),
					results.getDate("date").toLocalDate(), results.getFloat("amount"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			workingHoursList.add(temp);

		}
		PrintUtil.print(workingHoursList, PrintType.QUERY_RESULTS);
		return workingHoursList;
	}

	@Override
	public List<WorkingHour> findWorkingHourByBetween(float minHours, float maxHours) throws Exception {
		List<WorkingHour> workingHoursList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.working_hours WHERE amount > ? AND amount < ?";
		else
			query = "SELECT * FROM mymanager.working_hours_history WHERE amount > ? AND amount < ?";

		results = database.selectStatement(query, Arrays.asList(new Float(minHours), new Float(maxHours)));
		while (results.next()) {
			WorkingHour temp = new WorkingHour(results.getInt("index"), results.getString("employee_id"),
					results.getDate("date").toLocalDate(), results.getFloat("amount"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			workingHoursList.add(temp);

		}
		PrintUtil.print(workingHoursList, PrintType.QUERY_RESULTS);
		return workingHoursList;
	}

	public WorkingHour findWorkingHourByIndex(int index) throws Exception {
		WorkingHour workingHour = null;
		ResultSet results = null;
		String query = "SELECT * FROM mymanager.working_hours WHERE `index`=" + index;
		results = database.selectStatement(query);
		while (results.next()) {
			workingHour = new WorkingHour(results.getInt("index"), results.getString("employee_id"),
					results.getDate("date").toLocalDate(), results.getFloat("amount"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());

		}
		PrintUtil.print(workingHour, PrintType.QUERY_RESULTS);
		return workingHour;

	}

	@Override
	public int updateWorkingHour(WorkingHour oldWorkingHour, WorkingHour newWorkingHour) throws Exception {
		String query = "UPDATE mymanager.working_hours SET `index`=?,employee_id=?,date=?,amount=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE `index`=?";

		setQueryType(QueryType.NORMAL);
		WorkingHour temp = findWorkingHourByIndex(oldWorkingHour.getIndex());
		savePreviousRow(temp);

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, newWorkingHour.getIndex());
		pstmt.setString(2, newWorkingHour.getEmployeeId());
		pstmt.setObject(3, newWorkingHour.getDate());
		pstmt.setFloat(4, newWorkingHour.getAmount());
		pstmt.setString(5, newWorkingHour.getCreatedBy());
		pstmt.setObject(6, newWorkingHour.getCreatedDate());
		pstmt.setString(7, newWorkingHour.getUpdatedBy());
		pstmt.setObject(8, newWorkingHour.getUpdatedDate());
		pstmt.setInt(9, oldWorkingHour.getIndex());

		return pstmt.executeUpdate();
	}

	@Override
	public int saveWorkingHour(WorkingHour workingHour) throws Exception {
		String query = "INSERT INTO mymanager.working_hours (employee_id,date,amount,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, workingHour.getEmployeeId());
		pstmt.setObject(2, workingHour.getDate());
		pstmt.setFloat(3, workingHour.getAmount());
		pstmt.setString(4, workingHour.getCreatedBy());
		pstmt.setObject(5, workingHour.getCreatedDate());
		pstmt.setString(6, workingHour.getUpdatedBy());
		pstmt.setObject(7, workingHour.getUpdatedDate());

		return pstmt.executeUpdate();
	}

	@Override
	public int deleteWorkingHour(WorkingHour workingHour) throws Exception {
		String query = "DELETE FROM mymanager.working_hours WHERE `index`=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, workingHour.getIndex());

		return pstmt.executeUpdate();
	}

	public int savePreviousRow(WorkingHour workingHour) throws Exception {
		String query = "INSERT INTO mymanager.working_hours_history (`index`,employee_id,date,amount,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, workingHour.getIndex());
		pstmt.setString(2, workingHour.getEmployeeId());
		pstmt.setObject(3, workingHour.getDate());
		pstmt.setFloat(4, workingHour.getAmount());
		pstmt.setString(5, workingHour.getCreatedBy());
		pstmt.setObject(6, workingHour.getCreatedDate());
		pstmt.setString(7, workingHour.getUpdatedBy());
		pstmt.setObject(8, workingHour.getUpdatedDate());

		return pstmt.executeUpdate();
	}

}
