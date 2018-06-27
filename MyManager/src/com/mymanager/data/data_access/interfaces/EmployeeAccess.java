package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Employee;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface EmployeeAccess {

	public abstract List<Employee> readAllEmployees() throws Exception;

	public abstract List<Employee> readEmployeesByFirstName(String firstName) throws Exception;

	public abstract List<Employee> readEmployeesByLastName(String lastName) throws Exception;

	public abstract List<Employee> readEmployeesByJobId(int jobId) throws Exception;

	public abstract List<Employee> readEmployeesByDepartmentId(int departmentId) throws Exception;

	public abstract List<Employee> readEmployeesByProjectName(String projectName) throws Exception;

	public abstract Employee readEmployee(String employeeId) throws Exception;

	public abstract int updateEmployee(Employee oldEmployee, Employee newEmployee) throws Exception;

	public abstract int insertEmployee(Employee employee) throws Exception;

	public abstract int deleteEmployee(Employee employee) throws Exception;

}
