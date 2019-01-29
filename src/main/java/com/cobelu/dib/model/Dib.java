package com.cobelu.dib.model;

/*
 * Since this is an SQL-backed application, so use SQL package
 */
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Dib extends BaseEntity {

	/*
	 * Fields
	 */
	
	@NotNull
	private Date startDate;
	
	@NotNull
	private Time startTime;
	
	@NotNull
	private Date endDate;
	
	@NotNull
	private Time endTime;
	
	private String comment;
	
	@ManyToOne
	@NotNull
	private Item item;

	@ManyToOne
	@NotNull
	private User user;

	/*
	 * Constructors
	 */
	protected Dib() {
		super();
	}

	public Dib(Date startDate, Time startTime, Date endDate, Time endTime, String comment, Item item, User user) {
		this();
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.comment = comment;
		this.item = item;
		this.user = user;
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
	
	public Item getItem() {
		return item;
	}
	
	public User getUser() {
		return user;
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
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}
