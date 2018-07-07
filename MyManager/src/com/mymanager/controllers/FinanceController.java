package com.mymanager.controllers;

import java.awt.Component;
import java.time.LocalDate;
import java.util.List;

import com.mymanager.data.data_access.CurrencyAccessObject;
import com.mymanager.data.data_access.EmployeeAccessObject;
import com.mymanager.data.data_access.FileTypeAccessObject;
import com.mymanager.data.data_access.PaymentAccessObject;
import com.mymanager.data.data_access.ProjectAccessObject;
import com.mymanager.data.data_access.WorkingHourAccessObject;
import com.mymanager.data.data_access.interfaces.CurrencyAccess;
import com.mymanager.data.data_access.interfaces.EmployeeAccess;
import com.mymanager.data.data_access.interfaces.FileTypeAccess;
import com.mymanager.data.data_access.interfaces.PaymentAccess;
import com.mymanager.data.data_access.interfaces.ProjectAccess;
import com.mymanager.data.data_access.interfaces.WorkingHourAccess;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.AdressType;
import com.mymanager.data.models.ContactType;
import com.mymanager.data.models.Currency;
import com.mymanager.data.models.Employee;
import com.mymanager.data.models.FileType;
import com.mymanager.data.models.Payment;
import com.mymanager.data.models.PaymentType;
import com.mymanager.data.models.Project;
import com.mymanager.data.models.User;
import com.mymanager.data.models.WorkingHour;
import com.mymanager.utils.MessageType;
import com.mymanager.utils.UtilWindow;

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
	private QueryType queryType = QueryType.NORMAL;
	private AdressType adressType = AdressType.USER_ADRESS;
	private ContactType contactType = ContactType.USER_CONTACT;

	public FinanceController(User user, Component component) {
		super(user, component);
		currencyAccess = new CurrencyAccessObject();
		employeeAccess = new EmployeeAccessObject(queryType);
		fileTypeAccess = new FileTypeAccessObject();
		paymentAccess = new PaymentAccessObject(queryType);
		projectAccess = new ProjectAccessObject();
		workingHourAccess = new WorkingHourAccessObject(queryType);
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	public QueryType getQueryType() {
		return queryType;
	}

	public void setAdressType(AdressType adressType) {
		this.adressType = adressType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public AdressType getAdressType() {
		return adressType;
	}

	public ContactType getContactType() {
		return contactType;
	}

	// =======================================================================
	// Currency
	// =======================================================================

	public List<Currency> getAllCurrencies() {
		try {
			return currencyAccess.readAllCurrencies();
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<Currency> getCurrenciesByName(String currencyNames) {
		try {
			return currencyAccess.readCurrencies(currencyNames);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public int editCurrency(Currency oldCurrency, Currency newCurrency) {
		try {
			return currencyAccess.updateCurrency(oldCurrency, newCurrency);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	public int saveCurrency(Currency currency) {
		try {
			return currencyAccess.insertCurrency(currency);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	public int deleteCurrency(Currency currency) {
		try {
			return currencyAccess.deleteCurrency(currency);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	// =======================================================================
	// Employee
	// =======================================================================

	public List<Employee> getAllEmployees(QueryType queryType) {
		try {
			setQueryType(queryType);
			return employeeAccess.readAllEmployees();
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<Employee> getEmployeesByFirstName(QueryType queryType, String firstName) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByFirstName(firstName);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<Employee> getEmployeesByLastName(QueryType queryType, String lastName) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByLastName(lastName);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<Employee> getEmployeesByJobId(QueryType queryType, int jobId) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByJobId(jobId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<Employee> getEmployeesByDepartmentId(QueryType queryType, int departmentId) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByDepartmentId(departmentId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<Employee> getEmployeesByProjectName(QueryType queryType, String projectName) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByProjectName(projectName);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public Employee getEmployee(String employeeId) {
		try {
			return employeeAccess.readEmployee(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public int editEmployee(Employee oldEmployee, Employee newEmployee) {
		try {
			return employeeAccess.updateEmployee(oldEmployee, newEmployee);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	public int saveEmployee(Employee employee) {
		try {
			return employeeAccess.insertEmployee(employee);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	public int deleteEmployee(Employee employee) {
		try {
			return employeeAccess.deleteEmployee(employee);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	// =======================================================================
	// File Types
	// =======================================================================

	public List<FileType> getAllFileTypes(QueryType queryType) {
		try {
			return fileTypeAccess.readAllFileTypes();
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public FileType getFileType(String fileType) {
		try {
			return fileTypeAccess.readFileType(fileType);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public int editFileType(FileType oldFileType, FileType newFileType) {
		try {
			return fileTypeAccess.updateFileType(oldFileType, newFileType);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	public int saveFileType(FileType fileType) {
		try {
			return fileTypeAccess.insertFileType(fileType);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	public int deleteFileType(FileType fileType) {
		try {
			return fileTypeAccess.deleteFileType(fileType);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	// =======================================================================
	// Payment
	// =======================================================================

	public List<Payment> getAllPayments(QueryType queryType) {
		try {
			setQueryType(queryType);
			return paymentAccess.readAllPayments();
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<Payment> getPaymentByType(QueryType queryType, PaymentType paymentType) {
		try {
			setQueryType(queryType);
			return paymentAccess.readAllPaymentsByPaymentType(paymentType);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<Payment> getPaymentByDescription(QueryType queryType, String description) {
		try {
			setQueryType(queryType);
			return paymentAccess.readAllPaymentsByDescription(description);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<Payment> getPaymentByEmployeeId(QueryType queryType, String employeeId) {
		try {
			setQueryType(queryType);
			return paymentAccess.readAllPaymentsByEmployeeId(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public Payment getPayment(int paymentId) {
		try {
			return paymentAccess.readPayment(paymentId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public int editPayment(Payment oldPayment, Payment newPayment) {
		try {
			return paymentAccess.updatePayment(oldPayment, newPayment);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	public int savePayment(Payment payment) {
		try {
			return paymentAccess.insertPayment(payment);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	public int deletePayment(Payment payment) {
		try {
			return paymentAccess.deletePayment(payment);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	// =======================================================================
	// Project
	// =======================================================================

	public List<Project> getAllProjects() {
		try {

			return projectAccess.readAllProjects();
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<Project> getProjectsByCustomer(String customer) {
		try {
			return projectAccess.readAllProjectsByCustomer(customer);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<Project> getProjectsByDescription(String description) {
		try {
			return projectAccess.readAllProjectsByDescription(description);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public Project getProject(String projectName) {
		try {
			return projectAccess.readProjectByName(projectName);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public int editProject(Project oldProject, Project newProject) {
		try {
			return projectAccess.updateProject(oldProject, newProject);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	public int saveProject(Project project) {
		try {
			return projectAccess.insertProject(project);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	public int deleteProject(Project project) {
		try {
			return projectAccess.deleteProject(project);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	// =======================================================================
	// WorkingHour
	// =======================================================================

	public List<WorkingHour> getAllWorkingHour(QueryType queryType) {
		try {
			setQueryType(queryType);
			return workingHourAccess.readAllWorkingHour();
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<WorkingHour> getWorkingHoursByEmployeeId(QueryType queryType, String employeeId) {
		try {
			setQueryType(queryType);
			return workingHourAccess.readWorkingHourByEmplyeeId(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<WorkingHour> getWorkingHoursByDate(QueryType queryType, LocalDate date) {
		try {
			setQueryType(queryType);
			return workingHourAccess.readWorkingHourByDate(date);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public List<WorkingHour> getWorkingHoursBetween(QueryType queryType, float minHours, float maxHours) {
		try {
			setQueryType(queryType);
			return workingHourAccess.readWorkingHourByBetween(minHours, maxHours);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public WorkingHour getWorkingHour(int index) {
		try {
			return workingHourAccess.readWorkingHourByIndex(index);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return null;
		}

	}

	public int editWorkingHour(WorkingHour oldWorkingHour, WorkingHour newWorkingHour) {
		try {
			return workingHourAccess.updateWorkingHour(oldWorkingHour, newWorkingHour);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	public int saveWorkingHour(WorkingHour workingHour) {
		try {
			return workingHourAccess.insertWorkingHour(workingHour);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

	public int deleteWorkingHour(WorkingHour workingHour) {
		try {
			return workingHourAccess.deleteWorkingHour(workingHour);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "finance");
			return 0;
		}

	}

}
