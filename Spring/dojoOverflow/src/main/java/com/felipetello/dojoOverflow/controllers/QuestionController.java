package com.felipetello.dojoOverflow.controllers;

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

import com.felipetello.dojoOverflow.models.Answer;
import com.felipetello.dojoOverflow.models.Question;
import com.felipetello.dojoOverflow.models.Tag;
import com.felipetello.dojoOverflow.services.AnswerService;
import com.felipetello.dojoOverflow.services.QuestionService;
import com.felipetello.dojoOverflow.services.TagService;

@Controller
public class QuestionController {
	private final AnswerService answerService;
	private final QuestionService questionService;
	private final TagService tagService;
	
	public QuestionController(AnswerService answerService, QuestionService questionService, TagService tagService) {
		this.answerService = answerService;
		this.questionService = questionService;
		this.tagService = tagService;
	}
	
	@GetMapping("/questions")
	public String dashboard(@ModelAttribute("question")Question question,Model model) {
		List<Question> questions = questionService.allThings();
		model.addAttribute("questions", questions);
		return "dashboard.jsp";
	}
	@GetMapping("/questions/new")
	public String question(@ModelAttribute("question")Question question) {
		return "createquestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String newQuestion(@RequestParam("tag")String tag,@Valid @ModelAttribute("question")Question question, BindingResult result) {
		if (result.hasErrors()) {
			return "createquestion.jsp";
		}
		else {
			questionService.saveThing(question);
			String[] etiqueta = tag.split(",");
			for (String string : etiqueta) {
				string = string.trim();
				string = string.toLowerCase();
				if (tagService.findTag(string)== null) {
					Tag tagNuevo = new Tag(string);
					tagService.saveThing(tagNuevo);
				}
				question.getTags().add(tagService.findTag(string));
			}
			questionService.saveThing(question);
			return "redirect:/questions";
		}
	}
	@GetMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id")Long id,@ModelAttribute("answer") Answer answer, Model model) {
		Question question = questionService.findThingById(id);
		if (question == null) {
			return "redirect:/questions";
		}
		else {
			List<Tag> tags = question.getTags();
			List<Answer> answers = question.getAnswers();
			model.addAttribute("question", question);
			model.addAttribute("tags", tags);
			model.addAttribute("answers", answers);
			return "showquestion.jsp";
		}
	}
	@PostMapping("/questions/{questionid}")
	public String Showquestion(@Valid @ModelAttribute("answer")Answer answer,@PathVariable("questionid")Long questionid, BindingResult result) {
		Question question = questionService.findThingById(questionid);
		if (result.hasErrors()) {
			return "showquestion.jsp";
		}
		else {
			answerService.addAnswer(answer, question);
			answer = answerService.saveThing(answer);
			return "redirect:/questions/"+questionid;
		}
	}
}
