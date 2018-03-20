package com.mymanager.data.models;

import java.time.LocalDateTime;

/**
 * 
 * @author gentjan_kolicaj
 *
 */

public class Atempt {

	private int index;
	private String userId;
	private String actionType;
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
	 * @param userId
	 * @param actionType
	 * @param dateTime
	 */
	public Atempt(int index, String userId, String actionType, LocalDateTime dateTime) {
		super();
		this.index = index;
		this.userId = userId;
		this.actionType = actionType;
		this.dateTime = dateTime;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
