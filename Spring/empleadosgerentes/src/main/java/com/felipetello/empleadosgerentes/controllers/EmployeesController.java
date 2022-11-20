package com.felipetello.empleadosgerentes.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.felipetello.empleadosgerentes.models.Employees;
import com.felipetello.empleadosgerentes.service.EmployeesService;

@Controller
public class EmployeesController {
	private final EmployeesService employeesService;
	
	public EmployeesController(EmployeesService employeesService) {
		this.employeesService = employeesService;
	}
	@GetMapping("/employees/{idManager}/new")
	public String newEmployee(@PathVariable("idManager")Long idManager,@ModelAttribute("employee") Employees employees,Model model) {
		Employees manager = employeesService.findEmployees(idManager);
		model.addAttribute("manager",manager);
		return "newemployees.jsp";
	}
	@PostMapping("/employees/{idManager}/new")
	public String createEmployee(@PathVariable("idManager")Long idManager,@Valid @ModelAttribute("employee") Employees employees, BindingResult result) {
		if (result.hasErrors()) {
			return "newemployees.jsp";
		}
		else {
			Employees manager = employeesService.findEmployees(idManager);
			employees.setManager(manager);
			employeesService.createEmployees(employees);
			return "redirect:/employees/"+idManager+"/new";
		}
	}
	@GetMapping("/managers/new")
	public String newManager(@ModelAttribute("employee") Employees employees) {
		return "newmanager.jsp";
	}
	@PostMapping("/managers/new")
	public String createManager(@Valid @ModelAttribute("employee") Employees employees, BindingResult result) {
		if (result.hasErrors()) {
			return "newmanager.jsp";
		}
		else {
			employeesService.createEmployees(employees);
			return "redirect:/employees/"+employees.getId()+"/new";
		}
	}
}
