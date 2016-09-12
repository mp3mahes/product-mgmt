package com.cubic.vo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.Size;
@XmlRootElement
public class PersonVO {

	private Long pk;
	
	@Size(min = 2, max = 18)
	private String firstName;
	@Size(min = 2, max = 18)
	private String lastName;

	public PersonVO() {
	}

	public PersonVO(Long pk, String firstName, String lastName) {
		super();
		this.pk = pk;
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
		return "PersonVO [pk=" + pk + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
