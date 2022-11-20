package com.felipetello.dojoOverflow.services;

import org.springframework.stereotype.Service;

import com.felipetello.dojoOverflow.models.Question;
import com.felipetello.dojoOverflow.repositories.BaseRepository;

@Service
public class QuestionService extends BaseService<Question>{

	public QuestionService(BaseRepository<Question> baseRepository) {
		super(baseRepository);
	}
}
