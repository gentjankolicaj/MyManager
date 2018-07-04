package com.mymanager.controllers;

import java.awt.Component;
import java.util.List;

import com.mymanager.data.data_access.AdressAccessObject;
import com.mymanager.data.data_access.ContactAccessObject;
import com.mymanager.data.data_access.EmployeeAccessObject;
import com.mymanager.data.data_access.interfaces.AdressAccess;
import com.mymanager.data.data_access.interfaces.ContactAccess;
import com.mymanager.data.data_access.interfaces.EmployeeAccess;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Adress;
import com.mymanager.data.models.AdressType;
import com.mymanager.data.models.Contact;
import com.mymanager.data.models.ContactType;
import com.mymanager.data.models.Employee;
import com.mymanager.data.models.User;
import com.mymanager.utils.MessageType;
import com.mymanager.utils.UtilWindow;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class AssistantController extends UserController {

	private EmployeeAccess employeeAccess;
	private AdressAccess adressAccess;
	private ContactAccess contactAccess;
	private QueryType queryType = QueryType.NORMAL;
	private AdressType adressType = AdressType.USER_ADRESS;
	private ContactType contactType = ContactType.USER_CONTACT;

	public AssistantController(User user, Component component) {
		super(user, component);
		adressAccess = new AdressAccessObject(queryType, adressType);
		contactAccess = new ContactAccessObject(queryType, contactType);
		employeeAccess = new EmployeeAccessObject(queryType);

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
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public Adress getAdress(int adressId) {
		try {
			return adressAccess.readAdress(adressId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public List<Adress> getAdressByPersonId(QueryType queryType, AdressType adressType, String personId) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdressesByPersonId(personId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public List<Adress> getAdressByCity(QueryType queryType, AdressType adressType, String city) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdressesByPersonId(city);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public List<Adress> getAdressByCountry(QueryType queryType, AdressType adressType, String country) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdressesByPersonId(country);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public List<Adress> getAdressByStreet(QueryType queryType, AdressType adressType, String street) {
		try {
			setQueryType(queryType);
			setAdressType(adressType);
			return adressAccess.readAdressesByPersonId(street);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public int saveAdress(AdressType adressType, Adress adress) {
		try {
			setAdressType(adressType);
			return adressAccess.insertAdress(adress);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return 0;
		}

	}

	public int editAdress(AdressType adressType, Adress oldAdress, Adress newAdress) {
		try {
			setAdressType(adressType);
			return adressAccess.updateAdress(oldAdress, newAdress);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return 0;
		}

	}

	public int deleteAdress(AdressType adressType, Adress adress) {
		try {
			setAdressType(adressType);
			return adressAccess.deleteAdress(adress);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
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
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public Contact getContact(int contactId) {
		try {
			return contactAccess.readContact(contactId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public List<Contact> getContactsByCelular(QueryType queryType, ContactType contactType, int celular) {
		try {
			setQueryType(queryType);
			setContactType(contactType);
			return contactAccess.readContactsByCelular(celular);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public List<Contact> getContactsByEmail(QueryType queryType, ContactType contactType, String email) {
		try {
			setQueryType(queryType);
			setContactType(contactType);
			return contactAccess.readContactsByEmail(email);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public List<Contact> getContactByPersonId(QueryType queryType, ContactType contactType, String personId) {
		try {
			setQueryType(queryType);
			setContactType(contactType);
			return contactAccess.readContactByPersonId(personId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public int saveContact(ContactType contactType, Contact contact) {
		try {
			setContactType(contactType);
			return contactAccess.insertContact(contact);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return 0;
		}

	}

	public int editContact(ContactType contactType, Contact oldContact, Contact newContact) {
		try {
			setContactType(contactType);
			return contactAccess.updateContact(oldContact, newContact);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return 0;
		}

	}

	public int deleteContact(ContactType contactType, Contact contact) {
		try {
			setContactType(contactType);
			return contactAccess.deleteContact(contact);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
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
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public List<Employee> getEmployeesByFirstName(QueryType queryType, String firstName) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByFirstName(firstName);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public List<Employee> getEmployeesByLastName(QueryType queryType, String lastName) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByLastName(lastName);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public List<Employee> getEmployeesByJobId(QueryType queryType, int jobId) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByJobId(jobId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public List<Employee> getEmployeesByDepartmentId(QueryType queryType, int departmentId) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByDepartmentId(departmentId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public List<Employee> getEmployeesByProjectName(QueryType queryType, String projectName) {
		try {
			setQueryType(queryType);
			return employeeAccess.readEmployeesByProjectName(projectName);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public Employee getEmployee(String employeeId) {
		try {
			return employeeAccess.readEmployee(employeeId);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return null;
		}

	}

	public int editEmployee(Employee oldEmployee, Employee newEmployee) {
		try {
			return employeeAccess.updateEmployee(oldEmployee, newEmployee);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return 0;
		}

	}

	public int saveEmployee(Employee employee) {
		try {
			return employeeAccess.insertEmployee(employee);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return 0;
		}

	}

	public int deleteEmployee(Employee employee) {
		try {
			return employeeAccess.deleteEmployee(employee);
		} catch (Exception e) {
			UtilWindow.showMessage(component, e.getMessage(), MessageType.ERROR, "assistant");
			return 0;
		}

	}

}
