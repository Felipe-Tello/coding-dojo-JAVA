package com.felipetello.movico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felipetello.movico.models.Language;
import com.felipetello.movico.repositories.LanguageRepository;

@Service
public class LanguageService {
    //Agregando el book al repositorio como una dependencia
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    //Devolviendo todos los libros.
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    //Creando un libro.
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } 
        else {
            return null;
        }
    }
	public Language updateLanguage(Language language) {
		return languageRepository.save(language);
	}
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
		
	}
}