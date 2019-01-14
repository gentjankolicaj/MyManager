package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Employee;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface EmployeeAccess {

	public abstract List<Employee> findAllEmployees() throws Exception;

	public abstract List<Employee> findAllEmployees(int limit, int offset) throws Exception;
	
	public abstract List<String>  findAllEmployeeIds() throws Exception;

	public abstract List<Employee> findEmployeesByFirstName(String firstName) throws Exception;

	public abstract List<Employee> findEmployeesByLastName(String lastName) throws Exception;

	public abstract List<Employee> findEmployeesByJobId(int jobId) throws Exception;

	public abstract List<Employee> findEmployeesByDepartmentId(int departmentId) throws Exception;

	public abstract List<Employee> findEmployeesByProjectName(String projectName) throws Exception;

	public abstract Employee findEmployee(String employeeId) throws Exception;

	public abstract int updateEmployee(Employee oldEmployee, Employee newEmployee) throws Exception;

	public abstract int saveEmployee(Employee employee) throws Exception;

	public abstract int deleteEmployee(Employee employee) throws Exception;

}
