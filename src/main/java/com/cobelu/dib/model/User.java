package com.cobelu.dib.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User extends BaseEntity {

	private String username;

	/*
	 * NEVER EVER SHOW THE PASSWORD!!!
	 */
	@JsonIgnore
	private String password;

	@JsonIgnore
	private String role;
	
	// One User owns many items. An Item has only one owner.
	@OneToMany
	private Set<Item> myItems;
	
	@ManyToMany
	private Set<Item> visibleItems;

	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

	protected User() {
		super();
	}

	public User(String username, String password, String role, Set<Item> myItems, Set<Item> visibleItems) {
		this();
		this.username = username;
		setPassword(password);
		this.role = role;
	}

	/*
	 * Getters
	 */
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRoles() {
		return role;
	}
	
	public Set<Item> getMyItems() {
		return myItems;
	};

	/*
	 * Setters
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = PASSWORD_ENCODER.encode(password);
	}

	public void getRoles(String role) {
		this.role = role;
	}
	
	public void setMyItems(Set<Item> myItems) {
		this.myItems = myItems;
	}

	/**
	 * To String
	 */
	@Override
	public String toString() {
		return username;
	}

}
