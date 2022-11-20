package com.felipetello.dojoOverflow.repositories;

import java.util.Optional;

import com.felipetello.dojoOverflow.models.Tag;

public interface TagRepository extends BaseRepository<Tag>{
	Optional<Tag> findBySubject(String subject);
}
