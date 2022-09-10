package main.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVo {

	@NotBlank(message = "Reqired")
	private String email;
	
	@NotBlank(message = "Reqired")
	private String password;
}
