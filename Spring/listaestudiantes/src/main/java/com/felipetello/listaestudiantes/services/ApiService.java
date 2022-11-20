package com.felipetello.listaestudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felipetello.listaestudiantes.models.Contact;
import com.felipetello.listaestudiantes.models.Student;
import com.felipetello.listaestudiantes.repositories.ContactRepository;
import com.felipetello.listaestudiantes.repositories.StudentRepository;

@Service
public class ApiService {
	private final StudentRepository studentRepository;
	private final ContactRepository contactRepository;
	
	public ApiService(StudentRepository studentRepository, ContactRepository contactRepository) {
		this.studentRepository = studentRepository;
		this.contactRepository = contactRepository;
	}
	public List<Student> allStudent() {
        return studentRepository.findAll();
    }
	public List<Contact> allContact() {
        return contactRepository.findAll();
    }
    public Student createStudent(Student b) {
        return studentRepository.save(b);
    }
    public Contact createContact(Contact b) {
        return contactRepository.save(b);
    }
    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }
    public Contact findContact(Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if(optionalContact.isPresent()) {
            return optionalContact.get();
        } else {
            return null;
        }
    }
}
