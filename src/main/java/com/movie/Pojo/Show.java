package com.movie.Pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Show {

	
	int showId;
	int show_MovieId;
	Movie showMoive;
	String theaterName_loc;
	String showtype;
	LocalDate showDate;
	LocalTime startTime;
	LocalTime endTime;
	double price;
	String screen;
	
	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Show(int showId, int show_MovieId, Movie showMoive, String theaterName_loc, String showtype,
			LocalDate showDate, LocalTime startTime, LocalTime endTime, double price, String screen) {
		super();
		this.showId = showId;
		this.show_MovieId = show_MovieId;
		this.showMoive = showMoive;
		this.theaterName_loc = theaterName_loc;
		this.showtype = showtype;
		this.showDate = showDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.screen = screen;
	}
	
	
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getShow_MovieId() {
		return show_MovieId;
	}
	public void setShow_MovieId(int show_MovieId) {
		this.show_MovieId = show_MovieId;
	}
	public Movie getShowMoive() {
		return showMoive;
	}
	public void setShowMoive(Movie showMoive) {
		this.showMoive = showMoive;
	}
	public String getTheaterName_loc() {
		return theaterName_loc;
	}
	public void setTheaterName_loc(String theaterName_loc) {
		this.theaterName_loc = theaterName_loc;
	}
	public String getShowtype() {
		return showtype;
	}
	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	
	
	@Override
	public String toString() {
		return "Show [showId=" + showId + ", show_MovieId=" + show_MovieId + ", showMoive=" + showMoive
				+ ", theaterName_loc=" + theaterName_loc + ", showtype=" + showtype + ", showDate=" + showDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", price=" + price + ", screen=" + screen + "]";
	}
	
	
	
}
