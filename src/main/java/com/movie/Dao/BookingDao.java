package com.movie.Dao;

import java.util.List;

import com.movie.Pojo.Booking;

public interface BookingDao {

	public Booking bookmyShow(int bookingshowId,String email, String bookingSeates);
	boolean cancelShowBooking(int bookingId);
	List<Booking> getMyBooking(String email);
	List<Booking> getAllBooking();
	Booking getMyBookingById(int bookingId);
	public List<String> getReservedSeates(int showId);
}
