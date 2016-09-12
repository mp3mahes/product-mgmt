package com.cubic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class PersonEntity {

	@Column(name = "PERSON_ID")
	@Id
	@SequenceGenerator(name = "personSeq", sequenceName = "PERSON_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "personSeq")
	private Long pk;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	public PersonEntity() {
	}

	public PersonEntity(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "PersonEntity [pk=" + pk + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
