package com.mymanager.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JDialog;

import com.mymanager.data.data_access.AdditionalAccessObject;
import com.mymanager.data.data_access.AdressAccessObject;
import com.mymanager.data.data_access.AttemptAccessObject;
import com.mymanager.data.data_access.ContactAccessObject;
import com.mymanager.data.data_access.CountryAccessObject;
import com.mymanager.data.data_access.CurrencyAccessObject;
import com.mymanager.data.data_access.DepartmentAccessObject;
import com.mymanager.data.data_access.DocumentAccessObject;
import com.mymanager.data.data_access.EmployeeAccessObject;
import com.mymanager.data.data_access.FileTypeAccessObject;
import com.mymanager.data.data_access.JobAccessObject;
import com.mymanager.data.data_access.JobHistoryAccessObject;
import com.mymanager.data.data_access.PaymentAccessObject;
import com.mymanager.data.data_access.PaymentTypeAccessObject;
import com.mymanager.data.data_access.ProjectAccessObject;
import com.mymanager.data.data_access.UserAccessObject;
import com.mymanager.data.data_access.WorkingHourAccessObject;
import com.mymanager.data.data_access.interfaces.AdditionalAccess;
import com.mymanager.data.data_access.interfaces.AdressAccess;
import com.mymanager.data.data_access.interfaces.AttemptAccess;
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
import com.mymanager.data.data_access.interfaces.PaymentTypeAccess;
import com.mymanager.data.data_access.interfaces.ProjectAccess;
import com.mymanager.data.data_access.interfaces.UserAccess;
import com.mymanager.data.data_access.interfaces.WorkingHourAccess;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Additional;
import com.mymanager.data.models.Adress;
import com.mymanager.data.models.AdressType;
import com.mymanager.data.models.Attempt;
import com.mymanager.data.models.Contact;
import com.mymanager.data.models.ContactType;
import com.mymanager.data.models.Country;
import com.mymanager.data.models.Currency;
import com.mymanager.data.models.Department;
import com.mymanager.data.models.Document;
import com.mymanager.data.models.Employee;
import com.mymanager.data.models.FileType;
import com.mymanager.data.models.Job;
import com.mymanager.data.models.JobHistory;
import com.mymanager.data.models.Payment;
import com.mymanager.data.models.PaymentType;
import com.mymanager.data.models.Project;
import com.mymanager.data.models.Status;
import com.mymanager.data.models.User;
import com.mymanager.data.models.WorkingHour;
import com.mymanager.utils.MessageType;
import com.mymanager.utils.UtilWindow;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class UserController {

	protected User user;

	//
	private AdditionalAccess additionalAccess;
	private AdressAccess adressAccess;
	private AttemptAccess attemptAccess;
	private ContactAccess contactAccess;
	private CountryAccess countryAccess;
	private CurrencyAccess currencyAccess;
	private DepartmentAccess departmentAccess;
	private DocumentAccess documentAccess;
	private EmployeeAccess employeeAccess;
	private FileTypeAccess fileTypeAccess;
	private PaymentTypeAccess paymentTypeAccess;
	private JobAccess jobAccess;
	private JobHistoryAccess jobHistoryAccess;
	private PaymentAccess paymentAccess;
	private ProjectAccess projectAccess;
	private UserAccess userAccess;
	private WorkingHourAccess workingHourAccess;
	private QueryType queryType = QueryType.NORMAL;
	private AdressType adressType = AdressType.USER_ADRESS;
	private ContactType contactType = ContactType.USER_CONTACT;

	public UserController(User user) {
		this.user = user;
		additionalAccess = new AdditionalAccessObject(queryType);
		adressAccess = new AdressAccessObject(queryType, adressType);
		attemptAccess = new AttemptAccessObject();
		contactAccess = new ContactAccessObject(queryType, contactType);
		countryAccess = new CountryAccessObject();
		currencyAccess = new CurrencyAccessObject();
		departmentAccess = new DepartmentAccessObject(queryType);
		documentAccess = new DocumentAccessObject(queryType);
		employeeAccess = new EmployeeAccessObject(queryType);
		fileTypeAccess = new FileTypeAccessObject();
		paymentTypeAccess = new PaymentTypeAccessObject();
		jobAccess = new JobAccessObject(queryType);
		jobHistoryAccess = new JobHistoryAccessObject(queryType);
		paymentAccess = new PaymentAccessObject(queryType);
		projectAccess = new ProjectAccessObject();
		userAccess = new UserAccessObject(queryType);
		workingHourAccess = new WorkingHourAccessObject(queryType);

	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
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
	// Additional
	// =======================================================================
	public List<Additional> getAllAdditional(QueryType queryType) {
		try {
			setQueryType(queryType);
			return additionalAccess.readAllAdditionals();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Additional> getAllAdditional(QueryType queryType, int limit, int offset) {
		try {
			setQueryType(queryType);
			return additionalAccess.readAllAdditionals(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public Additional getAdditional(String employeeId) {
		try {
			return additionalAccess.readAdditional(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int saveAdditional(Additional additional) {
		try {
			return additionalAccess.insertAdditional(additional);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int editAdditional(Additional oldAdditional, Additional newAdditional) {
		try {
			return additionalAccess.updateAdditional(oldAdditional, newAdditional);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deleteAdditional(Additional additional) {
		try {
			return additionalAccess.deleteAdditional(additional);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// =======================================================================
	// Adress
	// =======================================================================

	public List<Adress> getAllAdresses(QueryType queryType, AdressType adressType) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAllAdresses();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Adress> getAllAdresses(QueryType queryType, AdressType adressType, int limit, int offset) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAllAdresses(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public Adress getAdress(QueryType queryType, AdressType adressType, int adressId) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdress(adressId);
		} catch (Exception e) {
			return null;
		}

	}

	public Adress getAdressByPersonId(QueryType queryType, AdressType adressType, String personId) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdressesByPersonId(personId);
		} catch (Exception e) {
			return null;
		}

	}

	public List<Adress> getAdressByCity(QueryType queryType, AdressType adressType, String city) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdressesByCity(city);
		} catch (Exception e) {
			return null;
		}

	}

	public List<Adress> getAdressByCountry(QueryType queryType, AdressType adressType, String country) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdressesByCountry(country);
		} catch (Exception e) {
			return null;
		}

	}

	public List<Adress> getAdressByStreet(QueryType queryType, AdressType adressType, String street) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdressesByStreet(street);
		} catch (Exception e) {
			return null;
		}

	}

	public int saveAdress(AdressType adressType, Adress adress) {
		try {
			setAdressType(adressType);
			return adressAccess.insertAdress(adress);
		} catch (Exception e) {
			return 0;
		}

	}

	public int editAdress(AdressType adressType, Adress oldAdress, Adress newAdress) {
		try {
			setAdressType(adressType);
			return adressAccess.updateAdress(oldAdress, newAdress);
		} catch (Exception e) {
			return 0;
		}

	}

	public int deleteAdress(AdressType adressType, Adress adress) {
		try {
			setAdressType(adressType);
			return adressAccess.deleteAdress(adress);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// =======================================================================
	// Attempts
	// =======================================================================

	public List<Attempt> getAllAttempts() {
		try {
			return attemptAccess.readAllAttempts();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Attempt> getAllAttempts(int limit, int offset) {
		try {
			return attemptAccess.readAllAttempts(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Attempt> getAttemptsByUser(User user) {
		try {
			return attemptAccess.readAttempts(user);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Attempt> getAttemptsByStatus(Status status) {
		try {
			return attemptAccess.readAttempts(status);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Attempt> getAttemptsById(String id) {
		try {
			return attemptAccess.readAttempts(id);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int saveAttempt(Attempt attempt) {
		try {
			return attemptAccess.insertAttempt(attempt);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deleteAttempt(Attempt attempt) {
		try {
			return attemptAccess.deleteAttempt(attempt);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// =======================================================================
	// Contacts
	// =======================================================================

	public List<Contact> getAllContacts(QueryType queryType, ContactType contactType) {
		try {
			setQueryType(queryType);
			setContactType(contactType);
			return contactAccess.readAllContacts();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Contact> getAllContacts(QueryType queryType, ContactType contactType, int limit, int offset) {
		try {
			setQueryType(queryType);
			setContactType(contactType);
			return contactAccess.readAllContacts(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public Contact getContact(QueryType queryType, ContactType contactType, int contactId) {
		try {
			setQueryType(queryType);
			setContactType(contactType);
			return contactAccess.readContact(contactId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Contact> getContactsByCelular(QueryType queryType, ContactType contactType, int celular) {
		try {
			setQueryType(queryType);
			setContactType(contactType);
			return contactAccess.readContactsByCelular(celular);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Contact> getContactsByEmail(QueryType queryType, ContactType contactType, String email) {
		try {
			setQueryType(queryType);
			setContactType(contactType);
			return contactAccess.readContactsByEmail(email);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public Contact getContactByPersonId(QueryType queryType, ContactType contactType, String personId) {
		try {
			setQueryType(queryType);
			setContactType(contactType);
			return contactAccess.readContactByPersonId(personId);
		} catch (Exception e) {
			return null;
		}

	}

	public int saveContact(ContactType contactType, Contact contact) {
		try {
			setContactType(contactType);
			return contactAccess.insertContact(contact);
		} catch (Exception e) {
			return 0;
		}

	}

	public int editContact(ContactType contactType, Contact oldContact, Contact newContact) {
		try {
			setContactType(contactType);
			return contactAccess.updateContact(oldContact, newContact);
		} catch (Exception e) {
			return 0;
		}

	}

	public int deleteContact(ContactType contactType, Contact contact) {
		try {
			setContactType(contactType);
			return contactAccess.deleteContact(contact);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// =======================================================================
	// Country
	// =======================================================================

	public List<Country> getAllCountries() {
		try {
			return countryAccess.readAllCountries();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Country> getCountriesByName(String countryNames) {
		try {
			return countryAccess.readCountries(countryNames);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public Country getCountry(String country) {
		try {
			return countryAccess.readCountry(country);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int editCountry(Country oldCountry, Country newCountry) {
		try {
			return countryAccess.updateCountry(oldCountry, newCountry);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int saveCountry(Country country) {
		try {
			return countryAccess.insertCountry(country);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deleteCountry(Country country) {
		try {
			return countryAccess.deleteCountry(country);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// =======================================================================
	// Currency
	// =======================================================================

	public List<Currency> getAllCurrencies() {
		try {
			return currencyAccess.readAllCurrencies();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Currency> getCurrenciesByName(String currencyNames) {
		try {
			return currencyAccess.readCurrencies(currencyNames);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int editCurrency(Currency oldCurrency, Currency newCurrency) {
		try {
			return currencyAccess.updateCurrency(oldCurrency, newCurrency);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int saveCurrency(Currency currency) {
		try {
			return currencyAccess.insertCurrency(currency);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deleteCurrency(Currency currency) {
		try {
			return currencyAccess.deleteCurrency(currency);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// =======================================================================
	// Department
	// =======================================================================

	public List<Department> getAllDepartments(QueryType queryType) {
		try {
			setQueryType(queryType);
			return departmentAccess.readAllDepartments();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Department> getAllDepartments(QueryType queryType, int limit, int offset) {
		try {
			setQueryType(queryType);
			return departmentAccess.readAllDepartments(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Department> getDepartmentsByName(QueryType queryType, String departmentName) {
		try {
			setQueryType(queryType);
			return departmentAccess.readDepartments(departmentName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public Department getDepartment(String departmentId) {
		try {
			return departmentAccess.readDepartment(departmentId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int editDepartment(Department oldDepartment, Department newDepartment) {
		try {
			return departmentAccess.updateDepartment(oldDepartment, newDepartment);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int saveDepartment(Department department) {
		try {
			return departmentAccess.insertDepartment(department);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deleteDepartment(Department department) {
		try {
			return departmentAccess.deleteDepartment(department);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// =======================================================================
	// Document
	// =======================================================================

	public List<Document> getAllDocuments(QueryType queryType) {
		try {
			setQueryType(queryType);
			return documentAccess.readAllDocuments();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Document> getAllDocuments(QueryType queryType, int limit, int offset) {
		try {
			setQueryType(queryType);
			return documentAccess.readAllDocuments(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Document> getDocumentsByName(QueryType queryType, String documentName) {
		try {
			setQueryType(queryType);
			return documentAccess.readDocuments(documentName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Document> getDocumentsByEmployeeId(QueryType queryType, String employeeId) {
		try {
			setQueryType(queryType);
			return documentAccess.readDocumentByEmployeeId(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public Document getDocument(int documentNumber) {
		try {
			return documentAccess.readDocument(documentNumber);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int editDocument(Document oldDocument, Document newDocument) {
		try {
			return documentAccess.updateDocument(oldDocument, newDocument);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int saveDocument(Document document) {
		try {
			return documentAccess.insertDocument(document);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deleteDocument(Document document) {
		try {
			return documentAccess.deleteDocument(document);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
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
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Employee> getAllEmployees(QueryType queryType, int limit, int offset) {
		try {
			setQueryType(queryType);
			return employeeAccess.readAllEmployees(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Employee> getEmployeesByFirstName(QueryType queryType, String firstName) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByFirstName(firstName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Employee> getEmployeesByLastName(QueryType queryType, String lastName) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByLastName(lastName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Employee> getEmployeesByJobId(QueryType queryType, int jobId) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByJobId(jobId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Employee> getEmployeesByDepartmentId(QueryType queryType, int departmentId) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByDepartmentId(departmentId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Employee> getEmployeesByProjectName(QueryType queryType, String projectName) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByProjectName(projectName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public Employee getEmployee(String employeeId) {
		try {
			return employeeAccess.readEmployee(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int editEmployee(Employee oldEmployee, Employee newEmployee) {
		try {
			return employeeAccess.updateEmployee(oldEmployee, newEmployee);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int saveEmployee(Employee employee) {
		try {
			return employeeAccess.insertEmployee(employee);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deleteEmployee(Employee employee) {
		try {
			return employeeAccess.deleteEmployee(employee);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// =======================================================================
	// Payment Types
	// =======================================================================

	public List<PaymentType> getAllPaymentTypes() {
		try {
			return paymentTypeAccess.readAllPaymentTypes();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public PaymentType getPaymentType(String paymentType) {
		try {
			return paymentTypeAccess.readPaymentType(paymentType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int editPaymentType(PaymentType oldPaymentType, PaymentType newPaymentType) {
		try {
			return paymentTypeAccess.updatePaymentType(oldPaymentType, newPaymentType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int savePaymentType(PaymentType paymentType) {
		try {
			return paymentTypeAccess.insertPaymentType(paymentType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deletePaymentType(PaymentType paymentType) {
		try {
			return paymentTypeAccess.deletePaymentType(paymentType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// =======================================================================
	// File Types
	// =======================================================================

	public List<FileType> getAllFileTypes() {
		try {
			return fileTypeAccess.readAllFileTypes();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public FileType getFileType(String fileType) {
		try {
			return fileTypeAccess.readFileType(fileType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int editFileType(FileType oldFileType, FileType newFileType) {
		try {
			return fileTypeAccess.updateFileType(oldFileType, newFileType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int saveFileType(FileType fileType) {
		try {
			return fileTypeAccess.insertFileType(fileType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deleteFileType(FileType fileType) {
		try {
			return fileTypeAccess.deleteFileType(fileType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// =======================================================================
	// Job
	// =======================================================================

	public List<Job> getAllJobs(QueryType queryType) {
		try {
			setQueryType(queryType);
			return jobAccess.readAllJobs();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Job> getAllJobs(QueryType queryType, int limit, int offset) {
		try {
			setQueryType(queryType);
			return jobAccess.readAllJobs(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Job> getJobsBetween(QueryType queryType, float minSalary, float maxSalary) {
		try {
			setQueryType(queryType);
			return jobAccess.readAllJobsBetweenSalary(minSalary, maxSalary);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Job> getJobsWithTitle(QueryType queryType, String jobTitle) {
		try {
			setQueryType(queryType);
			return jobAccess.readAllJobsByTitle(jobTitle);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public Job getJob(int jobId) {
		try {
			return jobAccess.readJob(jobId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int editJob(Job oldJob, Job newJob) {
		try {
			return jobAccess.updateJob(oldJob, newJob);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int saveJob(Job job) {
		try {
			return jobAccess.insertJob(job);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deleteJob(Job job) {
		try {
			return jobAccess.deleteJob(job);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// =======================================================================
	// JobHistory
	// =======================================================================

	public List<JobHistory> getAllJobHistories(QueryType queryType) {
		try {
			setQueryType(queryType);
			return jobHistoryAccess.readAllJobHistories();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<JobHistory> getAllJobHistories(QueryType queryType, int limit, int offset) {
		try {
			setQueryType(queryType);
			return jobHistoryAccess.readAllJobHistories(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<JobHistory> getJobHistoryBetween(QueryType queryType, LocalDate startDate, LocalDate endDate) {
		try {
			setQueryType(queryType);
			return jobHistoryAccess.readAllJobHistoryBetweenDates(startDate, endDate);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<JobHistory> getJobHistoryByJobId(QueryType queryType, String jobId) {
		try {
			setQueryType(queryType);
			return jobHistoryAccess.readAllJobHistoryByJobId(jobId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<JobHistory> getJobHistoryByDepartmentId(QueryType queryType, String departmentId) {
		try {
			setQueryType(queryType);
			return jobHistoryAccess.readAllJobHistoryByDepartmentId(departmentId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<JobHistory> getAllJobHistoryByEmployeeId(QueryType queryType, String employeeId) {
		try {
			setQueryType(queryType);
			return jobHistoryAccess.readAllJobHistoryByEmployeeId(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public JobHistory getJobHistory(String employeeId, LocalDateTime createdDateTime) {
		try {
			return jobHistoryAccess.readJobHistoryByEmployeeId(employeeId, createdDateTime);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int editJobHistory(JobHistory oldJobHistory, JobHistory newJobHistory) {
		try {
			return jobHistoryAccess.updateJobHistory(oldJobHistory, newJobHistory);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int saveJobHistory(JobHistory jobHistory) {
		try {
			return jobHistoryAccess.insertJobHistory(jobHistory);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deleteJobHistory(JobHistory jobHistory) {
		try {
			return jobHistoryAccess.deleteJobHistory(jobHistory);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
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
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}
	}

	public List<Payment> getAllPayments(QueryType queryType, int limit, int offset) {
		try {
			setQueryType(queryType);
			return paymentAccess.readAllPayments(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}
	}

	public List<Payment> getPaymentByType(QueryType queryType, PaymentType paymentType) {
		try {
			setQueryType(queryType);
			return paymentAccess.readAllPaymentsByPaymentType(paymentType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Payment> getPaymentByDescription(QueryType queryType, String description) {
		try {
			setQueryType(queryType);
			return paymentAccess.readAllPaymentsByDescription(description);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Payment> getPaymentByEmployeeId(QueryType queryType, String employeeId) {
		try {
			setQueryType(queryType);
			return paymentAccess.readAllPaymentsByEmployeeId(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public Payment getPayment(int paymentId) {
		try {
			return paymentAccess.readPayment(paymentId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int editPayment(Payment oldPayment, Payment newPayment) {
		try {
			return paymentAccess.updatePayment(oldPayment, newPayment);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int savePayment(Payment payment) {
		try {
			return paymentAccess.insertPayment(payment);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deletePayment(Payment payment) {
		try {
			return paymentAccess.deletePayment(payment);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
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
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Project> getAllProjects(int limit, int offset) {
		try {

			return projectAccess.readAllProjects(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Project> getProjectsByCustomer(String customer) {
		try {
			return projectAccess.readAllProjectsByCustomer(customer);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<Project> getProjectsByDescription(String description) {
		try {
			return projectAccess.readAllProjectsByDescription(description);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public Project getProject(String projectName) {
		try {
			return projectAccess.readProjectByName(projectName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int editProject(Project oldProject, Project newProject) {
		try {
			return projectAccess.updateProject(oldProject, newProject);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int saveProject(Project project) {
		try {
			return projectAccess.insertProject(project);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deleteProject(Project project) {
		try {
			return projectAccess.deleteProject(project);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// =======================================================================
	// User
	// =======================================================================

	public List<User> getAllUsers(QueryType queryType) {
		try {
			setQueryType(queryType);
			return userAccess.readAllUsers();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<User> getAllUsers(QueryType queryType, int limit, int offset) {
		try {
			setQueryType(queryType);
			return userAccess.readAllUsers(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<User> getAllUsersId(QueryType queryType) {
		try {
			setQueryType(queryType);
			return userAccess.readAllUsersId();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<User> getUsersByFirstName(QueryType queryType, String firstName) {
		try {
			setQueryType(queryType);
			return userAccess.readUsersByFirstName(firstName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<User> getUsersByLastName(QueryType queryType, String lastName) {
		try {
			setQueryType(queryType);
			return userAccess.readUsersByLastName(lastName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<User> getUsersByUserType(QueryType queryType, String userType) {
		try {
			setQueryType(queryType);
			return userAccess.readUsersByUserType(userType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<User> getUsersByRights(QueryType queryType, String right) {
		try {
			setQueryType(queryType);
			return userAccess.readUsersByRights(right);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public User getUser(String userId) {
		try {
			return userAccess.readUser(userId);
		} catch (Exception e) {
			return null;
		}

	}

	public int editUser(User oldUser, User newUser) {
		try {
			return userAccess.updateUser(oldUser, newUser);
		} catch (Exception e) {
			return 0;
		}

	}

	public int saveUser(User user) {
		try {
			return userAccess.insertUser(user);
		} catch (Exception e) {
			return 0;
		}

	}

	public int deleteUser(User user) {
		try {
			return userAccess.deleteUser(user);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
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
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<WorkingHour> getAllWorkingHour(QueryType queryType, int limit, int offset) {
		try {
			setQueryType(queryType);
			return workingHourAccess.readAllWorkingHour(limit, offset);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<WorkingHour> getWorkingHoursByEmployeeId(QueryType queryType, String employeeId) {
		try {
			setQueryType(queryType);
			return workingHourAccess.readWorkingHourByEmplyeeId(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<WorkingHour> getWorkingHoursByDate(QueryType queryType, LocalDate date) {
		try {
			setQueryType(queryType);
			return workingHourAccess.readWorkingHourByDate(date);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public List<WorkingHour> getWorkingHoursBetween(QueryType queryType, float minHours, float maxHours) {
		try {
			setQueryType(queryType);
			return workingHourAccess.readWorkingHourByBetween(minHours, maxHours);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public WorkingHour getWorkingHour(int index) {
		try {
			return workingHourAccess.readWorkingHourByIndex(index);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return null;
		}

	}

	public int editWorkingHour(WorkingHour oldWorkingHour, WorkingHour newWorkingHour) {
		try {
			return workingHourAccess.updateWorkingHour(oldWorkingHour, newWorkingHour);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int saveWorkingHour(WorkingHour workingHour) {
		try {
			return workingHourAccess.insertWorkingHour(workingHour);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	public int deleteWorkingHour(WorkingHour workingHour) {
		try {
			return workingHourAccess.deleteWorkingHour(workingHour);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "admin");
			return 0;
		}

	}

	// ==================================================================================
	// Controller methods
	// ===================================================================================

	public boolean verifyOldPassword(String typedOldPassword) {
		String oldPassword = user.getPassword();
		if (oldPassword.equals(typedOldPassword))
			return true;
		else
			return false;

	}

	public boolean verifyNewPasswords(String newPassword, String retypedNewPassword) {
		if (newPassword.equals(retypedNewPassword))
			return true;
		else
			return false;
	}

	public void changePassword(JDialog jdialog, String oldPassword, String newPassword, String retypedPassword) {
		try {
			if (verifyOldPassword(oldPassword)) {
				if (verifyNewPasswords(newPassword, retypedPassword)) {
					User newUser = new User(user.getUserId(), user.getUserType(), user.getFirstName(),
							user.getLastName(), null, user.getBirthday(), user.getBirthplace(), user.getGender(),
							user.getRights(), user.getCreatedBy(), user.getUserId(), user.getCreatedDate(),
							LocalDateTime.now());
					newUser.setPassword(newPassword);
					userAccess.updateUser(user, newUser);
					user = newUser;
				} else {
					UtilWindow.showMessage(null, "New password don't match", MessageType.WARNING);
				}

			} else {
				UtilWindow.showMessage(null, "Actual password you typed is not the same as actual password",
						MessageType.INFORMATION);
			}
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.WARNING);

		}
	}

}
