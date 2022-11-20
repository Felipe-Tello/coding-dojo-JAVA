package com.felipetello.listaestudiantes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.felipetello.listaestudiantes.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
	 List<Contact> findAll();
}
