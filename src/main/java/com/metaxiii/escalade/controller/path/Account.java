package com.metaxiii.escalade.controller.path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Account {
    @RequestMapping("/account")
    public String account() {
        return "account";
    }
}
