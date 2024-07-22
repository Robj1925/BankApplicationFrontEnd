package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MovieDTO;
import com.example.demo.model.HorrorMovie;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@RestController
public class MovieController {
	private MovieService movieService;

	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	@GetMapping("/horror-movies")
	public List<HorrorMovie> getAllHorrorMovies() {
		return movieService.getAllHorrorMovies();
	}
	@PostMapping("/movie")
	public ResponseEntity<Movie> createMovie(@RequestBody MovieDTO movieDTO) {
		return ResponseEntity.ok(movieService.createMovie(movieDTO));
	}
	

}
