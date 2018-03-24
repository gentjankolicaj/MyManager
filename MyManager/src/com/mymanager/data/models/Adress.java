package com.mymanager.data.models;

import java.time.LocalDateTime;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class Adress {

	private String id;
	private Country country;
	private String city;
	private String streetName;
	private int zipCode;
	private int building;
	private String createdBy;
	private String updatedBy;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	/**
	 * 
	 */
	public Adress() {
		super();

	}

	/**
	 * @param id
	 * @param country
	 * @param city
	 * @param streetName
	 * @param zipCode
	 * @param building
	 * @param createdBy
	 * @param updateBy
	 * @param createdDate
	 * @param updatedDate
	 */
	public Adress(String id, Country country, String city, String streetName, int zipCode, int building,
			String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.streetName = streetName;
		this.zipCode = zipCode;
		this.building = building;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
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
