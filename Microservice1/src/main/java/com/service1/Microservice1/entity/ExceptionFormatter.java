package com.service1.Microservice1.entity;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionFormatter {
	
	String exception, message, timestamp;
	HttpStatus httpStatus;
	int httpStatusCode;
	
	public ExceptionFormatter(Exception e, HttpStatus code)
	{
		this.exception=e.getClass().getName();
		this.message=e.getMessage();
		this.timestamp=LocalDateTime.now().toString();
		this.httpStatus=code;
		this.httpStatusCode=code.value();
		
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	
	

}
