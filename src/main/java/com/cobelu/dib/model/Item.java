package com.cobelu.dib.model;

import javax.persistence.Entity;
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

	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "Item [title=" + title + ", description=" + description + "]";
	}

}
