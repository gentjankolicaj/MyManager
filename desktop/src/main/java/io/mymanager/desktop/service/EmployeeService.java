package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.Employee;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface EmployeeService {

  List<Employee> getAllEmployees() throws Exception;

  List<Employee> getAllEmployees(int limit, int offset) throws Exception;

  List<String> getAllEmployeeIds() throws Exception;

  List<Employee> getEmployeesByFirstName(String firstName) throws Exception;

  List<Employee> getEmployeesByLastName(String lastName) throws Exception;

  List<Employee> getEmployeesByJobId(int jobId) throws Exception;

  List<Employee> getEmployeesByDepartmentId(int departmentId) throws Exception;

  List<Employee> getEmployeesByProjectName(String projectName) throws Exception;

  Employee getEmployee(String employeeId) throws Exception;

  int updateEmployee(Employee oldEmployee, Employee newEmployee) throws Exception;

  int saveEmployee(Employee employee) throws Exception;

  int deleteEmployee(Employee employee) throws Exception;

}
