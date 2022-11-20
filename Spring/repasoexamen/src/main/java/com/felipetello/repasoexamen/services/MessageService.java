package com.felipetello.repasoexamen.services;

import org.springframework.stereotype.Service;

import com.felipetello.repasoexamen.models.Message;
import com.felipetello.repasoexamen.repositories.BaseRepository;
import com.felipetello.repasoexamen.repositories.MessageRepository;

@Service
public class MessageService extends BaseService<Message> {
	
	private final MessageRepository messageRepository;

	public MessageService(BaseRepository<Message> baseRepository, MessageRepository messageRepository) {
		super(baseRepository);
		this.messageRepository = messageRepository;
	}
}
