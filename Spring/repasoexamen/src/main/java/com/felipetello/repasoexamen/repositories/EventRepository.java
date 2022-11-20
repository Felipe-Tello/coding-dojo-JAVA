package com.felipetello.repasoexamen.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.felipetello.repasoexamen.models.Event;

@Repository
public interface EventRepository extends BaseRepository<Event>{
	List<Event> findByStateNotContaining(String state);
	List<Event> findByStateContaining(String state);
}
