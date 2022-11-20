package com.felipetello.relationships.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felipetello.relationships.models.License;
import com.felipetello.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	//Devolivendo todas las canciones.
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
	//Creando una cancion.
	public License createLicense(License s) {
		return licenseRepository.save(s);
	}
	//Obteniendo la información de un libro
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		}
		else {
			return null;
		}
	}
	public License updateLicense(License license) {
		return licenseRepository.save(license);
	}
	public void deleteLincense(Long id) {
		licenseRepository.deleteById(id);
	}
}
