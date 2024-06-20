package io.mymanager.desktop.data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author gentjan kolicaj
 */
public class JobHistory extends MyModel {

  private String employeeId;
  private LocalDate startDate;
  private LocalDate endDate;
  private String jobId;
  private String departmentId;
  private String createdBy;
  private String updatedBy;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  /**
   *
   */
  public JobHistory() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param employeeId
   * @param startDate
   * @param endDate
   * @param jobId
   * @param departmentId
   * @param createdBy
   * @param updatedBy
   * @param createdDate
   * @param updatedDate
   */
  public JobHistory(String employeeId, LocalDate startDate, LocalDate endDate, String jobId,
      String departmentId,
      String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate) {
    super();
    this.employeeId = employeeId;
    this.startDate = startDate;
    this.endDate = endDate;
    this.jobId = jobId;
    this.departmentId = departmentId;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public String getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
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
    return "JobHistory [employeeId=" + employeeId + ", startDate=" + startDate + ", endDate="
        + endDate + ", jobId="
        + jobId + ", departmentId=" + departmentId + ", createdBy=" + createdBy + ", updatedBy="
        + updatedBy
        + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
  }

}
