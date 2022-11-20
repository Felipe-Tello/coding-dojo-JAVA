package com.felipetello.repasoexamen.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;


@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
//uniqueConstraints = @UniqueConstraint(columnNames = "email")
public class User extends BaseModel{
	@NotBlank(message = "El campo First Name no debe estar vacio")
	@Size( min = 5,max = 200,message = "El valor First Name debe ser entre 5 y 200 caracteres")
	private String firstName;
	@NotBlank(message = "El campo Last Name no debe estar vacio")
	@Size( min = 5,max = 200,message = "El valor Last Name debe ser entre 5 y 200 caracteres")
	private String lastName;
	@NotBlank
	@Email(message = "debe ingresar un Email valido")
	private String email;
	@NotBlank(message = "El campo Location no debe estar vacio")
	@Size( min = 5,max = 200,message = "El valor Location debe ser entre 5 y 200 caracteres")
	private String location;
	@NotBlank(message = "El campo State no debe estar vacio")
	private String state;
	@NotBlank(message = "El campo password no debe estar vacio")
	@Size( min = 5,max = 200,message = "El valor Password debe ser entre 5 y 200 caracteres")
	private String password;
	@Transient
	private String passwordConfirmation;
	
/////////////////////////////////////////////////////////////////
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_events", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )     
    private List<Event> events = new ArrayList<>();
    
/////////////////////////////////////////////////////////////////
    
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Message> messages = new ArrayList<>();
	
/////////////////////////////////////////////////////////////////
    
	@OneToMany(mappedBy="host", fetch = FetchType.LAZY)
	private List<Event> hostedEvents = new ArrayList<>();
	
/////////////////////////////////////////////////////////////////
	
	public User() {
	}
	
	public User(String firstName, String lastName, String email, String location, String state, String password,
			String passwordConfirmation, List<Event> events, List<Message> messages, List<Event> hostedEvents) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		this.state = state;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.events = events;
		this.messages = messages;
		this.hostedEvents = hostedEvents;
	}
/////////////////////////////////////////////////////////////////
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Event> getHostedEvents() {
		return hostedEvents;
	}

	public void setHostedEvents(List<Event> hostedEvents) {
		this.hostedEvents = hostedEvents;
	}
}
