package com.felipetello.repasoexamen.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "events")
public class Event extends BaseModel{
	@NotBlank(message = "El campo Name no debe estar vacio")
	@Size( min = 2,max = 200,message = "El valor Name debe ser entre 2 y 200 caracteres")
	private String name;
	@Future(message = "debe ser una fecha futura")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateEvent;
	@NotBlank(message = "El campo Location no debe estar vacio")
	@Size( min = 5,max = 200,message = "El valor Location debe ser entre 5 y 200 caracteres")
	private String location;
	@NotBlank(message = "El campo State no debe estar vacio")
	private String state;
	
/////////////////////////////////////////////////////////////////
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_events", 
        joinColumns = @JoinColumn(name = "event_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )     
    private List<User> users;
    
/////////////////////////////////////////////////////////////////
    
	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
	private List<Message> messages;
	
/////////////////////////////////////////////////////////////////
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="host_id")
	private User host;
	
/////////////////////////////////////////////////////////////////
	
	public Event() {
	}
	
	public Event(String name, Date dateEvent, String location, String state, List<User> users,
			List<Message> messages, User host) {
		this.name = name;
		this.dateEvent = dateEvent;
		this.location = location;
		this.state = state;
		this.users = users;
		this.messages = messages;
		this.host = host;
	}
/////////////////////////////////////////////////////////////////

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}
	public void addAsistente(User asistente) {
		this.users.add(asistente);
	}
	
}
