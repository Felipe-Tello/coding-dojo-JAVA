package com.felipetello.repasoexamen.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menssages")
public class Message extends BaseModel{
	private String messageContent;
	
/////////////////////////////////////////////////////////////////	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
/////////////////////////////////////////////////////////////////	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="event_id")
	private Event event;
	
/////////////////////////////////////////////////////////////////
	
	public Message() {
		super();
	}

	public Message(String messageContent, User user, Event event) {
		super();
		this.messageContent = messageContent;
		this.user = user;
		this.event = event;
	}
/////////////////////////////////////////////////////////////////

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
