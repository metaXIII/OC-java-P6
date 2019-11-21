package com.metaxiii.escalade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index extends AbstractState {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index", "userCache", getRole());
    }
}
