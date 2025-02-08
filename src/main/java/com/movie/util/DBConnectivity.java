package com.movie.util;

import java.sql.*;

public class DBConnectivity {

	public static Connection getConnection()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieproject_01?user=root&password=mayuri");
			
		} catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
}
