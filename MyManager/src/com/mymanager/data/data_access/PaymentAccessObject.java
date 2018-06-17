package com.mymanager.data.data_access;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.PaymentAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Currency;
import com.mymanager.data.models.Payment;
import com.mymanager.data.models.PaymentType;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class PaymentAccessObject implements PaymentAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public PaymentAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public PaymentAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<Payment> readAllPayments() throws Exception {
		List<Payment> paymentList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.employee_payments";
		else
			query = "SELECT * FROM mymanager.employee_payments_history";

		results = database.selectStatement(query);
		while (results.next()) {
			Payment temp = new Payment(results.getInt("payment_id"), new PaymentType(results.getString("payment_type")),
					results.getString("employee_id"), new Currency(results.getString("currency")),
					results.getFloat("payment_amount"), results.getString("payment_desc"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			paymentList.add(temp);

		}
		PrintUtils.print(paymentList, PrintType.QUERY_RESULTS);
		return paymentList;
	}

	@Override
	public List<Payment> readAllPaymentsByPaymentType(PaymentType paymentType) throws Exception {
		List<Payment> paymentList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.employee_payments WHERE payment_type=" + paymentType.getPayment();
		else
			query = "SELECT * FROM mymanager.employee_payments_history WHERE payment_type=" + paymentType.getPayment();

		results = database.selectStatement(query);
		while (results.next()) {
			Payment temp = new Payment(results.getInt("payment_id"), new PaymentType(results.getString("payment_type")),
					results.getString("employee_id"), new Currency(results.getString("currency")),
					results.getFloat("payment_amount"), results.getString("payment_desc"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			paymentList.add(temp);

		}
		PrintUtils.print(paymentList, PrintType.QUERY_RESULTS);
		return paymentList;
	}

	@Override
	public List<Payment> readAllPaymentsByDescription(String paymentDescription) throws Exception {
		List<Payment> paymentList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.employee_payments WHERE payment_desc=" + paymentDescription;
		else
			query = "SELECT * FROM mymanager.employee_payments_history WHERE payment_desc=" + paymentDescription;

		results = database.selectStatement(query);
		while (results.next()) {
			Payment temp = new Payment(results.getInt("payment_id"), new PaymentType(results.getString("payment_type")),
					results.getString("employee_id"), new Currency(results.getString("currency")),
					results.getFloat("payment_amount"), results.getString("payment_desc"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			paymentList.add(temp);

		}
		PrintUtils.print(paymentList, PrintType.QUERY_RESULTS);
		return paymentList;
	}

	@Override
	public List<Payment> readAllPaymentsByEmployeeId(String employeeId) throws Exception {
		List<Payment> paymentList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.employee_payments WHERE employee_id=" + employeeId;
		else
			query = "SELECT * FROM mymanager.employee_payments_history WHERE employee_id=" + employeeId;

		results = database.selectStatement(query);
		while (results.next()) {
			Payment temp = new Payment(results.getInt("payment_id"), new PaymentType(results.getString("payment_type")),
					results.getString("employee_id"), new Currency(results.getString("currency")),
					results.getFloat("payment_amount"), results.getString("payment_desc"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			paymentList.add(temp);

		}
		PrintUtils.print(paymentList, PrintType.QUERY_RESULTS);
		return paymentList;
	}

	@Override
	public Payment readPayment(int paymentId) throws Exception {
		Payment payment = null;
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.employee_payments WHERE payment_id=" + paymentId;
		else
			query = "SELECT * FROM mymanager.employee_payments_history WHERE payment_id=" + paymentId;

		results = database.selectStatement(query);
		while (results.next()) {
			payment = new Payment(results.getInt("payment_id"), new PaymentType(results.getString("payment_type")),
					results.getString("employee_id"), new Currency(results.getString("currency")),
					results.getFloat("payment_amount"), results.getString("payment_desc"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
		}
		PrintUtils.print(payment, PrintType.QUERY_RESULTS);
		return payment;
	}

	@Override
	public int updatePayment(Payment payment) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertPayment(Payment payment) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePayment(Payment payment) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
