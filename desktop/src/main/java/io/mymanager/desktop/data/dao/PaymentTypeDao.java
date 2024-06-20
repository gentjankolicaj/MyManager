package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.PaymentType;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface PaymentTypeDao {

  List<PaymentType> findAllPaymentTypes() throws Exception;

  PaymentType findPaymentType(String paymentType) throws Exception;

  int savePaymentType(PaymentType paymentType) throws Exception;

  int updatePaymentType(PaymentType oldPaymentType, PaymentType newPaymentType) throws Exception;

  int deletePaymentType(PaymentType paymentType) throws Exception;

}
