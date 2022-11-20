package com.felipetello.encuesta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class formulario {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value = "result", method = RequestMethod.POST)
	public String result(
			@RequestParam(value = "name")String name,
			@RequestParam(value = "location")String location,
			@RequestParam(value = "favorite_language")String favorite_language,
			@RequestParam(value = "comment")String comment, Model modelo){
		modelo.addAttribute("name",name);
		modelo.addAttribute("location",location);
		modelo.addAttribute("favorite_language",favorite_language);
		modelo.addAttribute("comment",comment);
		return "result.jsp";
	}
}
