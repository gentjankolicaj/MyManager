package io.mymanager.desktop.data.models;

import java.sql.Blob;
import java.time.LocalDateTime;

/**
 * @author gentjan kolicaj
 */
public class Document extends MyModel {

  private int number;
  private String name;
  private String type; // type determines who gets to see it
  private Blob file;
  private FileType fileType;
  private String employeeId;
  private String createdBy;
  private String updatedBy;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  /**
   *
   */
  public Document() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param number
   * @param name
   * @param type
   * @param file
   * @param fileType
   * @param employeeId
   * @param createdBy
   * @param updatedBy
   * @param createdDate
   * @param updatedDate
   */
  public Document(int number, String name, String type, Blob file, FileType fileType,
      String employeeId,
      String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate) {
    super();
    this.number = number;
    this.name = name;
    this.type = type;
    this.file = file;
    this.fileType = fileType;
    this.employeeId = employeeId;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Blob getFile() {
    return file;
  }

  public void setFile(Blob file) {
    this.file = file;
  }

  public FileType getFileType() {
    return fileType;
  }

  public void setFileType(FileType fileType) {
    this.fileType = fileType;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
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
    return "Document [number=" + number + ", name=" + name + ", type=" + type + ", file=" + file
        + ", fileType="
        + fileType + ", employeeId=" + employeeId + ", createdBy=" + createdBy + ", updatedBy="
        + updatedBy
        + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
  }

}
