package com.cubic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cubic.entity.PersonEntity;
import com.cubic.exception.RecordNotFoundException;
import com.cubic.mapper.PersonMapper;
import com.cubic.repo.PersonRepository;
import com.cubic.vo.PersonVO;

@Service
public class PersonServiceImpl 
implements PersonService {

	@Autowired
	private PersonMapper mapper;

	@Autowired
	private PersonRepository repo;

	@Override
	public PersonVO savePerson(PersonVO vo) {
		validateRecord(vo);
		PersonEntity entity = mapper.mapToPersonEntity(vo);
		repo.save(entity);
		vo.setPk(entity.getPk());
		return vo;
	}

	private void validateRecord(PersonVO vo) {
		if(vo != null && vo.getPk() != null && !repo.exists(vo.getPk())) {
			throw new RecordNotFoundException("The records does not exists");
		}
	}

	@Override
	public PersonVO getPerson(Long id) {
		PersonVO result = null;
		if(id != null && repo.exists(id)) {
			PersonEntity entity = repo.findOne(id);
			result = mapper.mapToPersonVO(entity);
		}
		return result;
	}

	@Override
	public void removePerson(Long id) {
		if(id != null && repo.exists(id)) {
			repo.delete(id);
		}
	}

	@Override
	public List<PersonVO> getAllPersons() {
		List<PersonEntity> persons = repo.getAllPersons();
		return mapper.mapToPersonVO(persons);
	}

	@Override
	public List<PersonVO> search(final String firstName, final String lastName) {
		String fName = StringUtils.isEmpty(firstName)?"":firstName;
		String lName = StringUtils.isEmpty(lastName)?"":lastName;
		fName += "%";
		lName += "%";
		List<PersonEntity> persons = repo.searchPersons(fName, lName);
		return mapper.mapToPersonVO(persons);
	}

	@Override
	public int getPersonCount() {
		return repo.getPersonCount();
	}

	@Override
	public List<PersonVO> getPersons() {
		List<Object[]> persons = repo.getPersons();
		return mapper.mapObjectArrToPersonVO(persons);
	}



}
