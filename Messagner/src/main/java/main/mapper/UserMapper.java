package main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import main.dto.SignupUserVo;
import main.entity.Person;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract  class UserMapper {

	@Autowired
	protected PasswordEncoder passwordEncoder;
	
	@Mapping(target = "password",expression = "java(passwordEncoder.encode(newUser.getPassword()))")
	@Mapping(target = "profile.lastName",source =  "lastName")
	@Mapping(target = "profile.firstName",source =  "firstName")
	@Mapping(target = "profile.birthDate",source =  "birthDate")
	@Mapping(target = "profile.gender",source =  "gender")
	@Mapping(target = "role",expression = "java(main.enums.Role.USER)")
	public abstract Person voToEntity(SignupUserVo newUser);
}
