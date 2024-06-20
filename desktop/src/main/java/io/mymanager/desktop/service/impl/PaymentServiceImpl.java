package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.PaymentDao;
import io.mymanager.desktop.data.dao.impl.PaymentDaoImpl;
import io.mymanager.desktop.data.models.Payment;
import io.mymanager.desktop.data.models.PaymentType;
import io.mymanager.desktop.service.PaymentService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class PaymentServiceImpl implements PaymentService {

  private final PaymentDao paymentDao;

  public PaymentServiceImpl() {
    super();
    this.paymentDao = new PaymentDaoImpl();
  }


  @Override
  public List<Payment> getAllPayments() throws Exception {
    return paymentDao.findAllPayments();
  }

  @Override
  public List<Payment> getAllPayments(int limit, int offset) throws Exception {
    return paymentDao.findAllPayments(limit, offset);
  }

  @Override
  public List<Payment> getAllPaymentsByPaymentType(PaymentType paymentType) throws Exception {
    return paymentDao.findAllPaymentsByPaymentType(paymentType);
  }

  @Override
  public List<Payment> getAllPaymentsByDescription(String paymentDescription) throws Exception {
    return paymentDao.findAllPaymentsByDescription(paymentDescription);
  }

  @Override
  public List<Payment> getAllPaymentsByEmployeeId(String employeeId) throws Exception {
    return paymentDao.findAllPaymentsByEmployeeId(employeeId);
  }

  @Override
  public Payment getPayment(int paymentId) throws Exception {
    return paymentDao.findPayment(paymentId);
  }

  @Override
  public int updatePayment(Payment oldPayment, Payment newPayment) throws Exception {
    return paymentDao.updatePayment(oldPayment, newPayment);
  }

  @Override
  public int savePayment(Payment payment) throws Exception {
    return paymentDao.savePayment(payment);
  }

  @Override
  public int deletePayment(Payment payment) throws Exception {
    return paymentDao.deletePayment(payment);
  }

}
