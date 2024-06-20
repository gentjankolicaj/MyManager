package io.mymanager.desktop.data.models;

/**
 * @author gentjan kolicaj
 */
public class Currency extends MyModel {

  private String currencyName;

  /**
   *
   */
  public Currency() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Currency(String currencyName) {
    super();
    this.currencyName = currencyName;
  }

  /**
   * @param currencyName
   */

  public String getCurrencyName() {
    return currencyName;
  }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

  @Override
  public String toString() {
    return "Currency [currencyName=" + currencyName + "]";
  }

}
