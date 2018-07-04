package com.mymanager.controllers;

import java.awt.Component;

import com.mymanager.data.models.User;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public abstract class UserController {

	protected User user;
	protected Component component;

	public UserController(User user, Component component) {
		this.user = user;
		this.component = component;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

}
