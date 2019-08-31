package com.metaxiii.escalade.model;

import java.util.List;

public class User {
    private Long id;
    private String username;
    private String password;
    private String mail;
    private List<Topo> topo;
    private boolean banned;
    private int Secure;
    private boolean isConnected;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Topo> getTopo() {
        return topo;
    }

    public void setTopo(List<Topo> topo) {
        this.topo = topo;
    }

    public int getSecure() {
        return Secure;
    }

    public void setSecure(int secure) {
        Secure = secure;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
}
