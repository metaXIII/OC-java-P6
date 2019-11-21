package com.metaxiii.escalade.enums;

public enum Role {
    ROLE_ANONYMOUS(1, "anonyme");

    private int role_id;
    private String role;

    Role(int role_id, String role) {
        this.role_id = role_id;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public int getRole_id() {
        return role_id;
    }

}
