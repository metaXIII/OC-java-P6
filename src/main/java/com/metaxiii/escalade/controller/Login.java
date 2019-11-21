package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.UserDto;
import com.metaxiii.escalade.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class Login {
    @Autowired
    private IUserService userService;

    @GetMapping("/logout")
    public ModelAndView logout(Model model) {
        return new ModelAndView("index", "user", userService.toString());
    }

    @GetMapping("/user/login")
    public ModelAndView connect_user(Model model) {
        return new ModelAndView("login");
    }

    @PostMapping("/user/login")
    public ModelAndView connect_user(UserDto userDto) {
        System.out.println("aze");
        return new ModelAndView("index");
    }
}
