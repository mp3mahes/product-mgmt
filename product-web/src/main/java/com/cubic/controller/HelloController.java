package com.cubic.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hw")
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView result = new ModelAndView("welcome");
		result.addObject("message", "This is Spring MVC hello");
		return result;
	}

	@RequestMapping("/test")
	public ModelAndView test() {
		ModelAndView result = new ModelAndView("welcome");
		result.addObject("message", "This is test");
		return result;
	}

	@RequestMapping("/rt")
	public String redirectTest() {
		return "redirect:/hw/welcome";
	}

	// redirect: context is all gone
	// forward: server level, takes methods with it. the url on the top doesn't
	// change.

	@RequestMapping("/ft")
	public String forwardTest() {
		return "redirect:/hw/test";
	}

	// URL :
	// http://max-bro:9080/product-web/hw/qp?firstName=MAhesh&lastName=Pandeya
	@RequestMapping(value = "/qp", method = RequestMethod.GET)
	public ModelAndView sayHello(@RequestParam("firstName") final String firstName,
			@RequestParam("lastName") final String lastName) {
		ModelAndView result = new ModelAndView("welcome");
		result.addObject("message", "Hello " + firstName + ", " + lastName);
		return result;
	}

	// URL :
	// http://max-bro:9080/product-web/hw/qpmap?firstName=MAhesh&lastName=Pandeya
	@RequestMapping(value = "/qpmap", method = RequestMethod.GET)
	public ModelAndView sayHellomap(@RequestParam final Map<String, String> qpMap) {
		final String firstName = qpMap.get("firstName");
		final String lastName = qpMap.get("lastName");
		ModelAndView result = new ModelAndView("welcome");
		result.addObject("message", "Hello " + firstName + ", " + lastName);
		return result;
	}

	@RequestMapping(value = "/pp/{firstName}/{lastName}", method = RequestMethod.GET)
	public ModelAndView sayHelloPP(@PathVariable("firstName") final String firstName,
			@RequestParam("lastName") final String lastName) {
		ModelAndView result = new ModelAndView("welcome");
		result.addObject("message", "Hello " + firstName + ", " + lastName);
		return result;
	}

}
