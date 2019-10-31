package com.metaxiii.escalade.enums;

public enum Role {
    REGULAR(0),
    ADMIN(1),
    OWNER(2);
    private int value;

    /**
     * @param value
     */
    Role(int value) {
        this.value = value;
    }

    /**
     * @return ENUM
     */
    public int getValue() {
        return this.value;
    }
}
