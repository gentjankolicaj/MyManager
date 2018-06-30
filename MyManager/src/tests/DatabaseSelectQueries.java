package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
import com.mymanager.data.data_access.interfaces.ProjectAccess;
import com.mymanager.data.data_access.interfaces.UserAccess;
import com.mymanager.data.data_access.interfaces.WorkingHourAccess;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.database.RDBMSType;

public class DatabaseSelectQueries {

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
	private JobAccess jobAccess;
	private JobHistoryAccess jobHistoryAccess;
	private PaymentAccess paymentAccess;
	private ProjectAccess projectAccess;
	private UserAccess userAccess;
	private WorkingHourAccess workingHourAccess;

	private static QueryType queryType = QueryType.NORMAL;

	@Before
	public void setUp() throws Exception {
		DatabaseManager.getDatabase(RDBMSType.MySQL);
		additionalAccess = new AdditionalAccessObject(queryType);
		adressAccess = new AdressAccessObject(queryType);
		attemptAccess = new AttemptAccessObject();
		contactAccess = new ContactAccessObject(queryType);
		countryAccess = new CountryAccessObject();
		currencyAccess = new CurrencyAccessObject();
		departmentAccess = new DepartmentAccessObject(queryType);
		documentAccess = new DocumentAccessObject(queryType);
		employeeAccess = new EmployeeAccessObject(queryType);
		fileTypeAccess = new FileTypeAccessObject();
		jobAccess = new JobAccessObject(queryType);
		jobHistoryAccess = new JobHistoryAccessObject(queryType);
		paymentAccess = new PaymentAccessObject(queryType);
		projectAccess = new ProjectAccessObject();
		userAccess = new UserAccessObject(queryType);
		workingHourAccess = new WorkingHourAccessObject(queryType);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void selectUser() throws Exception {
		userAccess.readAllUsers();

	}

	@Test
	public void selectEmployee() throws Exception {
		employeeAccess.readAllEmployees();
	}

	@Test
	public void selectAdress() throws Exception {
		adressAccess.readAllAdresses();
	}

	@Test
	public void selectContact() throws Exception {
		contactAccess.readAllContacts();
	}

	@Test
	public void selectAdditional() throws Exception {
		additionalAccess.readAllAdditionals();
	}

	@Test
	public void selectAtempt() throws Exception {
		attemptAccess.readAllAttempts();
	}

	@Test
	public void selectCountry() throws Exception {
		countryAccess.readAllCountries();
	}

	@Test
	public void selectCurrency() throws Exception {
		currencyAccess.readAllCurrencies();
	}

	@Test
	public void selectDocument() throws Exception {
		documentAccess.readAllDocuments();
	}

	@Test
	public void selectDepartment() throws Exception {
		departmentAccess.readAllDepartments();
	}

	@Test
	public void selectFileType() throws Exception {
		fileTypeAccess.readAllFileTypes();
	}

	@Test
	public void selectJob() throws Exception {
		jobAccess.readAllJobs();
	}

	@Test
	public void selectPayment() throws Exception {
		paymentAccess.readAllPayments();
	}

	@Test
	public void selectJobHistory() throws Exception {
		jobHistoryAccess.readAllJobHistories();
	}

	@Test
	public void selectProject() throws Exception {
		projectAccess.readAllProjects();
	}

	@Test
	public void selectWorkingHour() throws Exception {
		workingHourAccess.readAllWorkingHour();
	}

}
