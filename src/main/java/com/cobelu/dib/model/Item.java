package com.cobelu.dib.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item extends BaseEntity {

	/*
	 * Fields
	 */
	@NotNull
	@Size(min = 1, max = 64)
	private String title;

	private String description;

	@ManyToOne
	private User owner;
	
	@ManyToMany
	private Set<User> seers;

	/*
	 * Constructors
	 */
	protected Item() {
		super();
	}

	public Item(String title, String description) {
		this();
		this.title = title;
		this.description = description;
	}

	/*
	 * Getters
	 */
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public User getOwner() {
		return owner;
	}
	
	public Set<User> getSeers() {
		return seers;
	}

	/*
	 * Setters
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public void setSeers(Set<User> seers) {
		this.seers = seers;
	}

	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "Item [title=" + title + ", description=" + description + "]";
	}

}
