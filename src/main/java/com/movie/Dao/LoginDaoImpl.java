package com.movie.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.movie.util.DBConnectivity;

public class LoginDaoImpl implements LoginDao{


	Connection con = null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	String sql;
	
	@Override
	public boolean checkAdmin(String username, String password) {
		// TODO Auto-generated method stub
		
		con=DBConnectivity.getConnection();
		sql= "select * from admin_01 where emailId=? and password=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean checkCustomer(String username, String password) {
		// TODO Auto-generated method stub
		
		con=DBConnectivity.getConnection();
		sql = "select emailId, password  from customer_01 where emailId=? and password=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
