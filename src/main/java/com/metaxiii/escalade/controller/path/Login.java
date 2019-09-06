package com.metaxiii.escalade.controller.path;

import com.metaxiii.escalade.controller.AbstractState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login extends AbstractState {
    @RequestMapping("/login/new-user")
    public String create_user(Model model) {
        return "login";
    }

    @RequestMapping("/login/login")
    public String connect_user(Model model) {
        return "login";
    }
}
