package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class MovieDTO {
	private String title;
	private String director;
	private Integer scaryRating;
	private Integer funnyRating;
	@NotNull(message="Movie Type cannot be null")
	private String movieType;
	public MovieDTO(String title, String director, Integer scaryRating, Integer funnyRating, String movieType) {
		super();
		this.title = title;
		this.director = director;
		this.scaryRating = scaryRating;
		this.funnyRating = funnyRating;
		this.movieType = movieType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Integer getScaryRating() {
		return scaryRating;
	}
	public void setScaryRating(Integer scaryRating) {
		this.scaryRating = scaryRating;
	}
	public Integer getFunnyRating() {
		return funnyRating;
	}
	public void setFunnyRating(Integer funnyRating) {
		this.funnyRating = funnyRating;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	@Override
	public String toString() {
		return "MovieDTO [title=" + title + ", director=" + director + ", scaryRating=" + scaryRating + ", funnyRating="
				+ funnyRating + ", movieType=" + movieType + "]";
	}

}
