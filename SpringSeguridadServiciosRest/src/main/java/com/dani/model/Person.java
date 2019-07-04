package com.dani.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7191304991072102795L;
	private Long id;
	private String name;
	private String surname;
	private String phoneNumber;
	
	public Person() {
    }
	
	public Person(Long id, String name, String surname, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
	}
	@Override
    public boolean equals(Object obj) {
        return (obj instanceof Person) && this.id == ((Person)obj).getId() && this.name == ((Person)obj).getName();
    }
	
	@Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).append(getName()).toHashCode();
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


}
