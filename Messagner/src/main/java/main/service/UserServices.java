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
import main.entity.Person;
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
		Person user = userRepository.findByEmail(username)
				.orElseThrow(()->new UsernameNotFoundException("Incorrect Username or Password"));
		return new SpringUser(user);
	}
	
	
	public void addNewUser(SignupUserVo person) {
		Person thePerson= userMapper.voToEntity(person);
		Profile profile= thePerson.getProfile();
		profile.setPerson(thePerson);
		userRepository.save(thePerson);
	}

}
