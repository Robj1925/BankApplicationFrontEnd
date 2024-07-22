package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HorrorMovie;
import com.example.demo.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	@Query("SELECT h from HorrorMovie h")
	public List<HorrorMovie> findAllHorrorMovies();
}
