package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.PaymentType;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface PaymentTypeService {

	public abstract List<PaymentType> getAllPaymentTypes() throws Exception;

	public abstract PaymentType getPaymentType(String paymentType) throws Exception;

	public abstract int savePaymentType(PaymentType paymentType) throws Exception;

	public abstract int updatePaymentType(PaymentType oldPaymentType, PaymentType newPaymentType) throws Exception;

	public abstract int deletePaymentType(PaymentType paymentType) throws Exception;
}
