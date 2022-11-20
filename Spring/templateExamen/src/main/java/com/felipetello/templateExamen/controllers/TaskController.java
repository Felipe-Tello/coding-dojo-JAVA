package com.felipetello.templateExamen.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.felipetello.templateExamen.models.Task;
import com.felipetello.templateExamen.models.User;
import com.felipetello.templateExamen.services.TaskService;
import com.felipetello.templateExamen.services.UserService;

@Controller
public class TaskController {
	private final TaskService taskService;
	private final UserService userService;
	
	public TaskController(TaskService taskService, UserService userService) {
		this.taskService = taskService;
		this.userService = userService;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/tasks")
	public String mostrarTask(HttpSession session, Model model) {
		if (session.getAttribute("idU") == null) {
			return "redirect:/";
		}
		else {
			User user = userService.findThingById((Long) session.getAttribute("idU"));
			List<Task> listaTaskNormal = taskService.allThings();
			List<User> listaUsuarios = userService.allThings();
			model.addAttribute("listaT", listaTaskNormal);
			model.addAttribute("listaUsuarios", listaUsuarios);
			model.addAttribute("userActual", user);
			return "taskTable.jsp";
		}
	}
	@GetMapping("/tasks/asc")
	public String mostrarTaskAsc(HttpSession session, Model model) {
		User user = userService.findThingById((Long) session.getAttribute("idU"));
		if (session.getAttribute("idU") == null) {
			return "redirect:/";
		}
		else {
			List<Task> listaTareasAsc = taskService.listaDeTasksAsc();
			List<User> listaUsuarios = userService.allThings();
			model.addAttribute("listaUsuarios", listaUsuarios);
			model.addAttribute("listaT", listaTareasAsc);
			model.addAttribute("userActual", user);
			return "taskTable.jsp";
		}
	}
	@GetMapping("/tasks/desc")
	public String mostrarTaskDesc(HttpSession session, Model model) {
		User user = userService.findThingById((Long) session.getAttribute("idU"));
		if (session.getAttribute("idU") == null) {
			return "redirect:/";
		}
		else {
			List<Task> listaTareasDesc = taskService.listaDeTasksDesc();
			List<User> listaUsuarios = userService.allThings();
			model.addAttribute("listaUsuarios", listaUsuarios);
			model.addAttribute("listaT", listaTareasDesc);
			model.addAttribute("userActual", user);
			return "taskTable.jsp";
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/tasks/new")
	public String crearTask(@ModelAttribute("modelTask")Task task,HttpSession session,Model model) {
		User user = userService.findThingById((Long) session.getAttribute("idU"));
		//if (session.getAttribute("idU") == null) {
		//	return "redirect:/new";
		//}
		//else {
			List<User> listaUsuarios = userService.allThings();
			model.addAttribute("listaUsuarios", listaUsuarios);
			model.addAttribute("task", task);
			return "taskNew.jsp";
		//}
	}
	
	@PostMapping("/tasks/new")
	public String crearTask(@Valid @ModelAttribute("modelTask")Task task, BindingResult result,Model model,HttpSession session) {
		User user = userService.findThingById((Long) session.getAttribute("idU"));
		if (result.hasErrors()) {
			List<User> listaUsuarios = userService.allThings();
			model.addAttribute("task", task);
			model.addAttribute("listaUsuarios", listaUsuarios);
			return "taskNew.jsp";
		}
		else {
			Task taskNew = taskService.createOrUpdateThing(task);
			taskNew.setUserCreator(user);
			taskNew.setUserAssignee(task.getUserAssignee());
			taskService.createOrUpdateThing(taskNew);
			return "redirect:/tasks";
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/tasks/{taskIdS}")
	public String showTask(HttpSession session, Model model,@PathVariable("taskIdS")Long taskIdS) {
		User user = userService.findThingById((Long) session.getAttribute("idU"));
		if (session.getAttribute("idU") == null) {
			return "redirect:/";
		}
		else {
			Task task = taskService.findThingById(taskIdS);
			model.addAttribute("taskuno", task);
			model.addAttribute("actual", user);
			return "taskShow.jsp";
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/tasks/{taskId}/edit")
	public String editEvent(@PathVariable("taskId") Long taskId, Model model,HttpSession session,@ModelAttribute("modelTask")Task task) {
		if (session.getAttribute("idU") == null) {
			return "redirect:/";
		}
		User user = userService.findThingById((Long) session.getAttribute("idU"));
		Task task2 = taskService.findThingById(taskId);
		if(user.getId() != task2.getUserCreator().getId()){
			return "redirect:/tasks";
		}
		else {
			List<User> listaUsuarios = userService.allThings();
			Task taskEdit = taskService.findThingById(taskId);
			model.addAttribute("taskEdit", taskEdit);
			model.addAttribute("listaUsuarios", listaUsuarios);
			return "taskEdit.jsp";
		}
	}
	@PutMapping("/tasks/{taskId}/edit")
	public String editEvent(@Valid @ModelAttribute("modelTask") Task task, BindingResult result ,HttpSession session, @PathVariable("taskId")Long taskId, Model model) {
		if (result.hasErrors()) {
			Task taskEdit = taskService.findThingById(taskId);
			taskEdit.setTaskName(task.getTaskName());
			taskEdit.setPriority(task.getPriority());
			taskEdit.setUserAssignee(task.getUserAssignee());
			return "taskEdit";
		}
		else {
			Task taskEdit = taskService.findThingById(taskId);
			taskEdit.setTaskName(task.getTaskName());
			taskEdit.setPriority(task.getPriority());
			taskEdit.setUserAssignee(task.getUserAssignee());
			taskService.createOrUpdateThing(taskEdit);
			model.addAttribute("idTask", taskId);
			return "redirect:/tasks/"+taskId;
		}
	}
	@DeleteMapping("/tasks/{taskId}")
	public String deleteEvent(@PathVariable("taskId")Long taskId , HttpSession session) {
		Task task = taskService.findThingById(taskId);
		User user = userService.findThingById((Long) session.getAttribute("idU"));
		task.setUserCreator(null);
		task.setUserAssignee(null);
		taskService.deleteThing(taskId);
		return "redirect:/tasks";
	}
}
