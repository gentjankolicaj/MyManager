package com.mymanager.data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class Additional extends MyModel {

	private String employeeId;
	private float salaryAmount;
	private LocalDate hireDate;
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
	public Additional(String employeeId, float salaryAmount, LocalDate hireDate, String createdBy, String updatedBy,
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

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
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

	@Override
	public String toNormal() {
		/**
		 * @param employeeId
		 * @param salaryAmount
		 * @param hireDate
		 * @param createdBy
		 * @param updatedBy
		 * @param createdDate
		 * @param updatedDate
		 */
		String cls = getClass().getSimpleName();
		String text = cls + ": employeeId:" + employeeId + ", salaryAmount:" + salaryAmount + ", hireDate:"
				+ hireDate.toString() + ", createdBy:" + createdBy + ", createdDate:" + createdDate.toString()
				+ ", updatedBy:" + updatedBy + ", updatedDate:" + updatedDate.toString();

		return text;
	}

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
