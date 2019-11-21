package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.dto.UserDto;
import com.metaxiii.escalade.exceptions.UserAlreadyExistException;
import com.metaxiii.escalade.model.Role;
import com.metaxiii.escalade.model.User;
import com.metaxiii.escalade.repository.UserRepository;
import com.metaxiii.escalade.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException {
		if (emailExist(accountDto.getEmail()))
			throw new UserAlreadyExistException("There is an account with that email adress : " + accountDto.getEmail());
		final User user = new User();
		user.setUsername(accountDto.getUsername());
		user.setEmail(accountDto.getEmail());
		user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
		user.setRole(new Role(1, "USER"));
		return userRepository.save(user);
	}

	private boolean emailExist(String email) {
		return userRepository.findByEmail(email) != null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username);
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return user;
	}

}
