package com.service1.Microservice1.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	
	private String Name;
	private String Surname;
	
	@JsonCreator
	public Person(@JsonProperty (value="Name" , required=true) String Name, @JsonProperty (value="Surname" , required=true) String Surname) {
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
