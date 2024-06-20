package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.Payment;
import io.mymanager.desktop.data.models.PaymentType;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface PaymentDao {

  List<Payment> findAllPayments() throws Exception;

  List<Payment> findAllPayments(int limit, int offset) throws Exception;

  List<Payment> findAllPaymentsByPaymentType(PaymentType paymentType) throws Exception;

  List<Payment> findAllPaymentsByDescription(String paymentDescription) throws Exception;

  List<Payment> findAllPaymentsByEmployeeId(String employeeId) throws Exception;

  Payment findPayment(int paymentId) throws Exception;

  int updatePayment(Payment oldPayment, Payment newPayment) throws Exception;

  int savePayment(Payment payment) throws Exception;

  int deletePayment(Payment payment) throws Exception;

}
