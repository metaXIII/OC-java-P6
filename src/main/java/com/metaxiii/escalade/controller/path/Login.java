package com.metaxiii.escalade.controller.path;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {

    @RequestMapping("/login/new-user")
    public String create_user(Model model) {
        model.addAttribute("user", "new");
        return "login";
    }

    @RequestMapping("/login/login")
    public String connect_user(Model model) {
        model.addAttribute("user", "login");
        return "login";
    }

    @RequestMapping("/forget-password")
    public String forget_password() {
        return "forget-password";
    }
}
