package com.felipetello.templateExamen.repositories;

import java.util.List;

import com.felipetello.templateExamen.models.Task;

public interface TaskRepository extends BaseRepository<Task>{
	List<Task> findAllByOrderByPriorityDesc();
	List<Task> findAllByOrderByPriorityAsc();
}
