package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.PaymentType;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface PaymentTypeAccess {

	public abstract List<PaymentType> readAllPaymentTypes() throws Exception;

	public abstract PaymentType readPaymentType(String paymentType) throws Exception;

	public abstract int insertPaymentType(PaymentType paymentType) throws Exception;

	public abstract int updatePaymentType(PaymentType oldPaymentType, PaymentType newPaymentType) throws Exception;

	public abstract int deletePaymentType(PaymentType paymentType) throws Exception;

}
