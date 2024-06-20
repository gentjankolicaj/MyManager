package io.mymanager.desktop.data.models;

/**
 * @author gentjan kolicaj
 */
public class Country extends MyModel {

  private String countryName;

  /**
   *
   */
  public Country() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Country(String countryName) {
    super();
    this.countryName = countryName;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  @Override
  public String toString() {
    return "Country [countryName=" + countryName + "]";
  }

}
