package com.felipetello.dojoOverflow.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felipetello.dojoOverflow.models.Tag;
import com.felipetello.dojoOverflow.repositories.BaseRepository;
import com.felipetello.dojoOverflow.repositories.TagRepository;

@Service
public class TagService extends BaseService<Tag>{

	private final TagRepository tagRepository;
	
	public TagService(BaseRepository<Tag> baseRepository,TagRepository tagRepository) {
		super(baseRepository);
		this.tagRepository = tagRepository;
	}
	public Tag findTag(String subject) {
		Optional<Tag> tagOptional = tagRepository.findBySubject(subject);
		if (tagOptional.isPresent()) {
			return tagOptional.get();
		}
		else {
			return null;
		}
	}
}
