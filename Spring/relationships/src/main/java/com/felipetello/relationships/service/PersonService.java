package com.felipetello.relationships.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felipetello.relationships.models.Person;
import com.felipetello.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	//Devolivendo todas las canciones.
	public List<Person> allPerson(){
		return personRepository.findAll();
	}
	//Creando una cancion.
	public Person createPerson(Person s) {
		return personRepository.save(s);
	}
	//Obteniendo la información de un libro
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		else {
			return null;
		}
	}
	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
}
