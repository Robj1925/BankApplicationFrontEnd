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
		System.out.println(fdmContact);

		System.out.println(fdmContactUSA);
	}

}
