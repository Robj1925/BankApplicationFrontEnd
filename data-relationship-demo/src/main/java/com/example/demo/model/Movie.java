package com.example.demo.model;

import jakarta.persistence.*;



@MappedSuperclass
public class Movie {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String director;
	
	
	public Movie() {
		super();
	}
	public Movie(String title, String director) {
		super();
		this.title = title;
		this.director = director;
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
	public long getId() {
		return id;
	}
	

}
