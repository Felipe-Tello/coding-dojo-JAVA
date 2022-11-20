package com.felipetello.listaestudiantes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipetello.listaestudiantes.models.Contact;
import com.felipetello.listaestudiantes.models.Student;
import com.felipetello.listaestudiantes.services.ApiService;

@RestController
public class ApiController {
	private final ApiService apiService;
	public ApiController(ApiService apiService) {
		this.apiService = apiService;
	}
	@RequestMapping("/api/students")
	public List<Student> index(){
		return apiService.allStudent();
	}
	@RequestMapping(value = "/api/students/create", method=RequestMethod.POST)
	public Student createStudent(
			@RequestParam(value="firstName")String firstName,
			@RequestParam(value = "lastName")String lastName,
			@RequestParam(value = "age") int age) {
		Student student = new Student(firstName, lastName, age);
		return apiService.createStudent(student);
	}
	@RequestMapping(value = "/api/contacts/create", method=RequestMethod.POST)
	public Contact createContact(
			@RequestParam(value="address")String address,
			@RequestParam(value ="city")String city,
			@RequestParam(value ="state") String state,
			@RequestParam(value = "student")Student student) {
		Contact contact = new Contact(address, city, state, student);
		return apiService.createContact(contact);
	}
}
