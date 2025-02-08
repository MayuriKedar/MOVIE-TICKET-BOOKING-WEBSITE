package com.movie.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PDLOverrideSupported;

import com.movie.Pojo.Movie;
import com.movie.Pojo.Show;
import com.movie.util.DBConnectivity;

public class ShowDaoImpl implements ShowDao{

	Connection con= null;
	PreparedStatement ps=null;
	ResultSet rs= null;
	String sql=null;
	List<Show> slist= null;
	Show s;
	
	
	@Override
	public boolean addShow(Show s) {
		// TODO Auto-generated method stub
		
		con =DBConnectivity.getConnection();
		
		sql = "insert into show_01(show_MovieId, theaterName_loc,showtype,showDate,startTime,endTime,price,screen) "
				+ "values(?,?,?,?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,s.getShow_MovieId());
			ps.setString(2, s.getTheaterName_loc());
			ps.setString(3, s.getShowtype());
			ps.setDate(4, Date.valueOf(s.getShowDate()));
			ps.setString(5, s.getStartTime().toString());
			ps.setString(6, s.getEndTime().toString());
			ps.setDouble(7, s.getPrice());
			ps.setString(8, s.getScreen());
			

			int i = ps.executeUpdate();
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
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean UpdateShow(Show s) {
		// TODO Auto-generated method stub
		
		con = DBConnectivity.getConnection();
		sql= "update show_01 set show_MovieId=?, theaterName_loc=?,showtype=?,showDate=?,startTime=?,endTime=?,price=?,"
				+ "screen=? where showId=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, s.getShow_MovieId());
			ps.setString(2, s.getTheaterName_loc());
			ps.setString(3, s.getShowtype());
			ps.setDate(4, Date.valueOf(s.getShowDate()));
			ps.setTime(5, Time.valueOf(s.getStartTime()));
			ps.setTime(6, Time.valueOf(s.getEndTime()));
			ps.setDouble(7, s.getPrice());
			ps.setString(8, s.getScreen());			
			ps.setInt(9, s.getShowId());
			
			int i = ps.executeUpdate();
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
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteShow(int showId) {
		// TODO Auto-generated method stub
		
		
		con = DBConnectivity.getConnection();
		sql = "delete from show_01 where showId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, showId);
			
			
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
			try {
				con.close();
				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return false;
	}

	@Override
	public List<Show> getAllShows() {
		// TODO Auto-generated method stub
		
		con =DBConnectivity.getConnection();
		sql="select * from show_01";
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			slist=new ArrayList<>();
			
			
			while(rs.next())
			{
				s=new Show();
				s.setShowId(rs.getInt(1));
				s.setShow_MovieId(rs.getInt(2));
				s.setTheaterName_loc(rs.getString(3));
				s.setShowtype(rs.getString(4));
				s.setShowDate(rs.getDate(5).toLocalDate());
				s.setStartTime(LocalTime.parse(rs.getString(6)));
				s.setEndTime(LocalTime.parse(rs.getString(7)));
				s.setPrice(rs.getDouble(8));
				s.setScreen(rs.getString(9));
				
				Movie m = new MovieDaoImpl().getMovieById(rs.getInt(2));
				s.setShowMoive(m);
				
				slist.add(s);
			}
			return slist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Show getShowById(int showId) {
		// TODO Auto-generated method stub
		
		con =DBConnectivity.getConnection();
		sql ="select * from show_01 where showId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, showId);
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				s= new Show();
				s.setShowId(rs.getInt(1));
				s.setShow_MovieId(rs.getInt(2));
				s.setTheaterName_loc(rs.getString(3));
				s.setShowtype(rs.getString(4));
				s.setShowDate(rs.getDate(5).toLocalDate());
				s.setStartTime(LocalTime.parse(rs.getString(6)));
				s.setEndTime(LocalTime.parse(rs.getString(7)));
				s.setPrice(rs.getDouble(8));
				s.setScreen(rs.getString(9));
				
				Movie m = new MovieDaoImpl().getMovieById(rs.getInt(2));
				s.setShowMoive(m);
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public List<Show> getShowsByMovie(int show_MovieId) {
		// TODO Auto-generated method stub
		
		con =DBConnectivity.getConnection();
		sql="select * from show_01 where show_MovieId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, show_MovieId);
			
			rs=ps.executeQuery();
			slist=new ArrayList<>();
			
			while(rs.next())
			{
				s=new Show();
				s.setShowId(rs.getInt(1));
				s.setShow_MovieId(rs.getInt(2));
				s.setTheaterName_loc(rs.getString(3));
				s.setShowtype(rs.getString(4));
				s.setShowDate(rs.getDate(5).toLocalDate());
				s.setStartTime(LocalTime.parse(rs.getString(6)));
				s.setEndTime(LocalTime.parse(rs.getString(7)));
				s.setPrice(rs.getDouble(8));
				s.setScreen(rs.getString(9));
				
				Movie m = new MovieDaoImpl().getMovieById(rs.getInt(2));
				s.setShowMoive(m);
				
				slist.add(s);
			}
			return slist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	

	@Override
	public List<Show> getShowByTheater(String theaterName_loc) {
		// TODO Auto-generated method stub
		
		con = DBConnectivity.getConnection();
		sql = "select * from show_01 where theaterName_loc=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, theaterName_loc);
			
			rs=ps.executeQuery();
			slist = new ArrayList<>();
			
			while(rs.next())
			{
				s=new Show();
				s.setShowId(rs.getInt(1));
				s.setShow_MovieId(rs.getInt(2));
				s.setTheaterName_loc(rs.getString(3));
				s.setShowtype(rs.getString(4));
				s.setShowDate(rs.getDate(5).toLocalDate());
				s.setStartTime(LocalTime.parse(rs.getString(6)));
				s.setEndTime(LocalTime.parse(rs.getString(7)));
				s.setPrice(rs.getDouble(8));
				s.setScreen(rs.getString(9));
				
				Movie m = new MovieDaoImpl().getMovieById(2);
				s.setShowMoive(m);
				
				slist.add(s);
			}
			return slist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	
	
}
