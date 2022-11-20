 package com.felipetello.repasoexamen.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.felipetello.repasoexamen.models.Event;
import com.felipetello.repasoexamen.models.Message;
import com.felipetello.repasoexamen.models.User;
import com.felipetello.repasoexamen.services.EventService;
import com.felipetello.repasoexamen.services.MessageService;
import com.felipetello.repasoexamen.services.UserService;

@Controller
public class EventController {
	
	private final EventService eventService;
	private final MessageService messageService;
	private final UserService userService;
	
	public EventController(EventService eventService, MessageService messageService, UserService userService) {
		this.eventService = eventService;
		this.messageService = messageService;
		this.userService = userService;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/events")
	public String eventTable( HttpSession session,Model model,@ModelAttribute("modeloEvent")Event event) {
		if (session.getAttribute("idU") == null) {
			return "redirect:/";
		}
		else {
			User user = userService.findThingById((Long) session.getAttribute("idU"));
			List<Event> eventosCercanos = eventService.closeEvent(user.getState());
			List<Event> eventosNoCercanos = eventService.otherEvent(user.getState());
			model.addAttribute("eventosCercanos", eventosCercanos);
			model.addAttribute("eventosNoCercanos", eventosNoCercanos);
			model.addAttribute("usuario", user);
			return "eventTable.jsp";
		}
	}
	@PostMapping("/events")
	public String eventTable(@Valid @ModelAttribute("modeloEvent")Event event, BindingResult result, HttpSession session,Model model) {
		User user = userService.findThingById((Long) session.getAttribute("idU"));
		if (result.hasErrors()) {
			List<Event> eventosCercanos = eventService.closeEvent(user.getState());
			List<Event> eventosNoCercanos = eventService.otherEvent(user.getState());
			model.addAttribute("eventosCercanos", eventosCercanos);
			model.addAttribute("eventosNoCercanos", eventosNoCercanos);
			model.addAttribute("usuario", user);
			return "eventTable.jsp";
		}
		else {
			List<Event> listaEventos = user.getEvents();
			listaEventos.add(event);
			eventService.addHostOrUser(event, user);
			eventService.createOrUpdateThing(event);
			return "redirect:/events";
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/events/{id}")
	public String showEvent(@PathVariable("id")Long id, @ModelAttribute("modeloMessage")Message message,Model model,HttpSession session) {
		if (session.getAttribute("idU") == null) {
			return "redirect:/";
		}
		else {
			Event evento = eventService.findThingById(id);
			List<User> listadeUsers = evento.getUsers();
			List<Message> listaMessage = evento.getMessages();
			String dataString ="";
			for (Message message2 : listaMessage) {
				dataString += message2.getUser().getFirstName() +": "+message2.getMessageContent()+ "\n"+"-------------------------------"+"\n";
			}
			model.addAttribute("listadeUsers", listadeUsers);
			model.addAttribute("data", dataString);
			model.addAttribute("eventoPorId", evento);
			return "showEvent.jsp";
		}
	}
	@PostMapping("/events/{id}")
	public String showEvent(@Valid@ModelAttribute("modeloMessage")Message message, BindingResult result, HttpSession session, @PathVariable("id")Long id,Model model) {
		User user = userService.findThingById((Long) session.getAttribute("idU"));
		Event evento = eventService.findThingById(id);
		if (result.hasErrors()) {
			List<User> listadeUsers = evento.getUsers();
			List<Message> listaMessage = evento.getMessages();
			String dataString ="";
			for (Message message2 : listaMessage) {
				dataString += message2.getUser().getFirstName() +": "+message2.getMessageContent()+ "\n"+"-------------------------------"+"\n";
			}
			model.addAttribute("listadeUsers", listadeUsers);
			model.addAttribute("data", dataString);
			model.addAttribute("eventoPorId", evento);
			return "showEvent.jsp";
		}
		else {
			message.setEvent(evento);
			message.setUser(user);
			messageService.createOrUpdateThing(message);	
			return "redirect:/events/"+id;
		}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@DeleteMapping("/events/{idEventDelete}")
	public String deleteEvent(@PathVariable("idEventDelete")Long idEventDelete) {
		Event evento = eventService.findThingById(idEventDelete);
		List<User> asistentesAlEvento = evento.getUsers();
		List<Message> listaMessages = evento.getMessages();
		for (User user : asistentesAlEvento) {
			user.getEvents().remove(evento);
			userService.createOrUpdateThing(user);
		}
		for (Message message : listaMessages) {
			messageService.deleteThing(message.getId());
		}
		eventService.deleteThing(idEventDelete);
		return "redirect:/events";
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/events/{idEvent}/edit")
    public String edit(@PathVariable("idEvent") Long idEvent, Model model,HttpSession session) {
        if (session.getAttribute("idU")== null) {
        	return "redirect:/";
		}
		else {
			Event editEvent = eventService.findThingById(idEvent);
	        model.addAttribute("modeloEvent", editEvent);
	        return "editEvent.jsp";
		}
    }
    
	@PutMapping("/events/{idEvent}/edit")
	public String update(@Valid @ModelAttribute("modeloEvent") Event event, BindingResult result,@PathVariable("idEvent") Long idEvent) {
		if (result.hasErrors()) {
			return "editEvent.jsp";
		} 
		else {
			Event eventoid = eventService.findThingById(idEvent);
			eventoid.setState(event.getState());
			eventoid.setLocation(event.getLocation());
			eventoid.setName(event.getName());
			eventoid.setDateEvent(event.getDateEvent());
			eventService.createOrUpdateThing(eventoid);
			return "redirect:/events";
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/events/{idEvent}/join")
	public String userJoin(@PathVariable("idEvent")Long id,HttpSession session) {
		User user = userService.findThingById((Long) session.getAttribute("idU"));
		Event evento = eventService.findThingById(id);
		evento.addAsistente(user);
		eventService.createOrUpdateThing(evento);
		return "redirect:/events";
	}
	@GetMapping("/events/{idEvent}/cancel")
	public String userCancel(@PathVariable("idEvent")Long id,HttpSession session) {
		User user = userService.findThingById((Long) session.getAttribute("idU"));
		Event evento = eventService.findThingById(id);
		List<User> asistentesAlEvento = evento.getUsers();
		asistentesAlEvento.remove(user);
		evento.setUsers(asistentesAlEvento);
		eventService.createOrUpdateThing(evento);
		return "redirect:/events";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
