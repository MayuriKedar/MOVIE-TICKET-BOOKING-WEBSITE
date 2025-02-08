package com.movie.Dao;

import java.util.List;

import com.movie.Pojo.Show;

public interface ShowDao {

	public boolean addShow(Show s);
	public boolean UpdateShow(Show s);
	public boolean deleteShow(int showId);
	public List<Show> getAllShows();
	public Show getShowById(int showId);
	public List<Show> getShowsByMovie(int show_MovieId);
	public List<Show> getShowByTheater(String theaterName_loc);
}
