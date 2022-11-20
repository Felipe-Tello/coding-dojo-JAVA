package com.felipetello.holahumano;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class humanonombre {
	@RequestMapping("/")
	public String humame(@RequestParam(value="s",required=false)String nombre) {
		if(nombre==null) {
			return "Hola Humano!"+ "\n" + "\n" + "bienvenido a SpringBoot!";
		}
		else {
			return "Hola "+ nombre + "!"+"\n"+"\n"+"bienvenido a SpringBoot!"; 
		}
	}
}
