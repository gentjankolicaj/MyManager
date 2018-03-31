package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.AdditionalAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Additional;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class AdditionalAccessObject implements AdditionalAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	public AdditionalAccessObject() {
		this.queryType = QueryType.NORMAL;
	}

	public AdditionalAccessObject(QueryType queryType) {
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;

	}

	@Override
	public List<Additional> readAllAdditionals() {
		List<Additional> additionalList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM employee_additional";
		else
			query = "SELECT * FROM employee_additional_history";

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Additional temp = new Additional(results.getString("employee_id"), results.getFloat("salary_amount"),
						results.getDate("hire_date").toLocalDate(), results.getString("created_by"),
						results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				additionalList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(additionalList, PrintType.QUERY_RESULTS);

		return additionalList;

	}

	@Override
	public List<Additional> readAdditional(Additional additional) {
		List<Additional> additionalList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM employee_additional WHERE employee_id=" + additional.getEmployeeId();
		else
			query = "SELECT * FROM employee_additional_history WHERE employee_id=" + additional.getEmployeeId();

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Additional temp = new Additional(results.getString("employee_id"), results.getFloat("salary_amount"),
						results.getDate("hire_date").toLocalDate(), results.getString("created_by"),
						results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				additionalList.add(temp);
			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(additionalList, PrintType.QUERY_RESULTS);

		return additionalList;
	}

	@Override
	public int updateAdditional(Additional additional) {
		String query = "UPDATE employee_additional SET" + "salary_amount=?,hire_date=?,created_by=?,"
				+ "created_date=?," + "updated_by=?," + "updated_date=? WHERE employee_id=?";

		setQueryType(QueryType.NORMAL);
		List<Additional> temp = readAdditional(additional);
		savePreviousRow(temp);

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setFloat(1, additional.getSalaryAmount());
			pstmt.setObject(2, additional.getHireDate());
			pstmt.setString(3, additional.getCreatedBy());
			pstmt.setObject(4, additional.getCreatedDate());
			pstmt.setString(5, additional.getUpdatedBy());
			pstmt.setObject(6, additional.getUpdatedDate());
			pstmt.setString(7, additional.getEmployeeId());

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
	public int insertAdditional(Additional additional) {
		String query = "INSERT INTO employee_additional (employee_id,salary_amount,hire_date,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?)";
		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, additional.getEmployeeId());
			pstmt.setFloat(2, additional.getSalaryAmount());
			pstmt.setObject(3, additional.getHireDate());
			pstmt.setString(4, additional.getCreatedBy());
			pstmt.setObject(5, additional.getCreatedDate());
			pstmt.setString(6, additional.getUpdatedBy());
			pstmt.setObject(7, additional.getUpdatedDate());

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
	public int deleteAdditional(Additional additional) {
		String query = "DELETE FROM employee_additional WHERE employee_id=?";
		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, additional.getEmployeeId());
			pstmt.executeUpdate();

			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

	public int savePreviousRow(List<Additional> additionalList) {
		String query = "INSERT INTO employee_additional_history (employee_id,salary_amount,hire_date,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?)";
		Additional additional = additionalList.get(0);
		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, additional.getEmployeeId());
			pstmt.setFloat(2, additional.getSalaryAmount());
			pstmt.setObject(3, additional.getHireDate());
			pstmt.setString(4, additional.getCreatedBy());
			pstmt.setObject(5, additional.getCreatedDate());
			pstmt.setString(6, additional.getUpdatedBy());
			pstmt.setObject(7, additional.getUpdatedDate());

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
