package com.cobelu.dib.model;

/*
 * Since this is an SQL-backed application, so use SQL package
 */
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;

@Entity
public class Dib extends BaseEntity {

	/*
	 * Fields
	 */
	private Date startDate;
	private Time startTime;
	private Date endDate;
	private Time endTime;
	private String comment;

	/*
	 * Constructors
	 */
	protected Dib() {
		super();
	}

	public Dib(Date startDate, Time startTime, Date endDate, Time endTime, String comment) {
		this();
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.comment = comment;
	}

	/*
	 * Getters
	 */
	public Date getStartDate() {
		return startDate;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Time getEndTime() {
		return endTime;
	}

	public String getComment() {
		return comment;
	}

	/*
	 * Setters
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
