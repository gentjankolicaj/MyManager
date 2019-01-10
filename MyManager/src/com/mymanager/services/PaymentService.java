package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.Payment;
import com.mymanager.data.models.PaymentType;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface PaymentService {
	
	public abstract List<Payment> getAllPayments() throws Exception;

	public abstract List<Payment> getAllPayments(int limit, int offset) throws Exception;

	public abstract List<Payment> getAllPaymentsByPaymentType(PaymentType paymentType) throws Exception;

	public abstract List<Payment> getAllPaymentsByDescription(String paymentDescription) throws Exception;

	public abstract List<Payment> getAllPaymentsByEmployeeId(String employeeId) throws Exception;

	public abstract Payment getPayment(int paymentId) throws Exception;

	public abstract int updatePayment(Payment oldPayment, Payment newPayment) throws Exception;

	public abstract int savePayment(Payment payment) throws Exception;

	public abstract int deletePayment(Payment payment) throws Exception;

}
