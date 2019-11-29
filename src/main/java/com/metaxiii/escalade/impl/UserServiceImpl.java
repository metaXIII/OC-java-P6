package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.dto.UserDto;
import com.metaxiii.escalade.exceptions.UserAlreadyExistException;
import com.metaxiii.escalade.model.Role;
import com.metaxiii.escalade.model.User;
import com.metaxiii.escalade.repository.UserRepository;
import com.metaxiii.escalade.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements IUserService, UserDetailsService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException {
		if (emailExist(accountDto.getEmail()))
			throw new UserAlreadyExistException("Il exite déjà un utilisateur avec cette adresse mail : " + accountDto.getEmail());
		if (userExist(accountDto.getUsername())) {
			throw new UserAlreadyExistException("Ce nom d'utilisateur est déjà utilisé : " + accountDto.getUsername());
		}
		final User user = new User();
		user.setUsername(accountDto.getUsername());
		user.setEmail(accountDto.getEmail());
		user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
		user.setRole(new Role(1, "USER"));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Il n'existe pas d'utilisateurs avec le nom d'utilisateur " + username));
	}

	private boolean emailExist(String email) {
		return userRepository.findByEmail(email) != null;
	}

	private boolean userExist(String username) {
		return userRepository.findByUsername(username).isPresent();
	}

}
