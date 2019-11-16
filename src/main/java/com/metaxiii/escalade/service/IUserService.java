package com.metaxiii.escalade.service;

import com.metaxiii.escalade.dto.UserDto;
import com.metaxiii.escalade.exceptions.UserAlreadyExistException;
import com.metaxiii.escalade.model.User;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;
}
