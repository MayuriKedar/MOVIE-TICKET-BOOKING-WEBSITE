package com.movie.Pojo;

import java.time.LocalDateTime;

public class Booking {

	int bookingId;
	int bookingshowId;
	Show s;
	String email;
	double totalbills;
	LocalDateTime bookingDateTime;
	String bookingSeats;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Booking(int bookingId, int bookingshowId, Show s, String email, double totalbills,
			LocalDateTime bookingDateTime, String bookingSeats) {
		super();
		this.bookingId = bookingId;
		this.bookingshowId = bookingshowId;
		this.s = s;
		this.email = email;
		this.totalbills = totalbills;
		this.bookingDateTime = bookingDateTime;
		this.bookingSeats = bookingSeats;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getBookingshowId() {
		return bookingshowId;
	}

	public void setBookingshowId(int bookingshowId) {
		this.bookingshowId = bookingshowId;
	}

	public Show getS() {
		return s;
	}

	public void setS(Show s) {
		this.s = s;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getTotalbills() {
		return totalbills;
	}

	public void setTotalbills(double totalbills) {
		this.totalbills = totalbills;
	}

	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	public String getBookingSeats() {
		return bookingSeats;
	}

	public void setBookingSeats(String bookingSeats) {
		this.bookingSeats = bookingSeats;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingshowId=" + bookingshowId + ", s=" + s + ", email=" + email
				+ ", totalbills=" + totalbills + ", bookingDateTime=" + bookingDateTime + ", bookingSeats="
				+ bookingSeats + "]";
	}
	
	
	
}
