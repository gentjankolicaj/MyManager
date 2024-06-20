package io.mymanager.desktop.data.models;

import java.time.LocalDateTime;

/**
 * @author gentjan kolicaj
 */
public class Department extends MyModel {

  private int departmentId;
  private String departmentName;
  private String managerId;
  private String createdBy;
  private String updatedBy;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  /**
   *
   */
  public Department() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param departmentId
   * @param departmentName
   * @param managerId
   * @param createdBy
   * @param updatedBy
   * @param createdDate
   * @param updatedDate
   */
  public Department(int departmentId, String departmentName, String managerId, String createdBy,
      String updatedBy,
      LocalDateTime createdDate, LocalDateTime updatedDate) {
    super();
    this.departmentId = departmentId;
    this.departmentName = departmentName;
    this.managerId = managerId;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getManagerId() {
    return managerId;
  }

  public void setManagerId(String managerId) {
    this.managerId = managerId;
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
    return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
        + ", managerId="
        + managerId + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdDate="
        + createdDate
        + ", updatedDate=" + updatedDate + "]";
  }

}
