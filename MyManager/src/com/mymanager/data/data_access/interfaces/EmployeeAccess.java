package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Employee;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface EmployeeAccess {

	public abstract List<Employee> readAllEmployees();

	public abstract List<Employee> readEmployeesByFirstName(String firstName);

	public abstract List<Employee> readEmployeesByLastName(String lastName);

	public abstract List<Employee> readEmployeesByJobId(int jobId);

	public abstract List<Employee> readEmployeesByDepartmentId(int departmentId);

	public abstract List<Employee> readEmployeesByProjectName(String projectName);

	public abstract Employee readEmployee(String employeeId);

	public abstract int updateEmployee(Employee employee);

	public abstract int insertEmployee(Employee employee);

	public abstract int deleteEmployee(Employee employee);

}
