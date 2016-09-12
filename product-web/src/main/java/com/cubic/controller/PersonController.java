package com.cubic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cubic.service.PersonService;
import com.cubic.vo.PersonVO;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService ps;

	@RequestMapping(value = "/personform", method = RequestMethod.GET)
	public ModelAndView displayPersonForm() {
		PersonVO person = new PersonVO();
		person.setFirstName("Mahesh");
		person.setLastName("Pandeya");
		ModelAndView result = new ModelAndView("personform", "person", person);
		return result;
	}

	@RequestMapping(value = "/saveperson", method = RequestMethod.POST)
	public ModelAndView saveperson(@Valid @ModelAttribute("person") PersonVO person, BindingResult bindingResult) {

		ModelAndView result = new ModelAndView("personform");
		if (bindingResult.hasErrors()) {
			result.addObject("resultmsg", "Error has occured! ");
		}

		else {
			person = ps.savePerson(person);
			result.addObject("resultmsg", "The data is saved !");
		}

		return result;
	}

}
