package com.felipetello.dojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felipetello.dojoOverflow.repositories.BaseRepository;
@Service
public abstract class BaseService <T> {
	private final BaseRepository<T> baseRepository;

	public BaseService(BaseRepository<T> baseRepository) {
		this.baseRepository = baseRepository;
	}
	
	public List<T> allThings(){
		return baseRepository.findAll();
	}
	public T saveThing(T c) {
		return baseRepository.save(c);
	}
	public T findThingById(Long id) {
		Optional<T> thingOptional = baseRepository.findById(id);
		if(thingOptional.isPresent()) {
			return thingOptional.get();
		}
		else {
			return null;
		}
	}
	
	
}
