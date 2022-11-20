package com.felipetello.templateExamen.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends BaseModel{
	@NotBlank(message = "El campo Name no debe estar vacio")
	@Size( min = 5,max = 200,message = "El valor First Name debe ser entre 5 y 200 caracteres")
	private String name;
	@NotBlank
	@Email(message = "debe ingresar un Email valido")
	private String email;
	@NotBlank(message = "El campo password no debe estar vacio")
	@Size( min = 8,max = 200,message = "El valor Password debe ser entre 8 y 200 caracteres")
	private String password;
	@Transient
	private String passwordConfirmation;
	
/////////////////////////////////////////////////////////////////
	
	//@ManyToMany(fetch = FetchType.LAZY)
    //@JoinTable(
    //    name = "users_task", 
    //    joinColumns = @JoinColumn(name = "user_id"), 
    //    inverseJoinColumns = @JoinColumn(name = "task_id")
    //)     
    //private List<Task> tasks;
	
/////////////////////////////////////////////////////////////////
    
	@OneToMany(mappedBy="userAssignee", fetch = FetchType.LAZY)
	private List<Task> assignneTask = new ArrayList<>();
	
/////////////////////////////////////////////////////////////////
    
	@OneToMany(mappedBy="userCreator", fetch = FetchType.LAZY)
	private List<Task> creatorTask = new ArrayList<>();

/////////////////////////////////////////////////////////////////	
	
	public User() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public List<Task> getAssignneTask() {
		return assignneTask;
	}

	public void setAssignneTask(List<Task> assignneTask) {
		this.assignneTask = assignneTask;
	}

	public List<Task> getCreatorTask() {
		return creatorTask;
	}

	public void setCreatorTask(List<Task> creatorTask) {
		this.creatorTask = creatorTask;
	}
}
