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
    private Long id;

    @Column(name = "pays")
    private String pays;

    @Column(name = "nom")
    private String nom;

    @Column(name = "secteur_id")
    private int secteur;

    @Column(name = "officiel")
    private boolean officiel;

    @Column(name = "type")
    private String type;
}
