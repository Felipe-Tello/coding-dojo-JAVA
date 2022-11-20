package com.felipetello.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felipetello.lookify.models.Lookify;
import com.felipetello.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	//Devolivendo todas las canciones.
	public List<Lookify> allLookifies(){
		return lookifyRepository.findAll();
	}
	//Creando una cancion.
	public Lookify createLookify(Lookify s) {
		return lookifyRepository.save(s);
	}
	//Obteniendo la información de un libro
	public Lookify findLookify(Long id) {
		Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
		if (optionalLookify.isPresent()) {
			return optionalLookify.get();
		}
		else {
			return null;
		}
	}
	public Lookify updateLookify(Lookify lookify) {
		return lookifyRepository.save(lookify);
	}
	public void deleteLookify(Long id) {
		lookifyRepository.deleteById(id);
	}
	public List<Lookify> search(String artist) {
		return lookifyRepository.findByArtistContaining(artist);
	}
	public List<Lookify> top(){
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
}
