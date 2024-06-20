package io.mymanager.desktop.data.models;

import java.time.LocalDateTime;

/**
 * @author gentjan kolicaj
 */
public class Project extends MyModel {

  private String projectName;
  private String description;
  private String customer;
  private Country country;
  private String createdBy;
  private String updatedBy;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  /**
   *
   */
  public Project() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param projectName
   * @param description
   * @param customer
   * @param country
   * @param createdBy
   * @param updatedBy
   * @param createdDate
   * @param updatedDate
   */
  public Project(String projectName, String description, String customer, Country country,
      String createdBy,
      String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate) {
    super();
    this.projectName = projectName;
    this.description = description;
    this.customer = customer;
    this.country = country;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
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
    return "Project [projectName=" + projectName + ", description=" + description + ", customer="
        + customer
        + ", country=" + country + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
        + ", createdDate="
        + createdDate + ", updatedDate=" + updatedDate + "]";
  }

}
