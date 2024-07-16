package com.fdmgroup.spring_demo.contact;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class ContactJpaRepository implements ContactRepository {

	@Override
	public Contact save(Contact t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Contact> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
