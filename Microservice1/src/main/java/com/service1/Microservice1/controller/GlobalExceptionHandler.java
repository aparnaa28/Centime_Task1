package com.service1.Microservice1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.service1.Microservice1.entity.ExceptionFormatter;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	    public ResponseEntity<ExceptionFormatter> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {

	        HttpStatus code= HttpStatus.METHOD_NOT_ALLOWED;
	        ExceptionFormatter obj= new ExceptionFormatter (ex,code);
	        return new ResponseEntity<ExceptionFormatter>(obj,code);
	    }
	    
	    @ExceptionHandler(HttpMessageNotReadableException.class)
	    public ResponseEntity<ExceptionFormatter> handleMessageNotReadableException(HttpMessageNotReadableException ex) {

	        HttpStatus code= HttpStatus.BAD_REQUEST;
	        ExceptionFormatter obj= new ExceptionFormatter (ex,code);
	        return new ResponseEntity<ExceptionFormatter>(obj,code);
	    }
	    
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ExceptionFormatter> handleException(Exception ex) {

	        HttpStatus code= HttpStatus.INTERNAL_SERVER_ERROR;
	        ExceptionFormatter obj= new ExceptionFormatter (ex,code);
	        return new ResponseEntity<ExceptionFormatter>(obj,code);
	    }

}
