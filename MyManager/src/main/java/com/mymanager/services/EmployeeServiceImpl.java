package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.EmployeeAccessObject;
import com.mymanager.data.data_access.interfaces.EmployeeAccess;
import com.mymanager.data.models.Employee;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeAccess employeeAccess;
	
	public EmployeeServiceImpl() {
		super();
		this.employeeAccess=new EmployeeAccessObject();
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		return employeeAccess.findAllEmployees();
	}

	@Override
	public List<Employee> getAllEmployees(int limit, int offset) throws Exception {
		return employeeAccess.findAllEmployees(limit,offset);
	}

	@Override
	public List<Employee> getEmployeesByFirstName(String firstName) throws Exception {
		return employeeAccess.findEmployeesByFirstName(firstName);
	}

	@Override
	public List<Employee> getEmployeesByLastName(String lastName) throws Exception {
	 return employeeAccess.findEmployeesByLastName(lastName);
	}

	@Override
	public List<Employee> getEmployeesByJobId(int jobId) throws Exception {
		return employeeAccess.findEmployeesByJobId(jobId);
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(int departmentId) throws Exception {
		return employeeAccess.findEmployeesByDepartmentId(departmentId);
	}

	@Override
	public List<Employee> getEmployeesByProjectName(String projectName) throws Exception {
		return employeeAccess.findEmployeesByProjectName(projectName);
	}

	@Override
	public Employee getEmployee(String employeeId) throws Exception {
		return employeeAccess.findEmployee(employeeId);
	}

	@Override
	public int updateEmployee(Employee oldEmployee, Employee newEmployee) throws Exception {
		return employeeAccess.updateEmployee(oldEmployee, newEmployee);
	}

	@Override
	public int saveEmployee(Employee employee) throws Exception {
		return employeeAccess.saveEmployee(employee);
	}

	@Override
	public int deleteEmployee(Employee employee) throws Exception {
		return employeeAccess.deleteEmployee(employee);
	}

}
