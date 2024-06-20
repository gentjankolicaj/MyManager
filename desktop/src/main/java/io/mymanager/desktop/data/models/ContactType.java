package io.mymanager.desktop.data.models;

/**
 * @author gentjan kolicaj
 */
public enum ContactType {

  USER_CONTACT("USER_CONTACT"), EMPLOYEE_CONTACT("EMPLOYEE_CONTACT");

  private final String value;

  ContactType(String value) {
    this.value = value;
  }

  public String toString() {
    return value;
  }
}
