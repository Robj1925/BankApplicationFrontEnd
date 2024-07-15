package com.fdmgroup.spring_demo.repo;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
	T save(T t); // update and create
	Optional<T> findById(ID id);
	List<T> findAll();
	boolean existsById(ID id);
	void deleteById(ID id);
	

}
