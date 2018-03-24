package com.mymanager.data.models;

import java.time.LocalDateTime;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class Atempt {

	private int index;
	private String user;
	private String password;
	private Status status;
	private String description;
	private LocalDateTime dateTime;

	/**
	 * 
	 */
	public Atempt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param index
	 * @param user
	 * @param password
	 * @param status
	 * @param description
	 * @param dateTime
	 */
	public Atempt(int index, String user, String password, Status status, String description, LocalDateTime dateTime) {
		super();
		this.index = index;
		this.user = user;
		this.password = password;
		this.status = status;
		this.description = description;
		this.dateTime = dateTime;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
