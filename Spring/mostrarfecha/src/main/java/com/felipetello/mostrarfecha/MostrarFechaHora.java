package com.felipetello.mostrarfecha;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MostrarFechaHora {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model modelo) {
		SimpleDateFormat FormatoFecha= new SimpleDateFormat("EEEE, dd MMMM yyyy");
		Date fechaHoy= new Date();
		String Hoy = FormatoFecha.format(fechaHoy);
		modelo.addAttribute("miFecha",Hoy);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model modelo) {
		SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm a");
		Date hora = new Date();
		String horaHoy = formatoHora.format(hora);
		modelo.addAttribute("miHora", horaHoy);
		return "time.jsp";
	}
	
	
}


















