package io.mymanager.desktop.data.models;

/**
 * @author gentjan kolicaj
 */
public class FileType extends MyModel {

  private String file;

  /**
   *
   */
  public FileType() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param file
   */
  public FileType(String file) {
    super();
    this.file = file;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  @Override
  public String toString() {
    return "FileType [file=" + file + "]";
  }

}
