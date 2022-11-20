package com.felipetello.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.felipetello.relationships.models.License;
import com.felipetello.relationships.models.Person;
import com.felipetello.relationships.service.LicenseService;
import com.felipetello.relationships.service.PersonService;


@Controller
public class LicenseController {
	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicenseController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	@GetMapping("/licenses/new")
	public String newlicense(@ModelAttribute("license") License license,Model model) {
		List<Person> persons = personService.allPerson();
		model.addAttribute("persons",persons);
		model.addAttribute("license",license);
		return "newlicense.jsp";
	}
	@PostMapping("/licenses/new")
	public String createlicense(@Valid @ModelAttribute("license")License license, BindingResult result) {
		if (result.hasErrors()) {
			return "newlicense.jsp";
		}
		else {
			licenseService.createLicense(license);
			Long idlicense1 = license.getId();
			String format = String.format("%06d", idlicense1);
			license.setNumber(format);
			licenseService.createLicense(license);
			return "redirect:/persons/"+license.getPerson().getId();
		}
	}
	
}
