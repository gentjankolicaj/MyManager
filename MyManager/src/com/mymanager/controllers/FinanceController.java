package com.mymanager.controllers;

import com.mymanager.data.data_access.interfaces.CurrencyAccess;
import com.mymanager.data.data_access.interfaces.EmployeeAccess;
import com.mymanager.data.data_access.interfaces.FileTypeAccess;
import com.mymanager.data.data_access.interfaces.PaymentAccess;
import com.mymanager.data.data_access.interfaces.ProjectAccess;
import com.mymanager.data.data_access.interfaces.WorkingHourAccess;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class FinanceController extends UserController {

	private CurrencyAccess currencyAccess;
	private EmployeeAccess employeeAccess;
	private FileTypeAccess fileTypeAccess;
	private PaymentAccess paymentAccess;
	private ProjectAccess projectAccess;
	private WorkingHourAccess workingHourAccess;

}
