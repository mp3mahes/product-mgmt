package com.cubic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.entity.PersonEntity;

@Repository
public interface PersonRepository 
extends CrudRepository<PersonEntity, Long> {
	
	@Query("select p from PersonEntity p where UPPER(p.firstName) like UPPER(?1) OR UPPER(p.lastName) like UPPER(?2)")
	List<PersonEntity> searchPersons(final String firstName, final String lastName);
	
	@Query("select p from PersonEntity p")
	List<PersonEntity> getAllPersons();
	
	@Query(nativeQuery = true, value = "select count(*) from PERSON")
	int getPersonCount();

	@Query(nativeQuery = true, value = "select PERSON_ID, FIRST_NAME,LAST_NAME from Person")
	List<Object[]> getPersons();	
	
}
