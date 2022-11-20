package com.felipetello.templateExamen.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;


@Entity
@Table(name = "tasks")
public class Task extends BaseModel{
	@NotNull()
	@NotBlank(message = "the task not must be null")
	@Size(min = 5 ,max = 50, message = "el mensaje de tener entre 5 y 50 caracteres")
	private String taskName;
	@NotNull
	private Integer priority;


/////////////////////////////////////////////////////////////////////////////////////

	//@ManyToMany(fetch = FetchType.LAZY)
	//@JoinTable(
	//    name = "users_events", 
	//    joinColumns = @JoinColumn(name = "event_id"), 
	//    inverseJoinColumns = @JoinColumn(name = "user_id")
	//)     
	//private List<User> users;

/////////////////////////////////////////////////////////////////////////////////////
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userAssignee_id")
	private User userAssignee;
	
/////////////////////////////////////////////////////////////////////////////////////
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userCreator_id")
	private User userCreator;

/////////////////////////////////////////////////////////////////////////////////////	
	
	public Task() {
	}
	
	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public User getUserAssignee() {
		return userAssignee;
	}

	public void setUserAssignee(User userAssignee) {
		this.userAssignee = userAssignee;
	}

	public User getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(User userCreator) {
		this.userCreator = userCreator;
	}
	
}

	