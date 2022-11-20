package com.felipetello.empleadosgerentes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.felipetello.empleadosgerentes.models.Employees;

public interface EmployeesRepository extends CrudRepository<Employees, Long>{
	List<Employees> findAll();
}
