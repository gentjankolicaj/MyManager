package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Payment;
import com.mymanager.data.models.PaymentType;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface PaymentAccess {

	public abstract List<Payment> findAllPayments() throws Exception;

	public abstract List<Payment> findAllPayments(int limit, int offset) throws Exception;

	public abstract List<Payment> findAllPaymentsByPaymentType(PaymentType paymentType) throws Exception;

	public abstract List<Payment> findAllPaymentsByDescription(String paymentDescription) throws Exception;

	public abstract List<Payment> findAllPaymentsByEmployeeId(String employeeId) throws Exception;

	public abstract Payment findPayment(int paymentId) throws Exception;

	public abstract int updatePayment(Payment oldPayment, Payment newPayment) throws Exception;

	public abstract int savePayment(Payment payment) throws Exception;

	public abstract int deletePayment(Payment payment) throws Exception;

}
