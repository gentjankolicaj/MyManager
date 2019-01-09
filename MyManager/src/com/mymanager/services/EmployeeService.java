package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.Employee;

public interface EmployeeService {
	
	public abstract List<Employee> getAllEmployees() throws Exception;

	public abstract List<Employee> getAllEmployees(int limit, int offset) throws Exception;

	public abstract List<Employee> getEmployeesByFirstName(String firstName) throws Exception;

	public abstract List<Employee> getEmployeesByLastName(String lastName) throws Exception;

	public abstract List<Employee> getEmployeesByJobId(int jobId) throws Exception;

	public abstract List<Employee> getEmployeesByDepartmentId(int departmentId) throws Exception;

	public abstract List<Employee> getEmployeesByProjectName(String projectName) throws Exception;

	public abstract Employee getEmployee(String employeeId) throws Exception;

	public abstract int updateEmployee(Employee oldEmployee, Employee newEmployee) throws Exception;

	public abstract int saveEmployee(Employee employee) throws Exception;

	public abstract int deleteEmployee(Employee employee) throws Exception;

}
