package main.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.annotation.FieldMatch;
import main.annotation.UniqueEmail;

@FieldMatch.list({@FieldMatch(first = "password",second = "confirmPassword")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupUserVo {

	@NotBlank(message = "Required")
	@UniqueEmail
	private String email;
	
	@NotBlank(message = "Required")
	private String password;
	@NotBlank(message = "Required")
	private String confirmPassword;
	
	private String lastName;
	private String firstName;
	private LocalDate birthDate;
}
