package com.metaxiii.escalade.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table(name = "Site")
public class Site {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "pays")
    private String pays;

    @Column(name = "code_postal_id")
    private String codePostal;

    @Column(name = "nom_site")
    private String nom_site;

    @Column(name = "officiel")
    private boolean officiel;

    @Column(name = "secteurs")
    private String secteurs;
}
