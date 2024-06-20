package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.Employee;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface EmployeeDao {

  List<Employee> findAllEmployees() throws Exception;

  List<Employee> findAllEmployees(int limit, int offset) throws Exception;

  List<String> findAllEmployeeIds() throws Exception;

  List<Employee> findEmployeesByFirstName(String firstName) throws Exception;

  List<Employee> findEmployeesByLastName(String lastName) throws Exception;

  List<Employee> findEmployeesByJobId(int jobId) throws Exception;

  List<Employee> findEmployeesByDepartmentId(int departmentId) throws Exception;

  List<Employee> findEmployeesByProjectName(String projectName) throws Exception;

  Employee findEmployee(String employeeId) throws Exception;

  int updateEmployee(Employee oldEmployee, Employee newEmployee) throws Exception;

  int saveEmployee(Employee employee) throws Exception;

  int deleteEmployee(Employee employee) throws Exception;

}
