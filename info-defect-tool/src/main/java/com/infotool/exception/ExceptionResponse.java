package com.infotool.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date dateTime;
	private String message;
	private String description;
	
	public ExceptionResponse(Date dateTime, String message, String description) {
		super();
		this.dateTime = dateTime;
		this.message = message;
		this.description = description;
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
