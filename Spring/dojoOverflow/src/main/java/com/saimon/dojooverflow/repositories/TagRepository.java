package com.saimon.dojooverflow.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.saimon.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends RepositorioBase<Tag>{
	
	Optional<Tag> findBySubject(String subject);
}
