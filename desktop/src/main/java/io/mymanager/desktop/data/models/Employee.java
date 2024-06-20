package io.mymanager.desktop.data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author gentjan kolicaj
 */
public class Employee extends MyModel {

  private String employeeId;
  private String firstName;
  private String lastName;
  private String middleName;
  private LocalDate birthday;
  private String birthplace;
  private Gender gender;
  private int jobId;
  private int departmentId;
  private String projectName;
  private String createdBy;
  private String updatedBy;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  /**
   *
   */
  public Employee() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param employeeId
   * @param firstName
   * @param lastName
   * @param middleName
   * @param birthday
   * @param birthplace
   * @param gender
   * @param jobId
   * @param departmentId
   * @param projectName
   * @param createdBy
   * @param updatedBy
   * @param createdDate
   * @param updatedDate
   */
  public Employee(String employeeId, String firstName, String lastName, String middleName,
      LocalDate birthday,
      String birthplace, Gender gender, int jobId, int departmentId, String projectName,
      String createdBy,
      String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate) {
    super();
    this.employeeId = employeeId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.birthday = birthday;
    this.birthplace = birthplace;
    this.gender = gender;
    this.jobId = jobId;
    this.departmentId = departmentId;
    this.projectName = projectName;
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public int getJobId() {
    return jobId;
  }

  public void setJobId(int jobId) {
    this.jobId = jobId;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
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
    return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
        + lastName
        + ", middleName=" + middleName + ", birthday=" + birthday + ", birthplace=" + birthplace
        + ", gender="
        + gender + ", jobId=" + jobId + ", departmentId=" + departmentId + ", projectName="
        + projectName
        + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdDate=" + createdDate
        + ", updatedDate=" + updatedDate + "]";
  }

}
