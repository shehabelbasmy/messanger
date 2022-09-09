package main.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import main.dao.UserRepository;
import main.entity.User;
import main.vo.SpringUser;

@Service
@AllArgsConstructor
public class UserServices implements UserDetailsService {

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username)
				.orElseThrow(()->new UsernameNotFoundException("Incorrect Username or Password"));
		return new SpringUser(user);
	}

}
