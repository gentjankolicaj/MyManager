package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.PaymentType;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface PaymentTypeService {

  List<PaymentType> getAllPaymentTypes() throws Exception;

  PaymentType getPaymentType(String paymentType) throws Exception;

  int savePaymentType(PaymentType paymentType) throws Exception;

  int updatePaymentType(PaymentType oldPaymentType, PaymentType newPaymentType) throws Exception;

  int deletePaymentType(PaymentType paymentType) throws Exception;
}
