package ua.springweb.security.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.springweb.security.domain.RegisterRequest;
import ua.springweb.security.entity.UserEntity;
import ua.springweb.security.entity.enumeration.Role;

public interface UserMapper {

	public static User toSecurityUser(UserEntity entity) {
		return new User(
				entity.getEmail(),
				entity.getPassword(),
				AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole()))
				);
	}
	
	public static UserEntity registerToUser(RegisterRequest request) {
		UserEntity user = new UserEntity();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole(Role.ROLE_USER);
		user.setAge(request.getAge());
		return user;
	}
	
}
