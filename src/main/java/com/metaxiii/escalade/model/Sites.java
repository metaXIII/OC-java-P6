package com.metaxiii.escalade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sites")
public class Sites {
    @Getter
    @Setter
    @Id
    @Column(name = "id")
    private long id;
    @Getter
    @Setter
    @Column(name = "pays")
    private String pays;
    @Getter
    @Setter
    @Column(name = "codePostal")
    private String codePostal;
    @Getter
    @Setter
    @Column(name = "nom_site")
    private String nom_site;
    @Getter
    @Setter
    @Column(name = "voies")
    private int voies;
    @Getter
    @Setter
    @Column(name = "cotation")
    private String cotation;
    @Getter
    @Setter
    @Column(name = "secteurs")
    private int secteurs;
    @Getter
    @Setter
    @Column(name = "officiel")
    private boolean officiel;
}
