package com.fdmgroup.spring_demo.contact;

import java.util.List;
import java.util.Objects;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Component
@Scope("prototype")
@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACT_ID_GEN")
	private long id;
	private String name;
	@OneToMany(mappedBy="contact", fetch=FetchType.EAGER)
	private List<ContactInfo> info;
	
	public Contact() {
		super();
	}

	public Contact(String name, List<ContactInfo> info) {
		super();
		this.name = name;
		this.info = info;
	}

	public Contact(long id, String name, List<ContactInfo> info) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ContactInfo> getInfo() {
		return info;
	}

	public void setInfo(List<ContactInfo> info) {
		this.info = info;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, info, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return id == other.id && Objects.equals(info, other.info) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", info=" + info + "]";
	}

	
}
