package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.EmployeeAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Employee;

/**
 * 
 * @author gentjan koliçaj
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
	public List<Employee> readAllEmployees() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> readEmployeesByFirstName(String firstName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> readEmployeesByLastName(String lastName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> readEmployeesByJobId(int jobId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> readEmployeesByDepartmentId(int departmentId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> readEmployeesByProjectName(String projectName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee readEmployee(String employeeId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
