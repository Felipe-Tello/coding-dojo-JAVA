package com.felipetello.dojoOverflow.services;

import org.springframework.stereotype.Service;

import com.felipetello.dojoOverflow.models.Answer;
import com.felipetello.dojoOverflow.models.Question;
import com.felipetello.dojoOverflow.repositories.AnswerRespository;
import com.felipetello.dojoOverflow.repositories.BaseRepository;

@Service
public class AnswerService extends BaseService<Answer>{
	
	private final AnswerRespository answerRespository;

	public AnswerService(BaseRepository<Answer> baseRepository,AnswerRespository answerRespository) {
		super(baseRepository);
		this.answerRespository = answerRespository;
	}
	public void addAnswer(Answer answer, Question question){      
        answer.setQuestion(question);
        answerRespository.save(answer);
    }
}
