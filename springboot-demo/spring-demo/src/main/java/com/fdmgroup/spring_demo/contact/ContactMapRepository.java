package com.fdmgroup.spring_demo.contact;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ContactMapRepository implements ContactRepository {
	private Map<Long, Contact> contacts;
	
	public ContactMapRepository() {
		super();
	}
	

	public ContactMapRepository(Map<Long, Contact> contacts) {
		super();
		this.contacts = contacts;
	}


	@Override
	public Contact save(Contact t) {
		
		return ;
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
