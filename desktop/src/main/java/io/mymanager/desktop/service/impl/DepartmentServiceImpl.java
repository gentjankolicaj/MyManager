package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.DepartmentDao;
import io.mymanager.desktop.data.dao.impl.DepartmentDaoImpl;
import io.mymanager.desktop.data.models.Department;
import io.mymanager.desktop.service.DepartmentService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentDao departmentDao;

  public DepartmentServiceImpl() {
    super();
    this.departmentDao = new DepartmentDaoImpl();
  }

  @Override
  public List<Department> getAllDepartments() throws Exception {
    return departmentDao.findAllDepartments();
  }

  @Override
  public List<Department> getAllDepartments(int limit, int offset) throws Exception {
    return departmentDao.findAllDepartments(limit, offset);
  }

  @Override
  public List<Department> getDepartments(String departmentName) throws Exception {
    return departmentDao.findDepartments(departmentName);
  }

  @Override
  public Department getDepartment(String departmentId) throws Exception {
    return departmentDao.findDepartment(departmentId);
  }

  @Override
  public int updateDepartment(Department oldDepartment, Department newDepartment) throws Exception {
    return departmentDao.updateDepartment(oldDepartment, newDepartment);
  }

  @Override
  public int saveDepartment(Department department) throws Exception {
    return departmentDao.saveDepartment(department);
  }

  @Override
  public int deleteDepartment(Department department) throws Exception {
    return departmentDao.deleteDepartment(department);
  }

}
