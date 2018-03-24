package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.EmployeeAccess;
import com.mymanager.data.models.Employee;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class EmployeeAccessObject implements EmployeeAccess {

	@Override
	public List<Employee> readAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> readEmployeesByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> readEmployeesByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> readEmployeesByJobId(int jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> readEmployeesByDepartmentId(int departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> readEmployeesByProjectName(String projectName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee readEmployee(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

}
