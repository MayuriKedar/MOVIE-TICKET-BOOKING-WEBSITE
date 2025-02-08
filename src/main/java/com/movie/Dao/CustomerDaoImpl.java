package com.movie.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.movie.Pojo.Customer;
import com.movie.util.DBConnectivity;

public class CustomerDaoImpl implements CustomerDao {

	Connection con = null;
	PreparedStatement ps= null;
	PreparedStatement pstUpdate = null;
	ResultSet rs= null;
	String sql;
	Customer c= null;
	List<Customer> clist = null;

	
	@Override
	public boolean addCustomer(Customer c) {
		// TODO Auto-generated method stub
		
		con=DBConnectivity.getConnection();
		
		sql ="insert into Customer_01(firstName,lastName,emailId,contact,address,password) values(?,?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getEmailId());
			ps.setString(4, c.getContact());
			ps.setString(5, c.getAddress());
			ps.setString(6, c.getPassword());

			
			int i =ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				con.close();
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		
		con = DBConnectivity.getConnection();
		sql="update Customer_01 set firstName=?, lastName=?, emailId=?, contact=?, address=?, password=? where custId=? ";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getEmailId());
			ps.setString(4, c.getContact());
			ps.setString(5, c.getAddress());
			ps.setString(6, c.getPassword());
			ps.setInt(7, c.getCustId());
			
			int i = ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean updatePassword(String emailId,String password)
	{
		con = DBConnectivity.getConnection();
		
		try {
			String checkEmailQuery = "SELECT * FROM Customer_01 WHERE emailId = ?";
            ps = con.prepareStatement(checkEmailQuery);
            ps.setString(1, emailId);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Update the password
                String updatePasswordQuery = "UPDATE Customer_01 SET password = ? WHERE emailId = ?";
                pstUpdate = con.prepareStatement(updatePasswordQuery);
                pstUpdate.setString(1, password);
                pstUpdate.setString(2, emailId);

                int rowsUpdated = pstUpdate.executeUpdate();
                if (rowsUpdated > 0) 
                {
                   return true;
                } 
        } }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) 
                	rs.close();
                if (ps != null) 
                	ps.close();
                if (pstUpdate != null) 
                	pstUpdate.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
		return false;
	}

	@Override
	public boolean deleteCustomer(int custId) {
		// TODO Auto-generated method stub
		
		con=DBConnectivity.getConnection();
		
		sql = "delete from Customer_01 where custId=?";
		
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1, custId);
			
			int i = ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Customer> showAllCustomers() {
		// TODO Auto-generated method stub
		
		con = DBConnectivity.getConnection();
		
		sql = "select * from Customer_01";
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			clist= new ArrayList<>();
			
			while(rs.next())
			{
				c=new Customer();
				c.setCustId(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setEmailId(rs.getString(4));
				c.setContact(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setPassword(rs.getString(7));
				
				clist.add(c);
				
			}
			return clist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Customer> showByFirstName(String firstName) {
		// TODO Auto-generated method stub
		
		con=DBConnectivity.getConnection();
		sql= "select * from Customer_01 where firstName=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, firstName);
			
			rs=ps.executeQuery();
			
			clist = new ArrayList();
			
			while(rs.next())
			{
				c = new Customer();
				c.setCustId(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setEmailId(rs.getString(4));
				c.setContact(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setPassword(rs.getString(7));
			
				clist.add(c);
			}
			return clist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ps.close();
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return null;
	}

	@Override
	public List<Customer> showByLastName(String lastName) {
		// TODO Auto-generated method stub
		
		
		con=DBConnectivity.getConnection();
		sql="select * from Customer_01 where lastName=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, lastName);
			
			rs=ps.executeQuery();
			
			clist= new ArrayList<>();
			
			
			while(rs.next())
			{
				c= new Customer();
				c.setCustId(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setEmailId(rs.getString(4));
				c.setContact(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setPassword(rs.getString(7));
				
				clist.add(c);
			}
			return clist;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public Customer showByCustomerById(int custId) {
		// TODO Auto-generated method stub
		
		con = DBConnectivity.getConnection();
		
		sql = "select * from Customer_01 where custId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, custId);
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				c = new Customer();
				c.setCustId(rs.getInt("custId"));
				c.setFirstName(rs.getString("firstName"));
				c.setLastName(rs.getString("lastName"));
				c.setEmailId(rs.getString("emailId"));
				c.setContact(rs.getString("contact"));
				c.setAddress(rs.getString("address"));
				c.setPassword(rs.getString( "password"));
				
				return c;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		return null;
	}

	@Override
	public Customer showByCustomerByEmailId(String emailId) {
		// TODO Auto-generated method stub
		
		con=DBConnectivity.getConnection();
		sql = "select * from Customer_01 where emailId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, emailId);
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				c= new Customer();
				c.setCustId(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setEmailId(rs.getString(4));
				c.setContact(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setPassword(rs.getString(7));
				
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
