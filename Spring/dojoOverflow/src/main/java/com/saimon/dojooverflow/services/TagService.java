package com.saimon.dojooverflow.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saimon.dojooverflow.models.Tag;
import com.saimon.dojooverflow.repositories.RepositorioBase;
import com.saimon.dojooverflow.repositories.TagRepository;

@Service
public class TagService extends ServicioBase<Tag>{
	private final TagRepository tagRepository;
	
	public TagService(RepositorioBase<Tag> repositorioBase, TagRepository tagRepository) {
		super(repositorioBase);
		this.tagRepository = tagRepository;
	}

	public Tag findTag(String subject) {
		Optional<Tag> optional = tagRepository.findBySubject(subject);
		if (optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
}
