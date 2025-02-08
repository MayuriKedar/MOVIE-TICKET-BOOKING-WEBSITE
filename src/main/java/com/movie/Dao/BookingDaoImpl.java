package com.movie.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.movie.Pojo.Booking;
import com.movie.util.DBConnectivity;

public class BookingDaoImpl implements BookingDao {

	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	ResultSet rs = null;
	String sql=null;
	String sql2=null;
	Booking b=null;
	List<Booking> blist =null;
	
	
	@Override
	public Booking bookmyShow(int bookingshowId, String email, String bookingSeates) {
		// TODO Auto-generated method stub
		
		con = DBConnectivity.getConnection();
		sql ="insert into booking_01(bookingshowId, email, bookingDateTime, bookingSeats, totalbills) values(?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, bookingshowId);
			ps.setString(2, email);
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");  //yyyy-mm-dd hh:mm:ss
 			
			String bookingDateTime = LocalDateTime.now().format(format);
			
 			ps.setTimestamp(3, Timestamp.valueOf(bookingDateTime));
			ps.setString(4, bookingSeates);
 			
			double price = new ShowDaoImpl().getShowById(bookingshowId).getPrice();
			int noOfseates = bookingSeates.split(",").length;
			double totalbills= price * noOfseates;
			ps.setDouble(5, totalbills);			
			
			int i =  ps.executeUpdate();
			
			if(i>0)
			{
				sql2= "select * from booking_01 where email=? and bookingDateTime=? ";
				ps2=con.prepareStatement(sql2);
				
				ps2.setString(1, email);
				ps2.setTimestamp(2, Timestamp.valueOf(bookingDateTime));
				rs=ps2.executeQuery();
				
				while(rs.next())
				{
					b= new Booking();
					b.setBookingId(rs.getInt(1));
					b.setBookingshowId(rs.getInt(2));
					b.setEmail(rs.getString(3));
					b.setTotalbills(rs.getDouble(4));
					b.setBookingDateTime(rs.getTimestamp(5).toLocalDateTime());
					b.setBookingSeats(rs.getString(6));
					
					b.setS(new ShowDaoImpl().getShowById(rs.getInt(2)));
					
					return b;
				}
				
			}
 			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean cancelShowBooking(int bookingId) {
		// TODO Auto-generated method stub
		
		con =DBConnectivity.getConnection();
		sql="delete from booking_01 where bookingId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, bookingId);
			
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
	public List<Booking> getMyBooking(String email) { //showMyBooking() 
		// TODO Auto-generated method stub
		
		
		con = DBConnectivity.getConnection();
		
		sql= "select * from booking_01 where email = ?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			blist= new ArrayList<>();

			while(rs.next())
			{
				b= new Booking();
				
				b.setBookingId(rs.getInt(1));
				b.setBookingshowId(rs.getInt(2));
				b.setEmail(rs.getString(3));
				b.setTotalbills(rs.getDouble(4));
				b.setBookingDateTime(rs.getTimestamp(5).toLocalDateTime());
				b.setBookingSeats(rs.getString(6));
				
				b.setS(new ShowDaoImpl().getShowById(rs.getInt(2)));
				
				blist.add(b);
			}
			return blist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		
		con = DBConnectivity.getConnection();
		sql = "select * from booking_01";
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			blist = new ArrayList<>();
			
			while(rs.next())
			{
				b = new Booking();
				b.setBookingId(rs.getInt(1));
				b.setBookingshowId(rs.getInt(2));
				b.setEmail(rs.getString(3));
				b.setTotalbills(rs.getDouble(4));
				b.setBookingDateTime(rs.getTimestamp(5).toLocalDateTime());
				b.setBookingSeats(rs.getString(6));
				
				b.setS(new ShowDaoImpl().getShowById(rs.getInt(2)));
				
				blist.add(b);
			}
			return blist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Booking getMyBookingById(int bookingId) {
		// TODO Auto-generated method stub
		
		con = DBConnectivity.getConnection();
		
		sql = "select * from booking_01 where bookingId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, bookingId);
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				b= new Booking();
				
				b.setBookingId(rs.getInt(1));
				b.setBookingshowId(rs.getInt(2));
				b.setEmail(rs.getString(3));
				b.setTotalbills(rs.getDouble(4));
				b.setBookingDateTime(rs.getTimestamp(5).toLocalDateTime());
				b.setBookingSeats(rs.getString(6));
				
				b.setS(new ShowDaoImpl().getShowById(rs.getInt(2)));
				
				return b;
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> getReservedSeates(int showId)
	{
		List<String> reservedSeats = new ArrayList<>();
		con = DBConnectivity.getConnection();

		sql = "select bookingSeats from booking_01 where bookingshowId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,showId);
			
			rs= ps.executeQuery();
			while(rs.next())
			{
				String[] arr_seates = rs.getString(1).split(",");
				for(String seat : arr_seates)
				{
					reservedSeats.add(seat);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(null!=ps)
				{
					ps.close();
				}
				if(null!=rs)
				{
					rs.close();
				}
				if(null!=con)
				{
					con.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return reservedSeats;
	}

}
