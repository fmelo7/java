package com.example.demo.entity;

//Entity
public class Customer {

	private String id;
	private String firstname;
	private String lastname;

	public Customer() {
	}

	public Customer(String id, String firstname, String lastname) {
		super();
		this.id = id;
		this.setFirstname(firstname);
		this.lastname = lastname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

}
