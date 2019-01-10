package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.DepartmentAccessObject;
import com.mymanager.data.data_access.interfaces.DepartmentAccess;
import com.mymanager.data.models.Department;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentAccess departmentAccess;
	
	public DepartmentServiceImpl() {
		super();
		this.departmentAccess=new DepartmentAccessObject();
	}

	@Override
	public List<Department> getAllDepartments() throws Exception {
		return departmentAccess.findAllDepartments();
	}

	@Override
	public List<Department> getAllDepartments(int limit, int offset) throws Exception {
		return departmentAccess.findAllDepartments(limit,offset);
	}

	@Override
	public List<Department> getDepartments(String departmentName) throws Exception {
		return departmentAccess.findDepartments(departmentName);
	}

	@Override
	public Department getDepartment(String departmentId) throws Exception {
		return departmentAccess.findDepartment(departmentId);
	}

	@Override
	public int updateDepartment(Department oldDepartment, Department newDepartment) throws Exception {
		return departmentAccess.updateDepartment(oldDepartment, newDepartment);
	}

	@Override
	public int saveDepartment(Department department) throws Exception {
		return departmentAccess.saveDepartment(department);
	}

	@Override
	public int deleteDepartment(Department department) throws Exception {
	return departmentAccess.deleteDepartment(department);
	}

}
