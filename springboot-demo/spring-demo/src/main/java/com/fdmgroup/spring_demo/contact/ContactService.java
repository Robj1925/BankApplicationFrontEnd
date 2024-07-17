package com.fdmgroup.spring_demo.contact;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//Service is a class that provides some functionality or values to the application
@Service
public class ContactService {
	private ContactRepository contactRepo;

	public ContactService(ContactRepository contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}

	public Optional<Contact> createContact(Contact contact) {
		Optional<Contact> contactOpt = Optional.empty();
		if (!contactRepo.existsById(contact.getId())) {
			contactOpt = Optional.of(contactRepo.save(contact));
		}
		
		return contactOpt;
	}
	public Optional<Contact> readContactById(long id) {
		return contactRepo.findById(id);
	}
	public List<Contact> getByName(String name) {
		return contactRepo.findByName(name);
	}

	public List<Contact> readAll() {
		return contactRepo.findAll();
	}
}
