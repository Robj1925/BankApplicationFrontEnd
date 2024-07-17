package com.fdmgroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.model.Movie;
import com.fdmgroup.repository.MovieRepository;

@Service
public class MovieService {
	
	private MovieRepository movieRepo;
	@Autowired
	public MovieService(MovieRepository movieRepo) {
		super();
		this.movieRepo = movieRepo;
	}
	
	public List<Movie> findAllMovies(){
		return movieRepo.findAll();
	}
	
	public Movie findByID(long id) {
		return movieRepo.findById(id).get();
	}
	
	
	public Movie addMovieTodatabase(Movie movie) {
		return movieRepo.save(movie);
	}
	public Boolean deleteMovieFromDatabase(Movie movie) {
		if (!movieRepo.existsById(movie.getId())) {
			return false;
		}
		movieRepo.delete(movie);
		return true;
	}

	public Movie updateMovie(Movie movie) {
		return movieRepo.save(movie);
	}

}
