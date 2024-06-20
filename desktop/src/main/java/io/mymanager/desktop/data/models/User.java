package io.mymanager.desktop.data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author gentjan kolicaj
 */
public class User extends MyModel {

  private String userId;
  private String userType;
  private String firstName;
  private String lastName;
  private String password;
  private LocalDate birthday;
  private String birthplace;
  private Gender gender;
  private String rights;
  private String createdBy;
  private String updatedBy;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  /**
   *
   */
  public User() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param userId
   * @param userType
   * @param firstName
   * @param lastName
   * @param password
   * @param birthday
   * @param birthplace
   * @param gender
   * @param rights
   * @param createdBy
   * @param updatedBy
   * @param createdDate
   * @param updatedDate
   */
  public User(String userId, String userType, String firstName, String lastName, String password,
      LocalDate birthday,
      String birthplace, Gender gender, String rights, String createdBy, String updatedBy,
      LocalDateTime createdDate, LocalDateTime updatedDate) {
    super();
    this.userId = userId;
    this.userType = userType;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.birthday = birthday;
    this.birthplace = birthplace;
    this.gender = gender;
    this.rights = rights;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public String getRights() {
    return rights;
  }

  public void setRights(String rights) {
    this.rights = rights;
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
    return "User [userId=" + userId + ", userType=" + userType + ", firstName=" + firstName
        + ", lastName="
        + lastName + ", password=" + password + ", birthday=" + birthday + ", birthplace="
        + birthplace
        + ", gender=" + gender + ", rights=" + rights + ", createdBy=" + createdBy + ", updatedBy="
        + updatedBy
        + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
  }

}
