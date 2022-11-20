package com.felipetello.parametros;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("/{direccion}")
	public String lugar(@PathVariable("direccion") String direccion) {
		if(direccion.equals("dojo")) {
			return "¡El Dojo es increíble!";
		}
		else if(direccion.equals("burbank-dojo")) {
			return "El Dojo Burbank está localizado al sur de California";
		}
		else if(direccion.equals("san-jose")) {
			return "El Dojo SJ es el cuartel general";
		}
		else return direccion;		
	}
}
