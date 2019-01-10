package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.PaymentAccessObject;
import com.mymanager.data.data_access.interfaces.PaymentAccess;
import com.mymanager.data.models.Payment;
import com.mymanager.data.models.PaymentType;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class PaymentServiceImpl implements PaymentService {
	
	private PaymentAccess paymentAccess;
	
	public PaymentServiceImpl() {
		super();
		this.paymentAccess=new PaymentAccessObject();
	}
	

	@Override
	public List<Payment> getAllPayments() throws Exception {
		return paymentAccess.findAllPayments();
	}

	@Override
	public List<Payment> getAllPayments(int limit, int offset) throws Exception {
		return paymentAccess.findAllPayments(limit, offset);
	}

	@Override
	public List<Payment> getAllPaymentsByPaymentType(PaymentType paymentType) throws Exception {
		return paymentAccess.findAllPaymentsByPaymentType(paymentType);
	}

	@Override
	public List<Payment> getAllPaymentsByDescription(String paymentDescription) throws Exception {
		return paymentAccess.findAllPaymentsByDescription(paymentDescription);
	}

	@Override
	public List<Payment> getAllPaymentsByEmployeeId(String employeeId) throws Exception {
		return paymentAccess.findAllPaymentsByEmployeeId(employeeId);
	}

	@Override
	public Payment getPayment(int paymentId) throws Exception {
		return paymentAccess.findPayment(paymentId);
	}

	@Override
	public int updatePayment(Payment oldPayment, Payment newPayment) throws Exception {
		return paymentAccess.updatePayment(oldPayment, newPayment);
	}

	@Override
	public int savePayment(Payment payment) throws Exception {
		return paymentAccess.savePayment(payment);
	}

	@Override
	public int deletePayment(Payment payment) throws Exception {
		return paymentAccess.deletePayment(payment);
	}

}
