package com.felipetello.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.felipetello.dojoandninjas.models.Dojo;
import com.felipetello.dojoandninjas.models.Ninja;
import com.felipetello.dojoandninjas.service.DojoService;
import com.felipetello.dojoandninjas.service.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;

	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	@GetMapping("/ninjas/new")
	public String newninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojo();
		model.addAttribute("dojos",dojos);
		model.addAttribute("ninja",ninja);
		return "newninja.jsp";
	}
	@PostMapping("/ninjas/new")
	public String createninja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "newninja.jsp";
		}
		else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
