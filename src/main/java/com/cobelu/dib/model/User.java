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

	// All items which are visible to the User.
	@ManyToMany
	private Set<Item> sharedItems;
	
	@OneToMany
	private Set<Dib> myDibs;

	/*
	 * The default value is 10. We'll use 11 because... well... our password encoder
	 * goes to 11.
	 */
	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(11);

	protected User() {
		super();
	}

	public User(String username, String password, String role, Set<Item> myItems, Set<Item> sharedItems, Set<Dib> myDibs) {
		this();
		this.username = username;
		setPassword(password); // NEVER expose the password. Store encrypted instead.
		this.role = role;
		this.myItems = myItems;
		this.sharedItems = sharedItems;
		this.myDibs = myDibs;
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

	public Set<Item> getSharedItems() {
		return sharedItems;
	}
	
	public Set<Dib> getMyDibs() {
		return myDibs;
	}

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

	public void setSharedItems(Set<Item> sharedItems) {
		this.sharedItems = sharedItems;
	}
	
	public void setMyDibs(Set<Dib> myDibs) {
		this.myDibs = myDibs;
	}

	/**
	 * To String
	 */
	@Override
	public String toString() {
		return username;
	}

}
