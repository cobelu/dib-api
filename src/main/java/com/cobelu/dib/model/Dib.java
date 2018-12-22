package com.cobelu.dib.model;

import java.time.OffsetDateTime;

/*
 * Since this is an SQL-backed application, so use SQL package
 */

import javax.persistence.Entity;

@Entity
public class Dib extends BaseEntity {

	/*
	 * Fields
	 */
	private OffsetDateTime start; // year, month, day
	private OffsetDateTime end;
	private String comment;

	/*
	 * Constructors
	 */
	protected Dib() {
		super();
	}

	public Dib(OffsetDateTime start, OffsetDateTime end, String comment) {
		this();
		this.start = start;
		this.end = end;
		this.comment = comment;
	}
	
	/*
	 * Getters
	 */
	public OffsetDateTime getStart() {
		return start;
	}

	public OffsetDateTime getEnd() {
		return end;
	}

	public String getComment() {
		return comment;
	}
	
	/*
	 * Setters
	 */
	public void setStartDate(OffsetDateTime start) {
		this.start = start;
	}
	
	public void setEndDate(OffsetDateTime end) {
		this.end = end;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}

}
