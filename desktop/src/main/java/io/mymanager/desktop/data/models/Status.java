package io.mymanager.desktop.data.models;

/**
 * @author gentjan kolicaj
 */
public enum Status {

  SUCCESS("SUCCESS"), FAILURE("FAILURE");

  private final String value;

  Status(String value) {
    this.value = value;
  }

  public String toString() {
    return value;
  }
}
