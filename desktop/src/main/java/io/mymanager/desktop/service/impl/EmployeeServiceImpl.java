package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.EmployeeDao;
import io.mymanager.desktop.data.dao.impl.EmployeeDaoImpl;
import io.mymanager.desktop.data.models.Employee;
import io.mymanager.desktop.service.EmployeeService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class EmployeeServiceImpl implements EmployeeService {


  private final EmployeeDao employeeDao;

  public EmployeeServiceImpl() {
    super();
    this.employeeDao = new EmployeeDaoImpl();
  }

  @Override
  public List<Employee> getAllEmployees() throws Exception {
    return employeeDao.findAllEmployees();
  }

  @Override
  public List<Employee> getAllEmployees(int limit, int offset) throws Exception {
    return employeeDao.findAllEmployees(limit, offset);
  }

  @Override
  public List<Employee> getEmployeesByFirstName(String firstName) throws Exception {
    return employeeDao.findEmployeesByFirstName(firstName);
  }

  @Override
  public List<Employee> getEmployeesByLastName(String lastName) throws Exception {
    return employeeDao.findEmployeesByLastName(lastName);
  }

  @Override
  public List<Employee> getEmployeesByJobId(int jobId) throws Exception {
    return employeeDao.findEmployeesByJobId(jobId);
  }

  @Override
  public List<Employee> getEmployeesByDepartmentId(int departmentId) throws Exception {
    return employeeDao.findEmployeesByDepartmentId(departmentId);
  }

  @Override
  public List<Employee> getEmployeesByProjectName(String projectName) throws Exception {
    return employeeDao.findEmployeesByProjectName(projectName);
  }

  @Override
  public Employee getEmployee(String employeeId) throws Exception {
    return employeeDao.findEmployee(employeeId);
  }

  @Override
  public int updateEmployee(Employee oldEmployee, Employee newEmployee) throws Exception {
    return employeeDao.updateEmployee(oldEmployee, newEmployee);
  }

  @Override
  public int saveEmployee(Employee employee) throws Exception {
    return employeeDao.saveEmployee(employee);
  }

  @Override
  public int deleteEmployee(Employee employee) throws Exception {
    return employeeDao.deleteEmployee(employee);
  }

  @Override
  public List<String> getAllEmployeeIds() throws Exception {
    return employeeDao.findAllEmployeeIds();
  }

}
