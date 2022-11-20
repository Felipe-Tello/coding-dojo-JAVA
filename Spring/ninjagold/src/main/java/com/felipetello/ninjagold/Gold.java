package com.felipetello.ninjagold;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Gold {
	
	Format formatofecha = new SimpleDateFormat("MMMM/dd HH:mm a");
	String fecha = formatofecha.format(new Date());
	Random numRandom = new Random();
	ArrayList<Object> historial = new ArrayList<>();
	
	@RequestMapping("/")
	public String main(HttpSession session) {
		if (session.getAttribute("oro")==null) {
			session.setAttribute("oro", 0);
		}
		return "index.jsp";
	}
	@RequestMapping(value = "/places", method = RequestMethod.POST)
	public String places(@RequestParam(value = "places", required = false) String places, HttpSession session) {
		
		if (places.equals("farm")) {
			int monedas = numRandom.nextInt(21-11)+11;
			int oro = (Integer) session.getAttribute("oro");
			oro = oro + monedas;
			session.setAttribute("oro", oro);
			session.setAttribute("historial", historial);
			historial.add("you entered a "+places+" and earned "+monedas+(fecha)+"\n");

		}
		else if(places.equals("cave")) {
			int monedas = numRandom.nextInt(11-4)+4;
			int oro = (Integer) session.getAttribute("oro");
			oro = oro + monedas;
			session.setAttribute("oro", oro);
			session.setAttribute("historial", historial);
			historial.add("you entered a "+places+" and earned "+monedas+(fecha)+"\n");
		}
		else if(places.equals("house")) {
			int monedas = numRandom.nextInt(6-1)+1;
			int oro = (Integer) session.getAttribute("oro");
			oro = oro + monedas;
			session.setAttribute("oro", oro);
			session.setAttribute("historial", historial);
			historial.add("you entered a "+places+" and earned "+monedas+(fecha)+"\n");
		}
		else if(places.equals("casino")) {
			int monedas = numRandom.nextInt(51+51)-51;
			int oro = (Integer) session.getAttribute("oro");
			session.setAttribute("historial", historial);
			if (monedas > 0) {
				oro = oro + monedas;
				session.setAttribute("oro", oro);
				historial.add("you entered a "+places+" and earned "+monedas+" "+(fecha)+"\n");
			}
			else {
				oro = oro + monedas;
				session.setAttribute("oro", oro);
				historial.add("you entered a "+places+" and losted "+monedas+" "+(fecha)+"\n");
			}
			
		}
		return "redirect:/";		 
	}

}
