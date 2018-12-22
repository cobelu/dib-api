package com.cobelu.dib.model;

import javax.persistence.Entity;

@Entity
public class Plan extends BaseEntity {
	
	/*
	 * Fields
	 */
	private String title;
	private Integer maxItems;
	
	/*
	 * Constructors
	 */
	protected Plan() {
		super();
	}
	
	public Plan(String title, Integer maxItems) {
		this.title = title;
		this.maxItems = maxItems;
	}
	
	/*
	 * Getters
	 */
	public String getTitle() {
		return title;
	}

	public Integer getMaxItems() {
		return maxItems;
	}
	
	/*
	 * 
	 * Setters
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public void setMaxItems(Integer maxItems) {
		this.maxItems = maxItems;
	}

}
