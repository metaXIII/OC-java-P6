package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.enums.Role;
import org.springframework.security.core.context.SecurityContextHolder;

public class AbstractState {
    protected Object isConnected() {
        return SecurityContextHolder.getContext().getAuthentication().getDetails();
    }

    protected String getRole() {
        String security = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        return definedRole(security);
    }

    private String definedRole(String role) {
        switch (role) {
            case "[USER]":
                break;
                //todo
            case "[ROLE_ANONYMOUS]":
            default:
                role = Role.ROLE_ANONYMOUS.getRole();
                break;
        }
        return role;
    }
}