package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.DepartmentAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Department;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class DepartmentAccessObject implements DepartmentAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

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
