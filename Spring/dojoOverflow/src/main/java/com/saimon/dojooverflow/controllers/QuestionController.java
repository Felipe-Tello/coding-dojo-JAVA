package com.saimon.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saimon.dojooverflow.models.Answer;
import com.saimon.dojooverflow.models.Question;
import com.saimon.dojooverflow.models.Tag;
import com.saimon.dojooverflow.services.AnswerService;
import com.saimon.dojooverflow.services.QuestionService;
import com.saimon.dojooverflow.services.TagService;

@Controller
public class QuestionController {
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
	
	public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
		this.questionService = questionService;
		this.tagService = tagService;
		this.answerService = answerService;
	}

	@GetMapping("/questions")
	public String dashboard(Model model, @ModelAttribute("question")Question question){
		List<Question> questions = questionService.listado();
		model.addAttribute("questions", questions);
		return "/questions/dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String questions(@ModelAttribute("question")Question question) {
		return "/questions/question.jsp";
	}
	
	@PostMapping("/questions/new")
	public String newQuestions(@Valid @ModelAttribute("question")Question question,
			BindingResult result,
			@RequestParam(value = "tag")String tag) {
		if (result.hasErrors()) {
			return "/questions/question.jsp";
		}else {
			questionService.guardar(question);
			String[] tags = tag.split(",");
			for (String string : tags) {
				string = string.trim();
				if (tagService.findTag(string) == null) {
					string.toLowerCase();
					Tag tagNew = new Tag(string);
					tagService.guardar(tagNew);
				}
				question.setTags(tagService.findTag(string));
			}
			questionService.guardar(question);
			return "redirect:/questions";
		}
	}
	
	@GetMapping("/questions/{id}")
	public String questionShow(@PathVariable("id")Long id,
			Model model,
			@ModelAttribute("answer")Answer answer) {
		Question question2 = questionService.buscarPorID(id);
		if (question2 == null) {
			return "redirect:/questions/new";
		}else {
			List<Tag> tags = question2.getTags();
			List<Answer> answers = question2.getAnswers();
			model.addAttribute("answers", answers);
			model.addAttribute("tags", tags);
			model.addAttribute("question", question2);
			return "/questions/answers.jsp";
		}
	}
	
	@PostMapping("/questions/{id}")
	public String answer(@Valid @ModelAttribute("answer")Answer answer,
			BindingResult result,
			@PathVariable("id")Long id) {
		Question question = questionService.buscarPorID(id);
		if (result.hasErrors()) {
			return "/questions/answer.jsp";
		}else {
			answer = answerService.guardar(answer);
			answer.setQuestion(question);
			answerService.guardar(answer);
			return "redirect:/questions/"+question.getId();
		}
	}
}