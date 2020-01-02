package com.metaxiii.escalade.enums;

public enum Message {
    BONJOUR("Bonjour "),
    SAVE_SITE("Tout s'est bien passé ! merci pour votre participation !"),
    SITE_NOT_FOUND("Le lien vers le site n'a pas été trouvé !"),
    GLOBAL_ERROR("Une erreur s'est produite ! Désolé !"),
    LONGUEUR_ADD("Le site a bien été ajouté");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
