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

	public abstract List<Payment> readAllPayments();

	public abstract List<Payment> readAllPaymentsByPaymentType(PaymentType paymentType);

	public abstract List<Payment> readAllPaymentsByDescription(String paymentDescription);

	public abstract List<Payment> readAllPaymentsByEmployeeId(String employeeId);

	public abstract Payment readPayment(int paymentId);

	public abstract int updatePayment(Payment payment);

	public abstract int insertPayment(Payment payment);

	public abstract int deletePayment(Payment payment);

}
