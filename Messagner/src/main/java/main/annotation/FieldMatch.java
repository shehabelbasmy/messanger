package main.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import main.validation.FieldMatchValidator;

@Documented
@Constraint(validatedBy = FieldMatchValidator.class)
@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMatch {

	Class<?>[] groups() default{};
	
	Class<? extends Payload> [] payload() default{};
	
	String first();
	String second();
	String message() default"Password Doesn't Match";
	
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.ANNOTATION_TYPE,ElementType.TYPE})
	@interface list{
		FieldMatch [] value();
	}
}
