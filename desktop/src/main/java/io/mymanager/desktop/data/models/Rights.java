package io.mymanager.desktop.data.models;

/**
 * @author gentjan kolicaj
 */
public enum Rights {

  READ("READ"), WRITE("WRITE"), UPDATE("UPDATE"), DELETE("DELETE");

  private final String value;

  Rights(String value) {
    this.value = value;
  }

  public String toString() {
    return value;
  }
}
