package io.mymanager.desktop.data.models;

import java.time.LocalDateTime;

/**
 * @author gentjan kolicaj
 */
public class UserAdress extends MyModel {

  private int adressId;
  private String personId;
  private Country country;
  private String city;
  private String streetName;
  private int zipCode;
  private String building;
  private String createdBy;
  private String updatedBy;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  /**
   *
   */
  public UserAdress() {
    super();

  }

  /**
   * @param adressId
   * @param personId
   * @param country
   * @param city
   * @param streetName
   * @param zipCode
   * @param building
   * @param createdBy
   * @param updatedBy
   * @param createdDate
   * @param updatedDate
   */
  public UserAdress(int adressId, String personId, Country country, String city, String streetName,
      int zipCode,
      String building, String createdBy, String updatedBy, LocalDateTime createdDate,
      LocalDateTime updatedDate) {
    super();
    this.adressId = adressId;
    this.personId = personId;
    this.country = country;
    this.city = city;
    this.streetName = streetName;
    this.zipCode = zipCode;
    this.building = building;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public int getAdressId() {
    return adressId;
  }

  public void setAdressId(int adressId) {
    this.adressId = adressId;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId = personId;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public int getZipCode() {
    return zipCode;
  }

  public void setZipCode(int zipCode) {
    this.zipCode = zipCode;
  }

  public String getBuilding() {
    return building;
  }

  public void setBuilding(String building) {
    this.building = building;
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
    return "UserAdress [adressId=" + adressId + ", personId=" + personId + ", country=" + country
        + ", city=" + city
        + ", streetName=" + streetName + ", zipCode=" + zipCode + ", building=" + building
        + ", createdBy="
        + createdBy + ", updatedBy=" + updatedBy + ", createdDate=" + createdDate + ", updatedDate="
        + updatedDate + "]";
  }

}
