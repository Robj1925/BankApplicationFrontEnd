package com.fdmgroup.spring_demo.config;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.fdmgroup.spring_demo.contact.Contact;
import com.fdmgroup.spring_demo.contact.ContactRepository;
import com.fdmgroup.spring_demo.contact.ContactService;

@Configuration
public class ContactConfig {
	@Bean
	public ContactService contactService(ContactRepository contactRepo) {
		return new ContactService(contactRepo);
	}
	@Bean("fdmContact")
	@Scope("prototype")
	public Contact fdmGroup() {
		return new Contact("FDM Group", new ArrayList<>());
		
	}
	@Bean
	@Scope("prototype")
	public Contact blankContact() {
		return new Contact();
	}
}
