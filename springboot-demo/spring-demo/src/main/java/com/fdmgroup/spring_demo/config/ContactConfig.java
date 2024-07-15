package com.fdmgroup.spring_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fdmgroup.spring_demo.contact.ContactRepository;
import com.fdmgroup.spring_demo.contact.ContactService;

@Configuration
public class ContactConfig {
@Bean
public ContactService contactService(ContactRepository contactRepo) {
	return new ContactService(contactRepo);
}
}
