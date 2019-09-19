package com.metaxiii.escalade.model;

import lombok.Getter;
import lombok.Setter;

public class Sites {
    @Getter
    @Setter
    private long site;
    @Getter
    @Setter
    private String pays;
    @Getter
    @Setter
    private String codePostal;
    @Getter
    @Setter
    private String nom_site;
    @Getter
    @Setter
    private int voies;
    @Getter
    @Setter
    private String cotation;
    @Getter
    @Setter
    private int secteurs;
    @Getter
    @Setter
    private boolean officiel;
}
