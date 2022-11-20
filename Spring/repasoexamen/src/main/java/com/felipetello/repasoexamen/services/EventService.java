package com.felipetello.repasoexamen.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.felipetello.repasoexamen.models.Event;
import com.felipetello.repasoexamen.models.User;
import com.felipetello.repasoexamen.repositories.EventRepository;

@Service
public class EventService extends BaseService<Event>{
	
	private final EventRepository eventRepository;

	public EventService(EventRepository baseRepository) {
		super(baseRepository);
		this.eventRepository = baseRepository;
	}
	public void addHostOrUser(Event event, User host){      
        event.setHost(host);
        eventRepository.save(event);
    }
	
	public List<Event> closeEvent(String state) {
		return eventRepository.findByStateContaining(state);
	}
	public List<Event> otherEvent(String state) {
		return eventRepository.findByStateNotContaining(state);
	}
}
