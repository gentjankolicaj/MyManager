package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.PaymentTypeDao;
import io.mymanager.desktop.data.dao.impl.PaymentTypeDaoImpl;
import io.mymanager.desktop.data.models.PaymentType;
import io.mymanager.desktop.service.PaymentTypeService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class PaymentTypeServiceImpl implements PaymentTypeService {

  private final PaymentTypeDao paymentTypeDao;

  public PaymentTypeServiceImpl() {
    super();
    this.paymentTypeDao = new PaymentTypeDaoImpl();
  }

  @Override
  public List<PaymentType> getAllPaymentTypes() throws Exception {
    return paymentTypeDao.findAllPaymentTypes();
  }

  @Override
  public PaymentType getPaymentType(String paymentType) throws Exception {
    return paymentTypeDao.findPaymentType(paymentType);
  }

  @Override
  public int savePaymentType(PaymentType paymentType) throws Exception {
    return paymentTypeDao.savePaymentType(paymentType);
  }

  @Override
  public int updatePaymentType(PaymentType oldPaymentType, PaymentType newPaymentType)
      throws Exception {
    return paymentTypeDao.updatePaymentType(oldPaymentType, newPaymentType);
  }

  @Override
  public int deletePaymentType(PaymentType paymentType) throws Exception {
    return paymentTypeDao.deletePaymentType(paymentType);
  }

}
