package com.fdmgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
