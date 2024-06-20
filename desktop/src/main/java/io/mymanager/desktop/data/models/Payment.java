package io.mymanager.desktop.data.models;

import java.time.LocalDateTime;

/**
 * @author gentjan kolicaj
 */
public class Payment extends MyModel {

  private int paymentId;
  private PaymentType paymentType;
  private String employeeId;
  private Currency currency;
  private float paymentAmount;
  private String paymentDescription;
  private String createdBy;
  private String updatedBy;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  /**
   *
   */
  public Payment() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param paymentId
   * @param paymentType
   * @param employeeId
   * @param currency
   * @param paymentAmount
   * @param paymentDescription
   * @param createdBy
   * @param updatedBy
   * @param createdDate
   * @param updatedDate
   */
  public Payment(int paymentId, PaymentType paymentType, String employeeId, Currency currency,
      float paymentAmount,
      String paymentDescription, String createdBy, String updatedBy, LocalDateTime createdDate,
      LocalDateTime updatedDate) {
    super();
    this.paymentId = paymentId;
    this.paymentType = paymentType;
    this.employeeId = employeeId;
    this.currency = currency;
    this.paymentAmount = paymentAmount;
    this.paymentDescription = paymentDescription;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public int getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(int paymentId) {
    this.paymentId = paymentId;
  }

  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public float getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(float paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public String getPaymentDescription() {
    return paymentDescription;
  }

  public void setPaymentDescription(String paymentDescription) {
    this.paymentDescription = paymentDescription;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public LocalDateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(LocalDateTime updatedDate) {
    this.updatedDate = updatedDate;
  }

  @Override
  public String toString() {
    return "Payment [paymentId=" + paymentId + ", paymentType=" + paymentType + ", employeeId="
        + employeeId
        + ", currency=" + currency + ", paymentAmount=" + paymentAmount + ", paymentDescription="
        + paymentDescription + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
        + ", createdDate="
        + createdDate + ", updatedDate=" + updatedDate + "]";
  }

}
