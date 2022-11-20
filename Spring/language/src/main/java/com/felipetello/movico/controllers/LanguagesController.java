package com.felipetello.movico.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.felipetello.movico.models.Language;
import com.felipetello.movico.services.LanguageService;

//... Sentencias import removidas para resumir
@Controller
public class LanguagesController {
	 private final LanguageService languageService;
	 
	 public LanguagesController(LanguageService languageService) {
	     this.languageService = languageService;
	 }
	 
	 @RequestMapping("/language")
	 public String index(Model model,@ModelAttribute("language") Language language) {
	     List<Language> languages = languageService.allLanguages();
	     model.addAttribute("languages", languages);
	     return "index.jsp";
	 }
	 
	 //@RequestMapping("/language/new")
	 //public String newBook(@ModelAttribute("book") Book book) {
		// return "new.jsp";
	 //}
	 
	 //Añadir cancion
	 @RequestMapping(value="/language", method= RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		 if (result.hasErrors()) {
			 	return "index.jsp";
		 } 
		 else {
			 languageService.createLanguage(language);
			 return "redirect:language";
		 }
	 }
	 @RequestMapping("/language/{id}")
	 public String show(@PathVariable("id") Long id,Model model) {
		 Language language = languageService.findLanguage(id);
	//	 if (language==null) {
		 //		return "redirect:/language";
		 //	}
		 //	 else {
		 //		model.addAttribute("language",language);
		 //		return "show.jsp";
		 //	}
		 model.addAttribute("language", language);
		 return "show.jsp";
	 }
	 @RequestMapping("/language/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Language language = languageService.findLanguage(id);
	        model.addAttribute("language", language);
	        return "edit.jsp";
	    }
	    
	    @RequestMapping(value="/language/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	            languageService.updateLanguage(language);
	            return "redirect:/language";
	        }
	    }
	    @RequestMapping(value="/language/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        languageService.deleteLanguage(id);
	        return "redirect:/language";
	    }
}
