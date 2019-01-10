package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Department;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface DepartmentAccess {

	public abstract List<Department> findAllDepartments() throws Exception;

	public abstract List<Department> findAllDepartments(int limit, int offset) throws Exception;

	public abstract List<Department> findDepartments(String departmentName) throws Exception;

	public abstract Department findDepartment(String departmentId) throws Exception;

	public abstract int updateDepartment(Department oldDepartment, Department newDepartment) throws Exception;

	public abstract int saveDepartment(Department department) throws Exception;

	public abstract int deleteDepartment(Department department) throws Exception;

}
