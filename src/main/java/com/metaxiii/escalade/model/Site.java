package com.metaxiii.escalade.model;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "Site")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "secteur_id")
    private int secteur;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "officiel")
    private boolean officiel;

    @Column(name = "type")
    private String type;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;
}
