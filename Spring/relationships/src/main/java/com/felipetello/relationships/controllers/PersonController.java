package com.felipetello.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.felipetello.relationships.models.Person;

import com.felipetello.relationships.service.PersonService;

@Controller
public class PersonController {
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	@GetMapping("/persons/new")
	public String newperson(@ModelAttribute("person") Person person) {
		return "newperson.jsp";
	}
	@PostMapping("/persons/new")
	public String createperson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "newperson.jsp";
		}
		else {
			personService.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	@RequestMapping("/persons/{id}")
	public String details(@PathVariable("id") Long id,Model model) {
		Person person = personService.findPerson(id);
		if (person == null) {
            return "/persons/new";
        } else {
            model.addAttribute("person", person);
            return "/show.jsp";
        }
	}
}
