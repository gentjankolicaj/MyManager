package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Department;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface DepartmentAccess {

	public abstract List<Department> readAllDepartments();

	public abstract List<Department> readDepartments(String departmentName);

	public abstract Department readDepartment(int departmentId);

	public abstract int updateDepartment(Department department);

	public abstract int insertDepartment(Department department);

	public abstract int deleteDepartment(Department department);

}
