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

	public abstract List<Payment> readAllPayments() throws Exception;

	public abstract List<Payment> readAllPayments(int limit, int offset) throws Exception;

	public abstract List<Payment> readAllPaymentsByPaymentType(PaymentType paymentType) throws Exception;

	public abstract List<Payment> readAllPaymentsByDescription(String paymentDescription) throws Exception;

	public abstract List<Payment> readAllPaymentsByEmployeeId(String employeeId) throws Exception;

	public abstract Payment readPayment(int paymentId) throws Exception;

	public abstract int updatePayment(Payment oldPayment, Payment newPayment) throws Exception;

	public abstract int insertPayment(Payment payment) throws Exception;

	public abstract int deletePayment(Payment payment) throws Exception;

}
