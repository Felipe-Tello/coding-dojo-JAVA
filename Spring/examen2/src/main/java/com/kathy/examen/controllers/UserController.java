package com.kathy.examen.controllers;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kathy.examen.models.Pack;
import com.kathy.examen.models.User;
import com.kathy.examen.services.PackageService;
import com.kathy.examen.services.UserService;
import com.kathy.examen.validations.UserValidator;

@Controller
public class UserController {
    private final UserService userService;
	private final UserValidator userValidator;
	private final PackageService packageService;

    public UserController(UserService userService, UserValidator userValidator, PackageService packageService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.packageService = packageService;
	}

    @GetMapping("/")
	public String registerForm(@ModelAttribute("user") User user) {
		return "loginRegister.jsp";
	}

    @PostMapping("/")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "loginRegister.jsp";
        }
        if (userService.emailExist(user.getEmail())) {
            FieldError error = new FieldError("email", "email", "El email ingresado ya se encuentra registrado");
            result.addError(error);
            return "loginRegister.jsp";
        }
        if (userService.count() > 0){
			user.setRol(2);
			Pack package1 = packageService.findPackage("Basic");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, 30);
			Date d=c.getTime();
			user.setDueDate(d);
			user.setPack(package1);
			userService.registerUser(user);
			session.setAttribute("idUser", user.getId());
			return "redirect:/users/" + user.getId();
		}
		Pack package1 = new Pack();
		package1.setName("Basic");
		package1.setCost(10.0);
		package1.setAvailable(true);
		user.setRol(1);
		userService.registerUser(user);
		package1.setUser(user);
		packageService.crear(package1);
		session.setAttribute("idUser", user.getId());
		return "redirect:/packages";

	}
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		Boolean authenticated = userService.authenticateUser(email, password);
		if (authenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("idUser", u.getId());
			if(u.getRol() == 1){
				return "redirect:/packages";
			}
			else{
				return "redirect:/users/" + u.getId();
			}
		
		}else {
			session.setAttribute("error", "error. Intentalo de nuevo");
			return "redirect:/";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
