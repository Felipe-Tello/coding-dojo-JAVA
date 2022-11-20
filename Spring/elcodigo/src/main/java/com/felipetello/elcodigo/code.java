package com.felipetello.elcodigo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class code {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value= "/code", method=RequestMethod.POST)
	public String contra(@RequestParam(value = "password",required = false)String password,RedirectAttributes redireccionar) {
		if(password.equals("bushido")) {
			return "code.jsp";
		}
		else {
			redireccionar.addFlashAttribute("Error","You must train harder");
			return "redirect:/";
		}
	}
}
