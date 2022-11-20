package com.felipetello.repasoexamen.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.felipetello.repasoexamen.models.User;
import com.felipetello.repasoexamen.services.UserService;
import com.felipetello.repasoexamen.validations.UserValidator;


@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;

	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

	@RequestMapping("/")
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
        else {
            User u = userService.registerUser(user);
            session.setAttribute("userId", u.getId());
            return "redirect:/events";
        }
	}
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		Boolean authenticated = userService.authenticateUser(email, password);
		if (authenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("idU", u.getId());
			return "redirect:/events";
		}else {
			//redirectAttributes.addFlashAttribute("error", "Usuario y/o Contraseña incorrectos. Por favor intente de nuevo");
			session.setAttribute("error", "Invalid Credentials. Please thy again.");
			return "redirect:/";
		}
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}