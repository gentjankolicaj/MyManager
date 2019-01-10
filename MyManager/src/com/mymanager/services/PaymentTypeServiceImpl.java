package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.PaymentTypeAccessObject;
import com.mymanager.data.data_access.interfaces.PaymentTypeAccess;
import com.mymanager.data.models.PaymentType;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class PaymentTypeServiceImpl implements PaymentTypeService {
	
	private PaymentTypeAccess paymentTypeAccess;
	
	public PaymentTypeServiceImpl() {
		super();
		this.paymentTypeAccess=new PaymentTypeAccessObject();
	}

	@Override
	public List<PaymentType> getAllPaymentTypes() throws Exception {
		return paymentTypeAccess.findAllPaymentTypes();
	}

	@Override
	public PaymentType getPaymentType(String paymentType) throws Exception {
	  return paymentTypeAccess.findPaymentType(paymentType);
	}

	@Override
	public int savePaymentType(PaymentType paymentType) throws Exception {
		return paymentTypeAccess.savePaymentType(paymentType);
	}

	@Override
	public int updatePaymentType(PaymentType oldPaymentType, PaymentType newPaymentType) throws Exception {
		return paymentTypeAccess.updatePaymentType(oldPaymentType, newPaymentType);
	}

	@Override
	public int deletePaymentType(PaymentType paymentType) throws Exception {
		return paymentTypeAccess.deletePaymentType(paymentType);
	}

}
