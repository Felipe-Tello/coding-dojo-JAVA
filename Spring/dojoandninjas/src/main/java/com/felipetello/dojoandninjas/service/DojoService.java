package com.felipetello.dojoandninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felipetello.dojoandninjas.models.Dojo;
import com.felipetello.dojoandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	//Devolivendo todas las canciones.
	public List<Dojo> allDojo(){
		return dojoRepository.findAll();
	}
	//Creando una cancion.
	public Dojo createDojo(Dojo s) {
		return dojoRepository.save(s);
	}
	//Obteniendo la información de un libro
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
}
