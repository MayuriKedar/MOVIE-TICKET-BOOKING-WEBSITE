package com.movie.Dao;

import java.util.List;

import com.movie.Pojo.Movie;

public interface MovieDao {

	public boolean addMovie(Movie m);
	public boolean updateMovie(Movie m);
	public boolean deleteMovie(int movieId);
	
	List<Movie> getAllMovie();
	
	Movie getMovieById(int movieId);
	List<Movie> getMovieByName(String movieName);
	List<Movie> getMovieByProducer(String producer);
	List<Movie> getMovieByDirector(String director);
	
	
	
}
