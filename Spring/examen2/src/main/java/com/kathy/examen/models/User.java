package com.kathy.examen.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends Base{
    private int rol;
    @NotBlank(message = "El campo First Name no debe estar vacio")
	@Size( min = 3,max = 100,message = "El valor First Name debe ser entre 3 y 100 caracteres")
	private String firstName;

    @NotBlank(message = "El campo First Name no debe estar vacio")
	@Size( min = 3,max = 100,message = "El valor First Name debe ser entre 3 y 100 caracteres")
	private String lastName;

	@NotBlank
	@Email(message = "Debe ingresar un Email valido")
	private String email;

	@NotBlank(message = "El campo password no debe estar vacio")
	@Size( min = 8,max = 100,message = "El valor Password debe ser entre 8 y 100 caracteres")
	private String password;

	@Transient
	private String passwordConfirmation;

    private Date entrega;
    // -------------------

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Pack> usersPacks = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pack_id")
    private Pack pack;

    public User() {
    }

    public User(int rol, String firstName, String lastName, String email, String password, String passwordConfirmation, Date entrega, List<Pack> usersPacks, Pack pack) {
        this.rol = rol;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.entrega = entrega;
        this.usersPacks = usersPacks;
        this.pack = pack;
    }


    public int getRol() {
        return rol;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public void setRol(int rol) {
        this.rol = rol;
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

    public List<Pack> getUsersPacks() {
        return usersPacks;
    }

    public void setUsersPacks(List<Pack> usersPacks) {
        this.usersPacks = usersPacks;
    }

    public void setDueDate(Date d) {
    }

}
