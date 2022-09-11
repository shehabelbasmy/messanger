package main.controller;

import javax.validation.Valid;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import main.dto.SignupUserVo;
import main.service.UserServices;

@Controller
@AllArgsConstructor
public class SignupController {

	private final UserDetailsService userService ;

	@GetMapping("/signup")
	public ModelAndView signUp() {
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("/signup");
		modelAndView.addObject("user", new SignupUserVo());
		return modelAndView;
	}
	
	@PostMapping("/signupHandler")
	public String signupHandler(@Valid @ModelAttribute("user") SignupUserVo user,BindingResult theResult) {
		if (theResult.hasErrors()) {
			return "signup";
		}
		System.out.println(user);
		((UserServices)userService).addNewUser(user);
		return "redirect:/";
	}
}
