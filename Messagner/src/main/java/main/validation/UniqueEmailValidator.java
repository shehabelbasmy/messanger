package main.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import lombok.AllArgsConstructor;
import main.annotation.UniqueEmail;
import main.dao.UserRepository;


@AllArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	private final UserRepository userRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return !userRepository.existsByEmail(value);
	}
}
