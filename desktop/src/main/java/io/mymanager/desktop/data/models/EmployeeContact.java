package io.mymanager.desktop.data.models;

import java.time.LocalDateTime;

/**
 * @author gentjan kolicaj
 */
public class EmployeeContact extends MyModel {

  private int contactId;
  private String personId;
  private int telephone;
  private int celular;
  private String email;
  private String fax;
  private String createdBy;
  private String updatedBy;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  /**
   *
   */
  public EmployeeContact() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param contactId
   * @param personId
   * @param telephone
   * @param celular
   * @param email
   * @param fax
   * @param createdBy
   * @param updatedBy
   * @param createdDate
   * @param updatedDate
   */
  public EmployeeContact(int contactId, String personId, int telephone, int celular, String email,
      String fax,
      String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate) {
    super();
    this.contactId = contactId;
    this.personId = personId;
    this.telephone = telephone;
    this.celular = celular;
    this.email = email;
    this.fax = fax;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public int getContactId() {
    return contactId;
  }

  public void setContactId(int contactId) {
    this.contactId = contactId;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId = personId;
  }

  public int getTelephone() {
    return telephone;
  }

  public void setTelephone(int telephone) {
    this.telephone = telephone;
  }

  public int getCelular() {
    return celular;
  }

  public void setCelular(int celular) {
    this.celular = celular;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
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
    return "EmployeeContact [contactId=" + contactId + ", personId=" + personId + ", telephone="
        + telephone
        + ", celular=" + celular + ", email=" + email + ", fax=" + fax + ", createdBy=" + createdBy
        + ", updatedBy=" + updatedBy + ", createdDate=" + createdDate + ", updatedDate="
        + updatedDate + "]";
  }

}
