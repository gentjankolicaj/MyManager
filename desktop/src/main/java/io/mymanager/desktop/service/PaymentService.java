package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.Payment;
import io.mymanager.desktop.data.models.PaymentType;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface PaymentService {

  List<Payment> getAllPayments() throws Exception;

  List<Payment> getAllPayments(int limit, int offset) throws Exception;

  List<Payment> getAllPaymentsByPaymentType(PaymentType paymentType) throws Exception;

  List<Payment> getAllPaymentsByDescription(String paymentDescription) throws Exception;

  List<Payment> getAllPaymentsByEmployeeId(String employeeId) throws Exception;

  Payment getPayment(int paymentId) throws Exception;

  int updatePayment(Payment oldPayment, Payment newPayment) throws Exception;

  int savePayment(Payment payment) throws Exception;

  int deletePayment(Payment payment) throws Exception;

}
