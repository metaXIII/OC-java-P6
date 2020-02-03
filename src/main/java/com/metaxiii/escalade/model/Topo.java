package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "TOPO")
public class Topo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LIEU")
    private String lieu;

    @Column(name = "DATEPARUTION")
    private Date dateParution;

    @Column(name = "USERID")
    private long userId;

    @Column(name = "AVAILABLE")
    private boolean available;
}
