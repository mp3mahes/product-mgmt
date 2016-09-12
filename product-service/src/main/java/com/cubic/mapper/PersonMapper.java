package com.cubic.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubic.entity.PersonEntity;
import com.cubic.vo.PersonVO;

@Component
public class PersonMapper {

	public PersonVO mapToPersonVO(PersonEntity entity) {
		PersonVO result = null;
		if (entity != null) {
			result = new PersonVO();
			result.setFirstName(entity.getFirstName());
			result.setLastName(entity.getLastName());
			result.setPk(entity.getPk());
		}
		return result;
	}	
	
	public PersonEntity mapToPersonEntity(PersonVO vo) {
		PersonEntity result = null;
		if (vo != null) {
			result = new PersonEntity();
			result.setFirstName(vo.getFirstName());
			result.setLastName(vo.getLastName());
			result.setPk(vo.getPk());
		}

		return result;
	}

	
	public List<PersonVO> mapToPersonVO(List<PersonEntity> entities) {
		List<PersonVO> results = new ArrayList<PersonVO>();

		if (entities != null && !entities.isEmpty()) {
			for(PersonEntity entity:entities) {
				results.add(this.mapToPersonVO(entity));
			}
		}

		return results;
	}
	
	
	public List<PersonVO> mapObjectArrToPersonVO(List<Object[]> entities) {
		List<PersonVO> results = new ArrayList<PersonVO>();
		for(Object[] obj:entities) {
			Long pk = ((BigDecimal) obj[0]).longValue();
			results.add(new PersonVO(pk,
					((String) obj[1]),((String) obj[2])));
		}
		return results;
	}	
	
}
