package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.PaymentAccess;
import com.mymanager.data.models.Payment;
import com.mymanager.data.models.PaymentType;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class PaymentAccessObject implements PaymentAccess {

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
