package com.metaxiii.escalade.enums;

public enum Role {
    ROLE_ANONYMOUS(0, "anonyme"),
    ROLE_USER(1, "USER"),
    ROLE_ADMIN(2, "ADMIN");


    private int    roleId;
    private String member;

    Role(int roleId, String member) {
        this.roleId = roleId;
        this.member = member;
    }

    public String getRole() {
        return member;
    }
}
