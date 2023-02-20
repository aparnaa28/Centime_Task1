package com.service3.Microservice3.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	
	private String Name;
	private String Surname;
	
	
	public Person( String Name, String Surname) {
		this.Name = Name;
		this.Surname = Surname;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getSurname() {
		return Surname;
	}
	
	public void setSurname(String surname) {
		Surname = surname;
	}
	
	@Override
	public String toString() {
		return (Name+ " " + Surname);
	}

}
