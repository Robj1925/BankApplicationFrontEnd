package com.fdmgroup.spring_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fdmgroup.spring_demo.contact.Contact;
import com.fdmgroup.spring_demo.contact.ContactInfo;
import com.fdmgroup.spring_demo.contact.ContactService;
import com.fdmgroup.spring_demo.contact.InfoType;

@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {
	ApplicationContext ctx;

	public SpringDemoApplication(ApplicationContext ctx) {
		super();
		this.ctx = ctx;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ContactService contactService = ctx.getBean(ContactService.class);
		List<ContactInfo> johnsContactInfo = new ArrayList<>();
		
		Contact cl = new Contact("John Doe", johnsContactInfo);
		johnsContactInfo.add(new ContactInfo(1L, "+1 234 567 8912", InfoType.CELL_PHONE, cl));
		Optional<Contact> createdContact = contactService.createContact(cl);
		if (createdContact.isPresent())
			System.out.println(createdContact.get());

		Contact fdmContact = ctx.getBean("fdmContact", Contact.class);

		Contact fdmContactUSA = ctx.getBean("fdmContact", Contact.class);
		fdmContactUSA.setName("FDM Group USA");
		List<ContactInfo> fdmUSAInfo = new ArrayList<>();
		fdmUSAInfo.add(new ContactInfo("14 Wall St", InfoType.ADDRESS, fdmContactUSA));
		fdmContactUSA.setInfo(fdmUSAInfo);
		List<ContactInfo> secondJohnsContactInfo = new ArrayList<>();
		Contact c2 = new Contact("John Doe", secondJohnsContactInfo);
		secondJohnsContactInfo.add(new ContactInfo(2L ,"jdoe@yahoo.net", InfoType.PERSONAL_EMAIL, c2));
		
		contactService.createContact(c2);
		
		System.out.println(contactService.readAll());
		List<Contact> contactsNamedJohnDoe = contactService.getByName("John Doe");
		// System.out.println(contactsNamedJohnDoe);
		contactsNamedJohnDoe.forEach(c -> System.out.println(c));
//		
//		Contact myContact = new Contact();
//		myContact.setName("Linette");
//		List<ContactInfo> myContactInfo = new ArrayList<>();
//		myContactInfo.add(new ContactInfo("+1 123 123 1234", InfoType.HOME_PHONE, myContact));
//		myContact.setInfo(myContactInfo);	
//		
//		contactService.createContact(myContact);
		
//		Contact maxContact = new Contact();
//		maxContact.setName("Max");
//		List<ContactInfo> maxContactInfo = new ArrayList<>();
//		maxContactInfo.add(new ContactInfo("+1 123 123 1234", InfoType.HOME_PHONE, maxContact));
//		maxContact.setInfo(maxContactInfo);
//		contactService.createContact(maxContact);
//		
//		List<Contact> contactsWithSamePhoneNumber = contactService.searchByContactInfo("+1 123 123 1234");
		
	}

}
