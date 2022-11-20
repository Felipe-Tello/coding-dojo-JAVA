package com.felipetello.templateExamen.models;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
//uniqueConstraints = @UniqueConstraint(columnNames = "email")
public class User extends BaseModel{
	@NotBlank(message = "El campo First Name no debe estar vacio")
	@Size( min = 5,max = 200,message = "El valor First Name debe ser entre 5 y 200 caracteres")
	private String firstName;
	@NotBlank(message = "El campo Last Name no debe estar vacio")
	@Size( min = 5,max = 200,message = "El valor Last Name debe ser entre 5 y 200 caracteres")
	private String lastName;
	@NotBlank
	@Email(message = "debe ingresar un Email valido")
	private String email;
	@NotBlank(message = "El campo Location no debe estar vacio")
	@Size( min = 5,max = 200,message = "El valor Location debe ser entre 5 y 200 caracteres")
	private String location;
	@NotBlank(message = "El campo State no debe estar vacio")
	private String state;
	@NotBlank(message = "El campo password no debe estar vacio")
	@Size( min = 5,max = 200,message = "El valor Password debe ser entre 5 y 200 caracteres")
	private String password;
	@Transient
	private String passwordConfirmation;
	
/////////////////////////////////////////////////////////////////
	

    
/////////////////////////////////////////////////////////////////
    

	
/////////////////////////////////////////////////////////////////
    
	
	
/////////////////////////////////////////////////////////////////
	
	public User() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
}
