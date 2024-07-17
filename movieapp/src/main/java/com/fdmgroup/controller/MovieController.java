package com.fdmgroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.model.Movie;
import com.fdmgroup.service.MovieService;

import jakarta.servlet.http.HttpSession;

@Controller

public class MovieController {

	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}

	@GetMapping("/")
	public String indexpage(Model model) {
	    List<Movie> movies = movieService.findAllMovies();
	    model.addAttribute("movies", movies);
	    return "index";
	}

	@GetMapping("/addMovie")
	public String addMovie() {
		return "add-movie";
	}

	@PostMapping("/processMovie")
	public String processNewMovie(Movie movie, Model model, HttpSession session) {
		Movie savedMovie = movieService.addMovieTodatabase(movie);
		if (savedMovie != null) {
			session.setAttribute("movies", savedMovie);
			model.addAttribute("mymovie", savedMovie);


			return "movie-created";
		}
		return "redirect:/addMovie";
	}

	@GetMapping("/listMovies")
	public String gotoListMovies(Model model) {
		List<Movie> movies = movieService.findAllMovies();
		model.addAttribute("movies", movies);
		return "list-movies";
	}

	@GetMapping("/updateMovie")
	public String updateMovie(Model model, Long id) {
		Movie movie = movieService.findByID(id);
		model.addAttribute("movie", movie);
		return "update-movie";
	}
	@PostMapping("/processUpdateMovie")
	public String processUpdateMovie(Movie movie, Model model, HttpSession session) {
	    Movie updatedMovie = movieService.updateMovie(movie);
	    if (updatedMovie != null) {
	        session.setAttribute("movies", updatedMovie);
	        model.addAttribute("mymovie", updatedMovie);
	        return "movie-updated"; 
	    }
	    return "redirect:/updateMovie?id=" + movie.getId();
	}


}
