package com.mymanager.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.mymanager.data.data_access.AdressAccessObject;
import com.mymanager.data.data_access.ContactAccessObject;
import com.mymanager.data.data_access.DepartmentAccessObject;
import com.mymanager.data.data_access.DocumentAccessObject;
import com.mymanager.data.data_access.EmployeeAccessObject;
import com.mymanager.data.data_access.FileTypeAccessObject;
import com.mymanager.data.data_access.JobAccessObject;
import com.mymanager.data.data_access.JobHistoryAccessObject;
import com.mymanager.data.data_access.WorkingHourAccessObject;
import com.mymanager.data.data_access.interfaces.AdressAccess;
import com.mymanager.data.data_access.interfaces.ContactAccess;
import com.mymanager.data.data_access.interfaces.DepartmentAccess;
import com.mymanager.data.data_access.interfaces.DocumentAccess;
import com.mymanager.data.data_access.interfaces.EmployeeAccess;
import com.mymanager.data.data_access.interfaces.FileTypeAccess;
import com.mymanager.data.data_access.interfaces.JobAccess;
import com.mymanager.data.data_access.interfaces.JobHistoryAccess;
import com.mymanager.data.data_access.interfaces.WorkingHourAccess;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Adress;
import com.mymanager.data.models.AdressType;
import com.mymanager.data.models.Contact;
import com.mymanager.data.models.ContactType;
import com.mymanager.data.models.Department;
import com.mymanager.data.models.Document;
import com.mymanager.data.models.Employee;
import com.mymanager.data.models.FileType;
import com.mymanager.data.models.Job;
import com.mymanager.data.models.JobHistory;
import com.mymanager.data.models.User;
import com.mymanager.data.models.WorkingHour;
import com.mymanager.utils.MessageType;
import com.mymanager.utils.UtilWindow;

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
	private QueryType queryType = QueryType.NORMAL;
	private AdressType adressType = AdressType.USER_ADRESS;
	private ContactType contactType = ContactType.USER_CONTACT;

	public HumanResourceController(User user) {
		super(user);
		adressAccess = new AdressAccessObject(queryType, adressType);
		contactAccess = new ContactAccessObject(queryType, contactType);
		departmentAccess = new DepartmentAccessObject(queryType);
		documentAccess = new DocumentAccessObject(queryType);
		employeeAccess = new EmployeeAccessObject(queryType);
		fileTypeAccess = new FileTypeAccessObject();
		jobAccess = new JobAccessObject(queryType);
		jobHistoryAccess = new JobHistoryAccessObject(queryType);
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
	// Adress
	// =======================================================================

	public List<Adress> getAllAdresses(QueryType queryType, AdressType adressType) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAllAdresses();
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public Adress getAdress(int adressId) {
		try {
			return adressAccess.readAdress(adressId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Adress> getAdressByPersonId(QueryType queryType, AdressType adressType, String personId) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdressesByPersonId(personId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Adress> getAdressByCity(QueryType queryType, AdressType adressType, String city) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdressesByPersonId(city);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Adress> getAdressByCountry(QueryType queryType, AdressType adressType, String country) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdressesByPersonId(country);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Adress> getAdressByStreet(QueryType queryType, AdressType adressType, String street) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdressesByPersonId(street);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public int saveAdress(AdressType adressType, Adress adress) {
		try {
			setAdressType(adressType);
			return adressAccess.insertAdress(adress);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int editAdress(AdressType adressType, Adress oldAdress, Adress newAdress) {
		try {
			setAdressType(adressType);
			return adressAccess.updateAdress(oldAdress, newAdress);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int deleteAdress(AdressType adressType, Adress adress) {
		try {
			setAdressType(adressType);
			return adressAccess.deleteAdress(adress);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
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
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public Contact getContact(int contactId) {
		try {
			return contactAccess.readContact(contactId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Contact> getContactsByCelular(QueryType queryType, ContactType contactType, int celular) {
		try {
			setQueryType(queryType);
			setContactType(contactType);
			return contactAccess.readContactsByCelular(celular);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Contact> getContactsByEmail(QueryType queryType, ContactType contactType, String email) {
		try {
			setQueryType(queryType);
			setContactType(contactType);
			return contactAccess.readContactsByEmail(email);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Contact> getContactByPersonId(QueryType queryType, ContactType contactType, String personId) {
		try {
			setQueryType(queryType);
			setContactType(contactType);
			return contactAccess.readContactByPersonId(personId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public int saveContact(ContactType contactType, Contact contact) {
		try {
			setContactType(contactType);
			return contactAccess.insertContact(contact);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int editContact(ContactType contactType, Contact oldContact, Contact newContact) {
		try {
			setContactType(contactType);
			return contactAccess.updateContact(oldContact, newContact);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int deleteContact(ContactType contactType, Contact contact) {
		try {
			setContactType(contactType);
			return contactAccess.deleteContact(contact);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
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
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Department> getDepartmentsByName(QueryType queryType, String departmentName) {
		try {
			setQueryType(queryType);
			return departmentAccess.readDepartments(departmentName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public Department getDepartment(int departmentId) {
		try {
			return departmentAccess.readDepartment(departmentId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public int editDepartment(Department oldDepartment, Department newDepartment) {
		try {
			return departmentAccess.updateDepartment(oldDepartment, newDepartment);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int saveDepartment(Department department) {
		try {
			return departmentAccess.insertDepartment(department);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int deleteDepartment(Department department) {
		try {
			return departmentAccess.deleteDepartment(department);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
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
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Document> getDocumentsByName(QueryType queryType, String documentName) {
		try {
			setQueryType(queryType);
			return documentAccess.readDocuments(documentName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Document> getDocumentsByEmployeeId(QueryType queryType, String employeeId) {
		try {
			setQueryType(queryType);
			return documentAccess.readDocumentByEmployeeId(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public Document getDocument(int documentNumber) {
		try {
			return documentAccess.readDocument(documentNumber);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public int editDocument(Document oldDocument, Document newDocument) {
		try {
			return documentAccess.updateDocument(oldDocument, newDocument);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int saveDocument(Document document) {
		try {
			return documentAccess.insertDocument(document);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int deleteDocument(Document document) {
		try {
			return documentAccess.deleteDocument(document);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
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
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Employee> getEmployeesByFirstName(QueryType queryType, String firstName) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByFirstName(firstName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Employee> getEmployeesByLastName(QueryType queryType, String lastName) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByLastName(lastName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Employee> getEmployeesByJobId(QueryType queryType, int jobId) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByJobId(jobId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Employee> getEmployeesByDepartmentId(QueryType queryType, int departmentId) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByDepartmentId(departmentId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Employee> getEmployeesByProjectName(QueryType queryType, String projectName) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByProjectName(projectName);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public Employee getEmployee(String employeeId) {
		try {
			return employeeAccess.readEmployee(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public int editEmployee(Employee oldEmployee, Employee newEmployee) {
		try {
			return employeeAccess.updateEmployee(oldEmployee, newEmployee);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int saveEmployee(Employee employee) {
		try {
			return employeeAccess.insertEmployee(employee);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int deleteEmployee(Employee employee) {
		try {
			return employeeAccess.deleteEmployee(employee);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
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
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public FileType getFileType(String fileType) {
		try {
			return fileTypeAccess.readFileType(fileType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public int editFileType(FileType oldFileType, FileType newFileType) {
		try {
			return fileTypeAccess.updateFileType(oldFileType, newFileType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int saveFileType(FileType fileType) {
		try {
			return fileTypeAccess.insertFileType(fileType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int deleteFileType(FileType fileType) {
		try {
			return fileTypeAccess.deleteFileType(fileType);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
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
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Job> getJobsBetween(QueryType queryType, float minSalary, float maxSalary) {
		try {
			setQueryType(queryType);
			return jobAccess.readAllJobsBetweenSalary(minSalary, maxSalary);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<Job> getJobsWithTitle(QueryType queryType, String jobTitle) {
		try {
			setQueryType(queryType);
			return jobAccess.readAllJobsByTitle(jobTitle);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public Job getJob(int jobId) {
		try {
			return jobAccess.readJob(jobId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public int editJob(Job oldJob, Job newJob) {
		try {
			return jobAccess.updateJob(oldJob, newJob);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int saveJob(Job job) {
		try {
			return jobAccess.insertJob(job);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int deleteJob(Job job) {
		try {
			return jobAccess.deleteJob(job);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
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
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<JobHistory> getJobHistoryBetween(QueryType queryType, LocalDate startDate, LocalDate endDate) {
		try {
			setQueryType(queryType);
			return jobHistoryAccess.readAllJobHistoryBetweenDates(startDate, endDate);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<JobHistory> getJobHistoryByJobId(QueryType queryType, String jobId) {
		try {
			setQueryType(queryType);
			return jobHistoryAccess.readAllJobHistoryByJobId(jobId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<JobHistory> getJobHistoryByDepartmentId(QueryType queryType, String departmentId) {
		try {
			setQueryType(queryType);
			return jobHistoryAccess.readAllJobHistoryByDepartmentId(departmentId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<JobHistory> getAllJobHistoryByEmployeeId(QueryType queryType, String employeeId) {
		try {
			setQueryType(queryType);
			return jobHistoryAccess.readAllJobHistoryByEmployeeId(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public JobHistory getJobHistory(String employeeId, LocalDateTime createdDateTime) {
		try {
			return jobHistoryAccess.readJobHistoryByEmployeeId(employeeId, createdDateTime);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public int editJobHistory(JobHistory oldJobHistory, JobHistory newJobHistory) {
		try {
			return jobHistoryAccess.updateJobHistory(oldJobHistory, newJobHistory);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int saveJobHistory(JobHistory jobHistory) {
		try {
			return jobHistoryAccess.insertJobHistory(jobHistory);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int deleteJobHistory(JobHistory jobHistory) {
		try {
			return jobHistoryAccess.deleteJobHistory(jobHistory);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
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
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<WorkingHour> getWorkingHoursByEmployeeId(QueryType queryType, String employeeId) {
		try {
			setQueryType(queryType);
			return workingHourAccess.readWorkingHourByEmplyeeId(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<WorkingHour> getWorkingHoursByDate(QueryType queryType, LocalDate date) {
		try {
			setQueryType(queryType);
			return workingHourAccess.readWorkingHourByDate(date);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public List<WorkingHour> getWorkingHoursBetween(QueryType queryType, float minHours, float maxHours) {
		try {
			setQueryType(queryType);
			return workingHourAccess.readWorkingHourByBetween(minHours, maxHours);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public WorkingHour getWorkingHour(int index) {
		try {
			return workingHourAccess.readWorkingHourByIndex(index);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return null;
		}

	}

	public int editWorkingHour(WorkingHour oldWorkingHour, WorkingHour newWorkingHour) {
		try {
			return workingHourAccess.updateWorkingHour(oldWorkingHour, newWorkingHour);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int saveWorkingHour(WorkingHour workingHour) {
		try {
			return workingHourAccess.insertWorkingHour(workingHour);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

	public int deleteWorkingHour(WorkingHour workingHour) {
		try {
			return workingHourAccess.deleteWorkingHour(workingHour);
		} catch (Exception e) {
			UtilWindow.showMessage(null, e.getMessage(), MessageType.ERROR, "hr");
			return 0;
		}

	}

}
