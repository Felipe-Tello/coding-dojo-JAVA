package com.felipetello.contador;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Contador {
	@RequestMapping("/")
    public String index(HttpSession session){
		if(session.getAttribute("contador")== null) {
			session.setAttribute("contador", 0);
		}
        Integer contador = (Integer) session.getAttribute("contador");
        contador += 1;
        session.setAttribute("contador", contador);
		return "index.jsp";

	}
	@RequestMapping("/contador")
	public String contador() {
		return "contador.jsp";
	}
}
