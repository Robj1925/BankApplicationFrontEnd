package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="HORROR_MOVIES")
public class HorrorMovie extends Movie {

	private Integer scaryRating;
	
	public HorrorMovie() {
		super();
	}

	public HorrorMovie(String title, String director, Integer scaryRating) {
		super(title, director);
		this.scaryRating = scaryRating;
	}

	public HorrorMovie(String title, String director) {
		super(title, director);
	}

	public Integer getScaryRating() {
		return scaryRating;
	}

	public void setScaryRating(Integer scaryRating) {
		this.scaryRating = scaryRating;
	}
	

}
