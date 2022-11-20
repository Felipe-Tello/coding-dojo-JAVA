package com.saimon.dojooverflow.services;

import org.springframework.stereotype.Service;

import com.saimon.dojooverflow.models.Answer;
import com.saimon.dojooverflow.repositories.RepositorioBase;

@Service
public class AnswerService extends ServicioBase<Answer>{

	public AnswerService(RepositorioBase<Answer> repositorioBase) {
		super(repositorioBase);
	}
}
