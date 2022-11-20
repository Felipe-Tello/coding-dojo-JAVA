package com.felipetello.listaestudiantes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.felipetello.listaestudiantes.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	 List<Student> findAll();
}
