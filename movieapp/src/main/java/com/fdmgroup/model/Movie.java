package com.fdmgroup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String director;
	public Movie() {
		super();
	}
	public Movie(long id, String title, String director) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", director=" + director + "]";
	}
	

}
