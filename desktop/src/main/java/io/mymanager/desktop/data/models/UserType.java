package io.mymanager.desktop.data.models;

/**
 * @author gentjan kolicaj
 */
public enum UserType {

  HR("HR"), MANAGER("MANAGER"), ADMIN("ADMIN"), FINANCE("FINANCE");

  private final String value;

  UserType(String value) {
    this.value = value;
  }

  public String toString() {
    return value;
  }
}
