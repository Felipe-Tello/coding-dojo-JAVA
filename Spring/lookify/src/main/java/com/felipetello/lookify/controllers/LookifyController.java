package com.felipetello.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.felipetello.lookify.models.Lookify;
import com.felipetello.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/dashboard")
	public String dashboard(Model model,@ModelAttribute("lookify") Lookify lookify) {
		List<Lookify> lookifies = lookifyService.allLookifies();
		model.addAttribute("lookifies",lookifies);
		return "dashboard.jsp";
	}
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("lookify") Lookify lookify) {
		return "new.jsp";
	}
	@PostMapping("/songs/new")
	public String create(@Valid @ModelAttribute("lookify")Lookify lookify, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		else {
			lookifyService.createLookify(lookify);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/song/{id}")
	public String details(@PathVariable("id") Long id,Model model) {
		Lookify lookify = lookifyService.findLookify(id);
		//model.addAttribute("lookify",lookify);
		//return "show.jsp";
		//if (lookify == null) {
        //    return "redirect:/dashboard";
        //} else {
            model.addAttribute("lookify", lookify);
            return "/show.jsp";
       // }
	}
	@DeleteMapping("/song/{id}")
	public String destroy(@PathVariable("id")Long id) {
		lookifyService.deleteLookify(id);
		return "redirect:/dashboard";
	}
	@GetMapping("/search")
	public String search(Model model, @RequestParam("artist")String artist) {
		List<Lookify> searchword = lookifyService.search(artist);
		model.addAttribute("searchword", searchword);
		model.addAttribute("artist", artist);
		return "search.jsp";
	}
	@GetMapping("/search/topTen")
	public String top(Model model) {
		List<Lookify> topdiez = lookifyService.top();
		model.addAttribute("top",topdiez);
		return "topten.jsp";
	}
}
