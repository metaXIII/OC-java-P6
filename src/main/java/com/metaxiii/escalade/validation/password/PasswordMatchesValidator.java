package com.metaxiii.escalade.validation.password;

import com.metaxiii.escalade.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
	@Override
	public void initialize(final PasswordMatches constraintAnnotation) {
		//do nothing
	}

	@Override
	public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
		final UserDto user = (UserDto) obj;
		return user.getPassword().equals(user.getCheckPassword());
	}

}
