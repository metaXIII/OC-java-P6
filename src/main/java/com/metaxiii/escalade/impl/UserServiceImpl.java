package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.dto.UserDto;
import com.metaxiii.escalade.exceptions.UserAlreadyExistException;
import com.metaxiii.escalade.model.User;
import com.metaxiii.escalade.repository.UserRepository;
import com.metaxiii.escalade.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException {
        if (emailExist(accountDto.getEmail()))
            throw new UserAlreadyExistException("There is an account with that email adress : " + accountDto.getEmail());
        final User user = new User();
        user.setUsername(accountDto.getUsername());
        user.setEmail(accountDto.getEmail());
        user.setPassword(accountDto.getPassword());
        user.setRole(accountDto.getRole());
        return userRepository.save(user);
    }

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

}