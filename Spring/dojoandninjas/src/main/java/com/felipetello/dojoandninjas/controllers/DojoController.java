package com.felipetello.dojoandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.felipetello.dojoandninjas.models.Dojo;
import com.felipetello.dojoandninjas.service.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoService;

	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	@GetMapping("/dojos/new")
	public String newdojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String createdojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newninja.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	@RequestMapping("/dojos/{id}")
	public String details(@PathVariable("id") Long id,Model model) {
		Dojo dojo = dojoService.findDojo(id);
		if (dojo == null) {
			return "/dojos/new";
		} else {
			model.addAttribute("dojo", dojo);
			return "location.jsp";
		}
	}
}
