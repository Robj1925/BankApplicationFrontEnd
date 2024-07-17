package com.fdmgroup.spring_demo.contact;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class ContactInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACT_INFO_GEN")
	@SequenceGenerator(name="CONTACT_INFO_ID_GEN", sequenceName="CONTACT_INFO_ID_SEQ")
	private long id;
	@Column(name="INFO_VALUE")
	private String value;
	private InfoType infoType;
	@ManyToOne
	@JoinColumn(name = "FK_CONTACT_ID")
	private Contact contact;
	
	public ContactInfo() {
		super();
	}
	public ContactInfo(String value, InfoType infoType, Contact contact) {
		super();
		this.value = value;
		this.infoType = infoType;
		this.contact = contact;
	}
	public ContactInfo(long id, String value, InfoType infoType, Contact contact) {
		super();
		this.id = id;
		this.value = value;
		this.infoType = infoType;
		this.contact = contact;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public InfoType getInfoType() {
		return infoType;
	}
	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, infoType, value);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactInfo other = (ContactInfo) obj;
		return id == other.id && infoType == other.infoType && Objects.equals(value, other.value);
	}
	@Override
	public String toString() {
		return "ContactInfo [id=" + id + ", value=" + value + ", infoType=" + infoType + "]";
	}
	

}
