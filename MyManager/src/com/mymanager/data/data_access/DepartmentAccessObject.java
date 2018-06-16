package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.DepartmentAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Department;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class DepartmentAccessObject implements DepartmentAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public DepartmentAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public DepartmentAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<Department> readAllDepartments() throws Exception {
		List<Department> departmentList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.departments";
		else
			query = "SELECT * FROM mymanager.departments_history";

		results = database.selectStatement(query);
		while (results.next()) {
			Department temp = new Department(results.getInt("department_id"), results.getString("department_name"),
					results.getString("manager_id"), results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			departmentList.add(temp);

		}
		PrintUtils.print(departmentList, PrintType.QUERY_RESULTS);
		return departmentList;
	}

	@Override
	public List<Department> readDepartments(String departmentName) throws Exception {
		List<Department> departmentList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.departments WHERE department_name LIKE '" + departmentName + "%'";
		else
			query = "SELECT * FROM mymanager.departments_history WHERE department_name LIKE '" + departmentName + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			Department temp = new Department(results.getInt("department_id"), results.getString("department_name"),
					results.getString("manager_id"), results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			departmentList.add(temp);

		}
		PrintUtils.print(departmentList, PrintType.QUERY_RESULTS);
		return departmentList;
	}

	@Override
	public List<Department> readDepartment(Department department) throws Exception {
		List<Department> departmentList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.departments WHERE department_id=" + department.getDepartmentId();
		else
			query = "SELECT * FROM mymanager.departments_history WHERE department_id=" + department.getDepartmentId();

		results = database.selectStatement(query);
		while (results.next()) {
			Department temp = new Department(results.getInt("department_id"), results.getString("department_name"),
					results.getString("manager_id"), results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			departmentList.add(temp);
		}
		PrintUtils.print(departmentList, PrintType.QUERY_RESULTS);
		return departmentList;
	}

	@Override
	public int updateDepartment(Department department) throws Exception {
		String query = "UPDATE mymanager.departments SET" + "department_name=?,manager_id=?,created_by=?,"
				+ "created_date=?," + "updated_by=?," + "updated_date=? WHERE department_id=?";
		setQueryType(QueryType.NORMAL);
		List<Department> temp = readDepartment(department);
		savePreviousRow(temp);

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, department.getDepartmentName());
		pstmt.setString(2, department.getManagerId());
		pstmt.setString(3, department.getCreatedBy());
		pstmt.setObject(4, department.getCreatedDate());
		pstmt.setString(5, department.getUpdatedBy());
		pstmt.setObject(6, department.getUpdatedDate());
		pstmt.setInt(7, department.getDepartmentId());

		return pstmt.executeUpdate();

	}

	@Override
	public int insertDepartment(Department department) throws Exception {
		String query = "INSERT INTO mymanager.departments (department_id,department_name,manager_id,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, department.getDepartmentId());
		pstmt.setString(2, department.getDepartmentName());
		pstmt.setString(3, department.getManagerId());
		pstmt.setString(4, department.getCreatedBy());
		pstmt.setObject(5, department.getCreatedDate());
		pstmt.setString(6, department.getUpdatedBy());
		pstmt.setObject(7, department.getUpdatedDate());

		return pstmt.executeUpdate();

	}

	@Override
	public int deleteDepartment(Department department) throws Exception {
		String query = "DELETE FROM mymanager.departments WHERE department_id=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, department.getDepartmentId());

		return pstmt.executeUpdate();

	}

	public int savePreviousRow(List<Department> departments) throws Exception {
		String query = "INSERT INTO mymanager.departments_history (department_id,department_name,manager_id,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?)";
		Department department = departments.get(0);

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, department.getDepartmentId());
		pstmt.setString(2, department.getDepartmentName());
		pstmt.setString(3, department.getManagerId());
		pstmt.setString(4, department.getCreatedBy());
		pstmt.setObject(5, department.getCreatedDate());
		pstmt.setString(6, department.getUpdatedBy());
		pstmt.setObject(7, department.getUpdatedDate());

		return pstmt.executeUpdate();

	}

}
