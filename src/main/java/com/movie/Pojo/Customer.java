package com.movie.Pojo;

public class Customer {
	
	int custId;
	String firstName;
	String lastName;
	String emailId;
	String contact;
	String address;
	String password;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int custId, String firstName, String lastName, String emailId, String contact, String address,
			String password) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contact = contact;
		this.address = address;
		this.password = password;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", contact=" + contact + ", address=" + address + ", password=" + password + "]";
	}
	
	
}
