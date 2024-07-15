package com.fdmgroup.spring_demo.contact;

import java.util.List;
import java.util.Objects;

public class Contact {
	private long id;
	private String name;
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

	
}
