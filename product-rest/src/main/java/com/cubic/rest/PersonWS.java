package com.cubic.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.service.PersonService;
import com.cubic.vo.PersonVO;

@Service
@Path("/ps")
public class PersonWS {
	
	@Autowired
	private PersonService personService;
	
	@POST
	@Path("/create")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response createPatients(final PersonVO person) {
		PersonVO result = personService.savePerson(person);
		ResponseBuilder rb = Response.ok().type(MediaType.APPLICATION_JSON).entity(result);
		return rb.build();
	}
	
}
