package com.movie.Pojo;

import java.time.LocalDate;

public class Movie 
{

	int movieId;
	String movieName;
	String director;
	String producer;
	String writer;
	String cast;
	String type;
	LocalDate releaseDate;
	
	public Movie(int movieId, String movieName, String director, String producer, String writer, String cast,
			String type, LocalDate releaseDate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.director = director;
		this.producer = producer;
		this.writer = writer;
		this.cast = cast;
		this.type = type;
		this.releaseDate = releaseDate;
	}
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", director=" + director + ", producer="
				+ producer + ", writer=" + writer + ", cast=" + cast + ", type=" + type + ", releaseDate=" + releaseDate
				+ "]";
	}
	
}
