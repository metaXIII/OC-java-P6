package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Account {
    @RequestMapping("/account")
    public String account() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("");
        return "account";
    }

    @RequestMapping("/account/new-site")
    public ModelAndView new_site(Model model) {
        return new ModelAndView("index");
    }
}
