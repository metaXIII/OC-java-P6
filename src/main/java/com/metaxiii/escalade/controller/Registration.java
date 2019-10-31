package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.UserDto;
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
        model.addAttribute("user", "login");
        return "user";
    }

    @GetMapping("/forget-password")
    public String forget_password() {
        return "forget-password";
    }

    @PostMapping(value = "/user/new-user")
    public String post_create_user(@ModelAttribute("user") UserDto accountDto,
                                   BindingResult result, WebRequest request, Errors errors) {
        User user = new User();
        try {
            user = createUserAccount(accountDto, result);

        } catch (Exception exception) {
            System.out.println("Request: " + request);
            System.out.println("Errors : " + errors);
            System.out.println("Exception: " + exception.getMessage());
        }
        System.out.println("User is connected" + user);
        return "index";
    }

    private User createUserAccount(UserDto accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (Exception e) {
            System.out.println("There is an exception");
        }
        System.out.println("result : " + result);
        return registered;
    }
}
