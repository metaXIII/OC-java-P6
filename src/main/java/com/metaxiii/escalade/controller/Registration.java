package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.UserDto;
import com.metaxiii.escalade.exceptions.UserAlreadyExistException;
import com.metaxiii.escalade.model.User;
import com.metaxiii.escalade.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class Registration {

    @Autowired
    private IUserService userService;

    @GetMapping("/user/new-user")
    public String create_user(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "user";
    }

    @GetMapping("/user/login")
    public String connect_user(Model model) {
        UserDto userDto = new UserDto();
        userDto.setUsername("aze");
        model.addAttribute("user", userDto);
        return "user";
    }

    @GetMapping("/forget-password")
    public String forget_password() {
        return "forget-password";
    }

    @PostMapping(value = "/user/new-user")
    public ModelAndView post_create_user(@ModelAttribute("user") UserDto accountDto,
                                         BindingResult result, WebRequest request, Errors errors) {
        User register = new User();
        if (!result.hasErrors()) {
            register = createUserAccount(accountDto, result);
        }
        if (register == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors())
            return new ModelAndView("user", "user", accountDto);
        else
            return new ModelAndView("index");
    }

    private User createUserAccount(UserDto accountDto, BindingResult result) {
        User registered;
        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (UserAlreadyExistException e) {
            Set<String> errors = new HashSet<>();
            errors.add("L'email existe déjà dans la base de donnée");
            accountDto.setErrors(errors);
            return null;
        }
        return registered;
    }
}
