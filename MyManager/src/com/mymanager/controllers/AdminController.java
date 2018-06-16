package com.mymanager.controllers;

import com.mymanager.data.data_access.interfaces.AdditionalAccess;
import com.mymanager.data.data_access.interfaces.AdressAccess;
import com.mymanager.data.data_access.interfaces.AtemptAccess;
import com.mymanager.data.data_access.interfaces.ContactAccess;
import com.mymanager.data.data_access.interfaces.CountryAccess;
import com.mymanager.data.data_access.interfaces.CurrencyAccess;
import com.mymanager.data.data_access.interfaces.DepartmentAccess;
import com.mymanager.data.data_access.interfaces.DocumentAccess;
import com.mymanager.data.data_access.interfaces.EmployeeAccess;
import com.mymanager.data.data_access.interfaces.FileTypeAccess;
import com.mymanager.data.data_access.interfaces.JobAccess;
import com.mymanager.data.data_access.interfaces.JobHistoryAccess;
import com.mymanager.data.data_access.interfaces.PaymentAccess;
import com.mymanager.data.data_access.interfaces.ProjectAccess;
import com.mymanager.data.data_access.interfaces.UserAccess;
import com.mymanager.data.data_access.interfaces.WorkingHourAccess;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class AdminController extends UserController {

	private AdditionalAccess additionalAccess;
	private AdressAccess adressAccess;
	private AtemptAccess atemptAccess;
	private ContactAccess contactAccess;
	private CountryAccess countryAccess;
	private CurrencyAccess currencyAccess;
	private DepartmentAccess departmentAccess;
	private DocumentAccess documentAccess;
	private EmployeeAccess employeeAccess;
	private FileTypeAccess fileTypeAccess;
	private JobAccess jobAccess;
	private JobHistoryAccess jobHistoryAccess;
	private PaymentAccess paymentAccess;
	private ProjectAccess projectAccess;
	private UserAccess userAccess;
	private WorkingHourAccess workingHourAccess;

}
