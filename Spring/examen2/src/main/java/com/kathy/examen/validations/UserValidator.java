package com.kathy.examen.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kathy.examen.models.User;

@Component
public class UserValidator implements Validator{
    
    public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 User user = (User) target;

	     if (!user.getPasswordConfirmation().equals(user.getPassword())) {
	     errors.rejectValue("passwordConfirmation", "Match");
	     }   
	}
}
