package io.mymanager.desktop.data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author gentjan kolicaj
 */
public class WorkingHour extends MyModel {

  private int index;
  private String employeeId;
  private LocalDate date;
  private float amount;
  private String createdBy;
  private String updatedBy;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  /**
   *
   */
  public WorkingHour() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param index
   * @param employeeId
   * @param date
   * @param amount
   * @param createdBy
   * @param updatedBy
   * @param createdDate
   * @param updatedDate
   */
  public WorkingHour(int index, String employeeId, LocalDate date, float amount, String createdBy,
      String updatedBy,
      LocalDateTime createdDate, LocalDateTime updatedDate) {
    super();
    this.index = index;
    this.employeeId = employeeId;
    this.date = date;
    this.amount = amount;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
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
    return "WorkingHour [index=" + index + ", employeeId=" + employeeId + ", date=" + date
        + ", amount=" + amount
        + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdDate=" + createdDate
        + ", updatedDate=" + updatedDate + "]";
  }

}
