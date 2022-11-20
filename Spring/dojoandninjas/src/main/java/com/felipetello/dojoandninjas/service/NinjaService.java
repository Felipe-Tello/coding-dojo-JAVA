package com.felipetello.dojoandninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felipetello.dojoandninjas.models.Ninja;
import com.felipetello.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	//Devolivendo todas las canciones.
	public List<Ninja> allNinja(){
		return ninjaRepository.findAll();
	}
	//Creando una cancion.
	public Ninja createNinja(Ninja s) {
		return ninjaRepository.save(s);
	}
	//Obteniendo la información de un libro
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
}
