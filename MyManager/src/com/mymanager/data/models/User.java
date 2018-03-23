package com.mymanager.data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 
 * @author gentjan_kolicaj
 *
 */
public class User {

	private String userId;
	private UserType userType;
	private String firstName;
	private String lastName;
	private String middleName;
	private String password;
	private LocalDate birthday;
	private String birthplace;
	private Gender gender;
	private Contact contact;
	private Adress adress;
	private Rights rights;
	private String createdBy;
	private String updatedBy;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userId
	 * @param userType
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * @param password
	 * @param birthday
	 * @param birthplace
	 * @param gender
	 * @param contact
	 * @param adress
	 * @param rights
	 * @param createdBy
	 * @param updatedBy
	 * @param createdDate
	 * @param updatedDate
	 */
	public User(String userId, UserType userType, String firstName, String lastName, String middleName, String password,
			LocalDate birthday, String birthplace, Gender gender, Contact contact, Adress adress, Rights rights,
			String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.password = password;
		this.birthday = birthday;
		this.birthplace = birthplace;
		this.gender = gender;
		this.contact = contact;
		this.adress = adress;
		this.rights = rights;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Rights getRights() {
		return rights;
	}

	public void setRights(Rights rights) {
		this.rights = rights;
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
