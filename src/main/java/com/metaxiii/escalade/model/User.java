package com.metaxiii.escalade.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class User {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String mail;
    @Getter
    @Setter
    private List<Topo> topo;
    @Getter
    @Setter
    private boolean banned;
    @Getter
    @Setter
    private int Secure;
    @Getter
    @Setter
    private boolean isConnected;
    @Getter
    @Setter
    private String role;
}
