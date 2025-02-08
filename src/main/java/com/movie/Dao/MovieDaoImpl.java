package com.movie.Dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.movie.Pojo.Movie;
import com.movie.util.DBConnectivity;


public class MovieDaoImpl implements MovieDao{

	
	Connection con  = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;
	Movie m = null;
	List<Movie> mlist = null;
	
	
	
	@Override
	public boolean addMovie(Movie m) {
		// TODO Auto-generated method stub
		
		con = DBConnectivity.getConnection();
	    sql = "insert into movie_01(MovieName, director, producer, writer, cast,type,releaseDate )values(?, ?, ?, ?, ?, ?, ?)";
	    try {
	      ps= con.prepareStatement(sql);
	      
	      ps.setString(1, m.getMovieName());
	      ps.setString(2, m.getDirector());
	      ps.setString(3, m.getProducer());
	      ps.setString(4, m.getWriter());
	      ps.setString(5, m.getCast());
	      ps.setString(6, m.getType());
	      
	      Date d = Date.valueOf(m.getReleaseDate());
	      ps.setDate(7, d);
	      
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
	public boolean updateMovie(Movie m) {
		// TODO Auto-generated method stub
		
		con = DBConnectivity.getConnection();
		
		sql = "update movie_01 set movieName=?, director=?,producer=?,writer=? ,cast=? ,type=?,releaseDate=? where movieId=?";
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, m.getMovieName());
			ps.setString(2, m.getDirector());
			ps.setString(3, m.getProducer());
			ps.setString(4, m.getWriter());
			ps.setString(5, m.getCast());
			ps.setString(6, m.getType());
			ps.setDate(7, Date.valueOf(m.getReleaseDate()));
			ps.setInt(8, m.getMovieId());
			
			
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
	public boolean deleteMovie(int movieId) {
		// TODO Auto-generated method stub
		con = DBConnectivity.getConnection();
		 
		sql = "delete from movie_01 where movieId=?";
		 
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, movieId);
			
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public List<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		con = DBConnectivity.getConnection();
		sql = "select * from movie_01";
		
		try {
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			mlist = new ArrayList<>();
			
			while(rs.next())
			{
				m= new Movie();
				m.setMovieId(rs.getInt(1));
				m.setMovieName(rs.getString(2));
				m.setDirector(rs.getString(3));
				m.setProducer(rs.getString(4));
				m.setWriter(rs.getString(5));
				m.setCast(rs.getString(6));
				m.setType(rs.getString(7));
				m.setReleaseDate(rs.getDate(8).toLocalDate());
				
				mlist.add(m);
			}
			return mlist;
			
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
		return null;
	}

	@Override
	public Movie getMovieById(int movieId) {
		// TODO Auto-generated method stub
		con = DBConnectivity.getConnection();
		
		sql = "select * from movie_01 where movieId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, movieId);
			
			rs= ps.executeQuery();
			
			while(rs.next())
			{
				m = new Movie();
				m.setMovieId(rs.getInt(1));
				m.setMovieName(rs.getString(2));
				m.setDirector(rs.getString(3));
				m.setProducer(rs.getString(4));
				m.setWriter(rs.getString(5));
				m.setCast(rs.getString(6));
				m.setType(rs.getString(7));
				
				m.setReleaseDate(rs.getDate(8).toLocalDate());
				
				return m;
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
		
		return null;
	}

	
	@Override
	public List<Movie> getMovieByName(String movieName) {
		// TODO Auto-generated method stub
		
		con = DBConnectivity.getConnection();
		
		sql= "select * from movie_01 where movieName=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, movieName);
			rs=ps.executeQuery();
			
			mlist = new ArrayList<>();
			
			while(rs.next())
			{
				m= new Movie();
				m.setMovieId(rs.getInt(1));
				m.setMovieName(rs.getString(2));
				m.setDirector(rs.getString(3));
				m.setProducer(rs.getString(4));
				m.setWriter(rs.getString(5));
				m.setCast(rs.getString(6));
				m.setType(rs.getString(7));
				m.setReleaseDate(rs.getDate(8).toLocalDate());
				
				mlist.add(m);
			}
			return mlist;
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
		return null;
	}
	

	@Override
	public List<Movie> getMovieByProducer(String producer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getMovieByDirector(String director) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
