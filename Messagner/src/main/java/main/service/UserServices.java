package main.service;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import main.dao.UserRepository;
import main.dto.SignupUserVo;
import main.entity.Profile;
import main.entity.User;
import main.mapper.UserMapper;
import main.vo.SpringUser;

@Service
@AllArgsConstructor
@Transactional
public class UserServices implements UserDetailsService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username)
				.orElseThrow(()->new UsernameNotFoundException("Incorrect Username or Password"));
		return new SpringUser(user);
	}
	
	
	public void addNewUser(SignupUserVo user) {
		User theUser= userMapper.voToEntity(user);
		Profile profile= theUser.getProfile();
		profile.setUser(theUser);
		userRepository.save(theUser);
	}

}
