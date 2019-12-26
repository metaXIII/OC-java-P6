package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.SiteDto;
import com.metaxiii.escalade.model.User;
import com.metaxiii.escalade.service.IDepartementService;
import com.metaxiii.escalade.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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
}
