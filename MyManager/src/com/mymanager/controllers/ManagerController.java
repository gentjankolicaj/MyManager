package com.mymanager.controllers;

import com.mymanager.data.data_access.interfaces.AdressAccess;
import com.mymanager.data.data_access.interfaces.ContactAccess;
import com.mymanager.data.data_access.interfaces.DepartmentAccess;
import com.mymanager.data.data_access.interfaces.EmployeeAccess;
import com.mymanager.data.data_access.interfaces.JobAccess;
import com.mymanager.data.data_access.interfaces.JobHistoryAccess;
import com.mymanager.data.data_access.interfaces.ProjectAccess;
import com.mymanager.data.data_access.interfaces.WorkingHourAccess;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class ManagerController extends UserController {

	private AdressAccess adressAccess;
	private ContactAccess contactAccess;
	private DepartmentAccess departmentAccess;
	private EmployeeAccess employeeAccess;
	private JobAccess jobAccess;
	private JobHistoryAccess jobHistoryAccess;
	private ProjectAccess projectAccess;
	private WorkingHourAccess workingHourAccess;

}
