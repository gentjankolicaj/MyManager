package com.mymanager.controllers;

import com.mymanager.data.data_access.interfaces.AdressAccess;
import com.mymanager.data.data_access.interfaces.ContactAccess;
import com.mymanager.data.data_access.interfaces.DepartmentAccess;
import com.mymanager.data.data_access.interfaces.DocumentAccess;
import com.mymanager.data.data_access.interfaces.EmployeeAccess;
import com.mymanager.data.data_access.interfaces.FileTypeAccess;
import com.mymanager.data.data_access.interfaces.JobAccess;
import com.mymanager.data.data_access.interfaces.JobHistoryAccess;
import com.mymanager.data.data_access.interfaces.WorkingHourAccess;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class HumanResourceController extends UserController {

	private AdressAccess adressAccess;
	private ContactAccess contactAccess;
	private DepartmentAccess departmentAccess;
	private DocumentAccess documentAccess;
	private EmployeeAccess employeeAccess;
	private FileTypeAccess fileTypeAccess;
	private JobAccess jobAccess;
	private JobHistoryAccess jobHistoryAccess;
	private WorkingHourAccess workingHourAccess;

}
