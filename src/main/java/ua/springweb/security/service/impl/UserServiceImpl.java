package ua.springweb.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.springweb.security.entity.UserEntity;
import ua.springweb.security.repository.UserRepository;
import ua.springweb.security.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(UserEntity entity) {
		String password = entity.getPassword();
		System.out.println("BEFORE: " + password);
		
		entity.setPassword(passwordEncoder.encode(password));
		System.out.println("AFTER: " + entity.getPassword());
		
		userRepository.save(entity);
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

}
