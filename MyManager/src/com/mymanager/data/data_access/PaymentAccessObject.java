package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.PaymentAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Payment;
import com.mymanager.data.models.PaymentType;

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
	public List<Payment> readAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> readAllPaymentsByPaymentType(PaymentType paymentType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> readAllPaymentsByDescription(String paymentDescription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> readAllPaymentsByEmployeeId(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment readPayment(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertPayment(Payment payment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePayment(Payment payment) {
		// TODO Auto-generated method stub
		return 0;
	}

}
