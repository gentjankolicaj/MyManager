package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.EmployeeAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Employee;
import com.mymanager.data.models.Gender;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtil;

/**
 * 
 * @author gentjan koli�aj
 *
 */
public class EmployeeAccessObject implements EmployeeAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public EmployeeAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;

	}

	/**
	 * @param queryType
	 */
	public EmployeeAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<Employee> findAllEmployees() throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		String query = null;
		ResultSet results = null;

		if (queryType.equals(QueryType.NORMAL))
			query = "Select * from mymanager.employees";
		else
			query = "Select * from mymanager.employees_history";

		results = database.selectStatement(query);
		while (results.next()) {
			Employee employee = new Employee(results.getString("employee_id"), results.getString("first_name"),
					results.getString("last_name"), results.getString("middle_name"),
					results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
					Gender.valueOf(results.getString("gender")), results.getInt("job_id"),
					results.getInt("department_id"), results.getString("project_name"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			employeeList.add(employee);
		}
		PrintUtil.print(employeeList, PrintType.QUERY_RESULTS);
		return employeeList;
	}

	@Override
	public List<Employee> findAllEmployees(int limit, int offset) throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		String query = null;
		ResultSet results = null;

		if (queryType.equals(QueryType.NORMAL))
			query = "Select * from mymanager.employees LIMIT " + limit + " OFFSET " + offset;
		else
			query = "Select * from mymanager.employees_history LIMIT " + limit + " OFFSET " + offset;

		results = database.selectStatement(query);
		while (results.next()) {
			Employee employee = new Employee(results.getString("employee_id"), results.getString("first_name"),
					results.getString("last_name"), results.getString("middle_name"),
					results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
					Gender.valueOf(results.getString("gender")), results.getInt("job_id"),
					results.getInt("department_id"), results.getString("project_name"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			employeeList.add(employee);
		}
		PrintUtil.print(employeeList, PrintType.QUERY_RESULTS);
		return employeeList;
	}

	@Override
	public List<Employee> findEmployeesByFirstName(String firstName) throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		String query = null;
		ResultSet results = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "Select * from mymanager.employees WHERE first_name LIKE '" + firstName + "%'";
		else
			query = "Select * from mymanager.employees_history WHERE first_name LIKE '" + firstName + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			Employee employee = new Employee(results.getString("employee_id"), results.getString("first_name"),
					results.getString("last_name"), results.getString("middle_name"),
					results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
					Gender.valueOf(results.getString("gender")), results.getInt("job_id"),
					results.getInt("department_id"), results.getString("project_name"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			employeeList.add(employee);
		}
		PrintUtil.print(employeeList, PrintType.QUERY_RESULTS);
		return employeeList;
	}

	@Override
	public List<Employee> findEmployeesByLastName(String lastName) throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		String query = null;
		ResultSet results = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "Select * from mymanager.employees WHERE last_name LIKE '" + lastName + "%'";
		else
			query = "Select * from mymanager.employees_history WHERE last_name LIKE '" + lastName + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			Employee employee = new Employee(results.getString("employee_id"), results.getString("first_name"),
					results.getString("last_name"), results.getString("middle_name"),
					results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
					Gender.valueOf(results.getString("gender")), results.getInt("job_id"),
					results.getInt("department_id"), results.getString("project_name"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			employeeList.add(employee);
		}
		PrintUtil.print(employeeList, PrintType.QUERY_RESULTS);
		return employeeList;
	}

	@Override
	public List<Employee> findEmployeesByJobId(int jobId) throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		String query = null;
		ResultSet results = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "Select * from mymanager.employees WHERE job_id LIKE '" + jobId + "%'";
		else
			query = "Select * from mymanager.employees_history WHERE job_id LIKE '" + jobId + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			Employee employee = new Employee(results.getString("employee_id"), results.getString("first_name"),
					results.getString("last_name"), results.getString("middle_name"),
					results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
					Gender.valueOf(results.getString("gender")), results.getInt("job_id"),
					results.getInt("department_id"), results.getString("project_name"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			employeeList.add(employee);
		}
		PrintUtil.print(employeeList, PrintType.QUERY_RESULTS);
		return employeeList;
	}

	@Override
	public List<Employee> findEmployeesByDepartmentId(int departmentId) throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		String query = null;
		ResultSet results = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "Select * from mymanager.employees WHERE department_id LIKE '" + departmentId + "%'";
		else
			query = "Select * from mymanager.employees_history WHERE department_id LIKE '" + departmentId + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			Employee employee = new Employee(results.getString("employee_id"), results.getString("first_name"),
					results.getString("last_name"), results.getString("middle_name"),
					results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
					Gender.valueOf(results.getString("gender")), results.getInt("job_id"),
					results.getInt("department_id"), results.getString("project_name"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			employeeList.add(employee);
		}
		PrintUtil.print(employeeList, PrintType.QUERY_RESULTS);
		return employeeList;
	}

	@Override
	public List<Employee> findEmployeesByProjectName(String projectName) throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		String query = null;
		ResultSet results = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "Select * from mymanager.employees WHERE project_name LIKE '" + projectName + "%'";
		else
			query = "Select * from mymanager.employees_history WHERE project_name LIKE '" + projectName + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			Employee employee = new Employee(results.getString("employee_id"), results.getString("first_name"),
					results.getString("last_name"), results.getString("middle_name"),
					results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
					Gender.valueOf(results.getString("gender")), results.getInt("job_id"),
					results.getInt("department_id"), results.getString("project_name"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			employeeList.add(employee);
		}
		PrintUtil.print(employeeList, PrintType.QUERY_RESULTS);
		return employeeList;
	}

	@Override
	public Employee findEmployee(String employeeId) throws Exception {
		Employee employee = null;
		String query = "Select * from mymanager.employees WHERE employee_id LIKE '" + employeeId + "'";
		ResultSet results = null;

		results = database.selectStatement(query);
		while (results.next()) {
			employee = new Employee(results.getString("employee_id"), results.getString("first_name"),
					results.getString("last_name"), results.getString("middle_name"),
					results.getDate("birthday").toLocalDate(), results.getString("birthplace"),
					Gender.valueOf(results.getString("gender")), results.getInt("job_id"),
					results.getInt("department_id"), results.getString("project_name"), results.getString("created_by"),
					results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
		}
		PrintUtil.print(employee, PrintType.QUERY_RESULTS);
		return employee;
	}

	@Override
	public int updateEmployee(Employee oldEmployee, Employee newEmployee) throws Exception {
		String query = "UPDATE mymanager.employees SET first_name=?," + "last_name=?," + "middle_name=?,"
				+ "birthday=?," + "birthplace=?," + "gender=?," + "job_id=?,department_id=?,project_name=?,"
				+ "created_by=?," + "created_date=?," + "updated_by=?," + "updated_date=? WHERE employee_id=?";

		setQueryType(QueryType.NORMAL);
		Employee temp = findEmployee(oldEmployee.getEmployeeId());
		savePreviousRow(temp);

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, newEmployee.getFirstName());
		pstmt.setString(2, newEmployee.getLastName());
		pstmt.setString(3, newEmployee.getMiddleName());
		pstmt.setObject(4, newEmployee.getBirthday());
		pstmt.setString(5, newEmployee.getBirthplace());
		pstmt.setString(6, newEmployee.getGender().name());
		pstmt.setInt(7, newEmployee.getJobId());
		pstmt.setInt(8, newEmployee.getDepartmentId());
		pstmt.setString(9, newEmployee.getProjectName());
		pstmt.setString(10, newEmployee.getCreatedBy());
		pstmt.setObject(11, newEmployee.getCreatedDate());
		pstmt.setString(12, newEmployee.getUpdatedBy());
		pstmt.setObject(13, newEmployee.getUpdatedDate());
		pstmt.setString(14, oldEmployee.getEmployeeId());

		return pstmt.executeUpdate();
	}

	@Override
	public int saveEmployee(Employee employee) throws Exception {
		String query = "INSERT INTO mymanager.employees (employee_id,first_name,last_name,middle_name,"
				+ "birthday,birthplace,gender,job_id,department_id,project_name,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, employee.getEmployeeId());
		pstmt.setString(2, employee.getFirstName());
		pstmt.setString(3, employee.getLastName());
		pstmt.setString(4, employee.getMiddleName());
		pstmt.setObject(5, employee.getBirthday());
		pstmt.setString(6, employee.getBirthplace());
		pstmt.setString(7, employee.getGender().name());
		pstmt.setInt(8, employee.getJobId());
		pstmt.setInt(9, employee.getDepartmentId());
		pstmt.setString(10, employee.getProjectName());
		pstmt.setString(11, employee.getCreatedBy());
		pstmt.setObject(12, employee.getCreatedDate());
		pstmt.setString(13, employee.getUpdatedBy());
		pstmt.setObject(14, employee.getUpdatedDate());

		return pstmt.executeUpdate();
	}

	@Override
	public int deleteEmployee(Employee employee) throws Exception {
		String query = "DELETE FROM mymanager.employees WHERE employee_id=?";
		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, employee.getEmployeeId());
		pstmt.executeUpdate();

		return pstmt.executeUpdate();
	}

	public int savePreviousRow(Employee employee) throws Exception {
		String query = "INSERT INTO mymanager.employees_history (employee_id,first_name,last_name,middle_name,"
				+ "birthday,birthplace,gender,job_id,department_id,project_name,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, employee.getEmployeeId());
		pstmt.setString(2, employee.getFirstName());
		pstmt.setString(3, employee.getLastName());
		pstmt.setString(4, employee.getMiddleName());
		pstmt.setObject(5, employee.getBirthday());
		pstmt.setString(6, employee.getBirthplace());
		pstmt.setString(7, employee.getGender().name());
		pstmt.setInt(8, employee.getJobId());
		pstmt.setInt(9, employee.getDepartmentId());
		pstmt.setString(10, employee.getProjectName());
		pstmt.setString(11, employee.getCreatedBy());
		pstmt.setObject(12, employee.getCreatedDate());
		pstmt.setString(13, employee.getUpdatedBy());
		pstmt.setObject(14, employee.getUpdatedDate());

		return pstmt.executeUpdate();
	}

	@Override
	public List<String> findAllEmployeeIds() throws Exception {
		List<String> employeeIdList = new ArrayList<>();
		String query = "Select * from mymanager.employees";

		ResultSet results = database.selectStatement(query);
		while (results.next()) {
			employeeIdList.add(results.getString("employee_id"));
			
		}
		
		PrintUtil.print(employeeIdList, PrintType.QUERY_RESULTS);
		return employeeIdList;
	}

}
