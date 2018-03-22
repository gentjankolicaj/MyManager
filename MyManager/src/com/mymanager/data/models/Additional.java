package com.mymanager.data.models;

import java.time.LocalDateTime;

/**
 * 
 * @author gentjan_kolicaj
 *
 */
public class Additional {

	private String employeeId;
	private float salaryAmount;
	private LocalDateTime hireDate;
	private String createdBy;
	private String updatedBy;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	/**
	 * 
	 */
	public Additional() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param employeeId
	 * @param salaryAmount
	 * @param hireDate
	 * @param createdBy
	 * @param updatedBy
	 * @param createdDate
	 * @param updatedDate
	 */
	public Additional(String employeeId, float salaryAmount, LocalDateTime hireDate, String createdBy, String updatedBy,
			LocalDateTime createdDate, LocalDateTime updatedDate) {
		super();
		this.employeeId = employeeId;
		this.salaryAmount = salaryAmount;
		this.hireDate = hireDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public float getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(float salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public LocalDateTime getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDateTime hireDate) {
		this.hireDate = hireDate;
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

}
