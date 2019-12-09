package com.metaxiii.escalade.enums;

public enum Message {
    BONJOUR("Bonjour "),
    SITE_NOT_FOUND("Le lien vers le site n'a pas été trouvé !");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
