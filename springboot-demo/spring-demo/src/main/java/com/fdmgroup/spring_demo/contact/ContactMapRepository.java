package com.fdmgroup.spring_demo.contact;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class ContactMapRepository implements ContactRepository {
	private Map<Long, Contact> contacts;
	private long nextId;
	
	public ContactMapRepository() {
		super();
	}
	

	public ContactMapRepository(Map<Long, Contact> contacts) {
		super();
		this.contacts = contacts;
		this.nextId = contacts.keySet().stream().mapToLong(id -> id).max().orElse(1L);
	}


	@Override
	public Contact save(Contact t) {
		if(t.getId() == 0) {
			t.setId(nextId);
			nextId++;
			
		}
		contacts.put(t.getId(), t);
		return t;
	}

	@Override
	public Optional<Contact> findById(Long id) {
		return Optional.ofNullable(contacts.get(id));
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
