package com.movie.Dao;

public interface LoginDao{

	public boolean checkAdmin(String username, String password);
	public boolean checkCustomer(String username, String password);
	
}
