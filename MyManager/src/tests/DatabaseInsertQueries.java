package tests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import org.junit.After;
import org.junit.BeforeClass;
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
import com.mymanager.data.models.Attempt;
import com.mymanager.data.models.Country;
import com.mymanager.data.models.Currency;
import com.mymanager.data.models.Gender;
import com.mymanager.data.models.Rights;
import com.mymanager.data.models.Status;
import com.mymanager.data.models.User;
import com.mymanager.data.models.UserType;

public class DatabaseInsertQueries {

	private static AdditionalAccess additionalAccess;
	private static AdressAccess adressAccess;
	private static AttemptAccess attemptAccess;
	private static ContactAccess contactAccess;
	private static CountryAccess countryAccess;
	private static CurrencyAccess currencyAccess;
	private static DepartmentAccess departmentAccess;
	private static DocumentAccess documentAccess;
	private static EmployeeAccess employeeAccess;
	private static FileTypeAccess fileTypeAccess;
	private static JobAccess jobAccess;
	private static JobHistoryAccess jobHistoryAccess;
	private static PaymentAccess paymentAccess;
	private static ProjectAccess projectAccess;
	private static UserAccess userAccess;
	private static WorkingHourAccess workingHourAccess;

	private static QueryType queryType = QueryType.NORMAL;
	private static int randomId;
	private static Random random;

	@BeforeClass
	public static void setUp() throws Exception {

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

		random = new Random();
		randomId = random.nextInt(6000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insertUser() throws Exception {
		int i = 15;
		while (0 < i) {
			randomId = random.nextInt(2000);
			userAccess.insertUser(new User(String.valueOf(randomId), UserType.ADMIN, "name", "last", "password",
					LocalDate.now(), "Tirane", Gender.M, Rights.DELETE, "created Gentjan", "modified gentjan",
					LocalDateTime.now(), LocalDateTime.now()));

			i--;
		}

	}

	@Test
	public void insertAttempt() throws Exception {
		int i = 20;
		while (0 < i) {
			randomId = random.nextInt(2000);
			attemptAccess.insertAttempt(
					new Attempt(randomId, "75", "2018", Status.SUCCESS, "Attempt description", LocalDateTime.now()));
			i--;
		}
	}

	@Test
	public void insertCountry() throws Exception {
		countryAccess.insertCountry(new Country("Albania"));
		countryAccess.insertCountry(new Country("France"));
		countryAccess.insertCountry(new Country("Germany"));
		countryAccess.insertCountry(new Country("United Kingdom"));
		countryAccess.insertCountry(new Country("USA"));
		countryAccess.insertCountry(new Country("Italy"));
		countryAccess.insertCountry(new Country("Spain"));
		countryAccess.insertCountry(new Country("Austria"));
		countryAccess.insertCountry(new Country("Russia"));

	}

	@Test
	public void insertCurrency() throws Exception {
		currencyAccess.insertCurrency(new Currency("Euro"));
		currencyAccess.insertCurrency(new Currency("Lek"));
		currencyAccess.insertCurrency(new Currency("Dollar"));
		currencyAccess.insertCurrency(new Currency("Pound"));
		currencyAccess.insertCurrency(new Currency("Rubla"));
	}

	@Test
	public void insertDepartment() throws Exception {

	}

	@Test
	public void insertJob() throws Exception {

	}

	@Test
	public void insertProject() throws Exception {

	}

	@Test
	public void insertEmployee() throws Exception {

	}

	@Test
	public void insertAdress() throws Exception {

	}

	@Test
	public void insertContact() throws Exception {

	}

	@Test
	public void insertAdditional() throws Exception {

	}

}
