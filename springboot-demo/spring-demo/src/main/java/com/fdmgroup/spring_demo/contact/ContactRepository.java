package com.fdmgroup.spring_demo.contact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	public List<Contact> findByName(String name);
	
	
	@Query("SELECT c FROM Contact c JOIN c.info ci WHERE ci.value LIKE :infoValue")
	public List<Contact> searchByContactInfo(@Param("infoValue") String infoValue);
	
}
