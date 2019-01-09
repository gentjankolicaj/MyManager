package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.Department;

public interface DepartmentService {
	
	public abstract List<Department> getAllDepartments() throws Exception;

	public abstract List<Department> getAllDepartments(int limit, int offset) throws Exception;

	public abstract List<Department> getDepartments(String departmentName) throws Exception;

	public abstract Department getDepartment(String departmentId) throws Exception;

	public abstract int updateDepartment(Department oldDepartment, Department newDepartment) throws Exception;

	public abstract int saveDepartment(Department department) throws Exception;

	public abstract int deleteDepartment(Department department) throws Exception;

}
