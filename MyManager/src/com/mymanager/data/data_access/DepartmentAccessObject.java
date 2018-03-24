package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.DepartmentAccess;
import com.mymanager.data.models.Department;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class DepartmentAccessObject implements DepartmentAccess {

	@Override
	public List<Department> readAllDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> readDepartments(String departmentName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department readDepartment(int departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertDepartment(Department department) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		return 0;
	}

}
