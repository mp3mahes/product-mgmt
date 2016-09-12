package com.cubic.service;

import java.util.List;

import com.cubic.vo.PersonVO;

public interface PersonService {

	PersonVO savePerson(PersonVO vo);
	
	PersonVO getPerson(Long id);

	void removePerson(Long id);

	List<PersonVO> getAllPersons();
	
	List<PersonVO> getPersons();
	
	List<PersonVO> search(final String firstName, final String lastName);	
	
	int getPersonCount();

}
