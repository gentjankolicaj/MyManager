package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.Department;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface DepartmentDao {

  List<Department> findAllDepartments() throws Exception;

  List<Department> findAllDepartments(int limit, int offset) throws Exception;

  List<Department> findDepartments(String departmentName) throws Exception;

  Department findDepartment(String departmentId) throws Exception;

  int updateDepartment(Department oldDepartment, Department newDepartment) throws Exception;

  int saveDepartment(Department department) throws Exception;

  int deleteDepartment(Department department) throws Exception;

}
