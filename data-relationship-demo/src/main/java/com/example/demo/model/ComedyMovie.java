package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="COMEDY_MOVIES")
public class ComedyMovie extends Movie {
	private Integer funnyRating;

	
	public ComedyMovie() {
		super();
	}

	public ComedyMovie(String title, String director) {
		super(title, director);
	}

	public ComedyMovie(String title, String director, Integer funnyRating) {
		super(title, director);
		this.funnyRating = funnyRating;
	}

	public int getFunnyRating() {
		return funnyRating;
	}

	public void setFunnyRating(Integer funnyRating) {
		this.funnyRating = funnyRating;
	}
	

}
