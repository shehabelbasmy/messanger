package main.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

import main.annotation.FieldMatch;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>  {

	private String first,second,message;
	
	@Override
	public void initialize(FieldMatch fieldMatch) {
		first = fieldMatch.first();
		second =fieldMatch.second();
		message = fieldMatch.message();
	}
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean valid = true;
		try {

			final Object object1 = new BeanWrapperImpl().getPropertyValue(first);
			final Object object2 = new BeanWrapperImpl().getPropertyValue(second);
			valid = object1==null&&object2==null || object1!=null &&object1.equals(object2);
		} catch (Exception e) {
		}
		
		if (!valid) {
			context.buildConstraintViolationWithTemplate(message)
				.addPropertyNode(first)
				.addConstraintViolation()
				.disableDefaultConstraintViolation();
		}
		return valid;
	}

}
