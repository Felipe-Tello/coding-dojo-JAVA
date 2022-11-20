package com.felipetello.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.felipetello.authentication.models.User;
import com.felipetello.authentication.services.UserService;
import com.felipetello.authentication.validator.UserValidator;


@Controller
public class Users {
	private final UserService userService;
	private final UserValidator userValidator;
 
 public Users(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

 @RequestMapping("/registration")
 public String registerForm(@ModelAttribute("user") User user) {
     return "registrationPage.jsp";
 }
 
 @RequestMapping("/login")
 public String login() {
     return "loginPage.jsp";
 }
 
 @RequestMapping(value="/registration", method=RequestMethod.POST)
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	 //si el resultado tiene errores, retornar a la página de registro (no se preocupe por las validaciones por ahora)
	 //si no, guarde el usuario en la base de datos, guarde el id del usuario en el objeto Session y redirija a /home
	 userValidator.validate(user, result);
	 if (result.hasErrors()) {
		return "registrationPage.jsp";
	}else {
		userService.registerUser(user);
		session.setAttribute("idU", user.getId());
		return "redirect:/home";
	}
 }
 
 @RequestMapping(value="/login", method=RequestMethod.POST)
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
//    Si el usuario está autenticado, guarde su id de usuario en el objeto Session
//    sino agregue un mensaje de error y retorne a la página de inicio de sesión.
	 Boolean authenticated = userService.authenticateUser(email, password);
	 if (authenticated) {
		User u = userService.findByEmail(email);
		session.setAttribute("idU", u.getId());
		return "redirect:/home";
	}else {
		model.addAttribute("error", "Usuario y/o Contraseña incorrectos. Por favor intente de nuevo");
		return "loginPage.jsp";
	}
 }
 
 @RequestMapping("/home")
 public String home(HttpSession session, Model model) {
     //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
	 Long idU = (Long) session.getAttribute("idU");
	 User user = userService.findUserById(idU);
	 model.addAttribute("user", user);
	 return "homePage.jsp";
 }
 @RequestMapping("/logout")
 public String logout(HttpSession session) {
     // invalidar la sesión
     // redireccionar a la página de inicio de sesión.
	 session.invalidate();
	 return "redirect:/login";
 }
}
