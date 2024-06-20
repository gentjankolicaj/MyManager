package io.mymanager.desktop.data.models;

/**
 * @author gentjan kolicaj
 */
public enum Gender {
  M("M"), F("F"), O("O");

  private final String value;

  Gender(String value) {
    this.value = value;
  }

  public String toString() {
    return value;
  }

}
