package com.cubic.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloRest {
	
	@GET
	public String sayHelloWorld() {
		return "Hello World !";
	}	
	
	@GET
	@Path("/welcome")
	public String welcome() {
		return "Welcome to rest web services";
	}
}
