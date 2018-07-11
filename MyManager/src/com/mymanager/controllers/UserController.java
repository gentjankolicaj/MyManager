package com.mymanager.controllers;

import com.mymanager.data.models.User;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public abstract class UserController {

	protected User user;

	public UserController(User user) {
		this.user = user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
