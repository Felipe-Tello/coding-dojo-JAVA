package com.saimon.dojooverflow.services;

import org.springframework.stereotype.Service;

import com.saimon.dojooverflow.models.Question;
import com.saimon.dojooverflow.repositories.RepositorioBase;

@Service
public class QuestionService extends ServicioBase<Question>{

	public QuestionService(RepositorioBase<Question> repositorioBase) {
		super(repositorioBase);
	}
	
}
