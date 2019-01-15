package com.cobelu.dib.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	// All users which can see the Item.
	@ManyToMany
	private Set<User> sharers;

	@OneToMany
	private Set<Dib> dibs;
	
	/*
	 * Constructors
	 */
	protected Item() {
		super();
	}

	public Item(String title, String description, User owner, Set<User> sharers, Set<Dib> dibs) {
		this();
		this.title = title;
		this.description = description;
		this.owner = owner;
		this.sharers = sharers;
		this.dibs = dibs;
	}

	public void addSharer(User sharer) {
		sharers.add(sharer);
	}

	public void removeSharer(User sharer) {
		sharers.remove(sharer);
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

	public Set<User> getSharers() {
		return sharers;
	}
	
	public Set<Dib> getDibs() {
		return dibs;
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

	public void setSharers(Set<User> sharers) {
		this.sharers = sharers;
	}
	
	public void setDibs(Set<Dib> dibs) {
		this.dibs = dibs;
	}

	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "Item [title=" + title + ", description=" + description + "]";
	}

}
