package com.metaxiii.escalade.model;

import lombok.Data;

@Data
public class UserSession {
    private String username;
    private String email;
    private Role role;
    private boolean isConnected;
}
