package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.MovieDTO;
import com.example.demo.model.ComedyMovie;
import com.example.demo.model.HorrorMovie;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {
	private MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}
	public Movie createMovie(MovieDTO movieDTO) {
		Movie movie = null;
		System.out.println(movieDTO);
		if (movieDTO.getMovieType().equalsIgnoreCase("horror")) {
			movie = new HorrorMovie(movieDTO.getTitle(), movieDTO.getDirector(), movieDTO.getScaryRating());
		} else if (movieDTO.getMovieType().equalsIgnoreCase("comedy")) {
			movie = new ComedyMovie(movieDTO.getTitle(), movieDTO.getDirector(), movieDTO.getFunnyRating());
		}
		return movieRepository.save(movie);
	}
	
	public List<HorrorMovie> getAllHorrorMovies() {
		return movieRepository.findAllHorrorMovies();
	}
	
}
