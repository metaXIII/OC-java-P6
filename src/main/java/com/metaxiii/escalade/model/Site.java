package com.metaxiii.escalade.model;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "SITE")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SECTEURID")
    private int secteurId;

    @Column(name = "USERID")
    private long userId;

    @Column(name = "OFFICIEL")
    private boolean officiel;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "LATITUDE")
    private String latitude;

    @Column(name = "LONGITUDE")
    private String longitude;
}
