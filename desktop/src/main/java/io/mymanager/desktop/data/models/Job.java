package io.mymanager.desktop.data.models;

import java.time.LocalDateTime;

/**
 * @author gentjan kolicaj
 */
public class Job extends MyModel {

  private int jobId;
  private String jobTitle;
  private float maxSalary;
  private float minSalary;
  private String createdBy;
  private String updatedBy;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

  /**
   *
   */
  public Job() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param jobId
   * @param jobTitle
   * @param maxSalary
   * @param minSalary
   * @param createdBy
   * @param updatedBy
   * @param createdDate
   * @param updatedDate
   */
  public Job(int jobId, String jobTitle, float maxSalary, float minSalary, String createdBy,
      String updatedBy,
      LocalDateTime createdDate, LocalDateTime updatedDate) {
    super();
    this.jobId = jobId;
    this.jobTitle = jobTitle;
    this.maxSalary = maxSalary;
    this.minSalary = minSalary;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public int getJobId() {
    return jobId;
  }

  public void setJobId(int jobId) {
    this.jobId = jobId;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public float getMaxSalary() {
    return maxSalary;
  }

  public void setMaxSalary(float maxSalary) {
    this.maxSalary = maxSalary;
  }

  public float getMinSalary() {
    return minSalary;
  }

  public void setMinSalary(float minSalary) {
    this.minSalary = minSalary;
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
    return "Job [jobId=" + jobId + ", jobTitle=" + jobTitle + ", maxSalary=" + maxSalary
        + ", minSalary="
        + minSalary + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdDate="
        + createdDate
        + ", updatedDate=" + updatedDate + "]";
  }

}
