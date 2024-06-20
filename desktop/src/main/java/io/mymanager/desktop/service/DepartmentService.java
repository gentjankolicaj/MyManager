package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.Department;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface DepartmentService {

  List<Department> getAllDepartments() throws Exception;

  List<Department> getAllDepartments(int limit, int offset) throws Exception;

  List<Department> getDepartments(String departmentName) throws Exception;

  Department getDepartment(String departmentId) throws Exception;

  int updateDepartment(Department oldDepartment, Department newDepartment) throws Exception;

  int saveDepartment(Department department) throws Exception;

  int deleteDepartment(Department department) throws Exception;

}
