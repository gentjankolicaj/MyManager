package io.mymanager.desktop.data.models;

/**
 * @author gentjan kolicaj
 */
public class PaymentType extends MyModel {

  private String payment;

  /**
   *
   */
  public PaymentType() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param payment
   */
  public PaymentType(String payment) {
    super();
    this.payment = payment;
  }

  public String getPayment() {
    return payment;
  }

  public void setPayment(String payment) {
    this.payment = payment;
  }

  @Override
  public String toString() {
    return "PaymentType [payment=" + payment + "]";
  }

}
