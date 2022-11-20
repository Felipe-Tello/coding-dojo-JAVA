package com.felipetello.empleadosgerentes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felipetello.empleadosgerentes.models.Employees;
import com.felipetello.empleadosgerentes.repositories.EmployeesRepository;
@Service
public class EmployeesService {
	private final EmployeesRepository employeesRepository;
	
	public EmployeesService (EmployeesRepository employeesRepository) {
		this.employeesRepository = employeesRepository;
	}

	public List<Employees> allEmployees(){
		return employeesRepository.findAll();
	}
	public Employees createEmployees(Employees s) {
		return employeesRepository.save(s);
	}
	public Employees findEmployees(Long id) {
		Optional<Employees> optionalNinja = employeesRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
}
