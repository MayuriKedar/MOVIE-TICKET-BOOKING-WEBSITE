package com.movie.Dao;

import java.util.List;

import com.movie.Pojo.Customer;

public interface CustomerDao {

	public boolean addCustomer(Customer  c);
	public boolean updateCustomer(Customer c);
	public boolean deleteCustomer(int  custId);
	public boolean updatePassword(String emailId, String password);
	
	public List<Customer> showAllCustomers();
	public List<Customer> showByFirstName(String firstName);
	public List<Customer> showByLastName(String lastName);
	public Customer showByCustomerById(int custId);
	public Customer showByCustomerByEmailId(String emailId);
}
