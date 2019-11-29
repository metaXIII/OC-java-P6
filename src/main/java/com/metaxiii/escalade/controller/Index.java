package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class Index {
    @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/welcome")
    public ModelAndView welcome() {
        return new ModelAndView("index", "welcome", userService.toString());
    }
}
