package com.felipetello.templateExamen.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.felipetello.templateExamen.models.Task;
import com.felipetello.templateExamen.repositories.BaseRepository;
import com.felipetello.templateExamen.repositories.TaskRepository;

@Service
public class TaskService extends BaseService<Task>{

	private final TaskRepository taskRepository;
	
	public TaskService(BaseRepository<Task> baseRepository, TaskRepository taskRepository) {
		super(baseRepository);
		this.taskRepository = taskRepository;
	}

	public List<Task> listaDeTasksAsc(){
		return taskRepository.findAllByOrderByPriorityAsc();
	}
	public List<Task> listaDeTasksDesc(){
		return taskRepository.findAllByOrderByPriorityDesc();
	}
}
