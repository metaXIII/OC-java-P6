package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Topo")
public class Topo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "lieu")
    private String lieu;

    @Column(name = "dateParution")
    private Date dateParution;

    @Column(name = "userId")
    private long userId;

    @Column(name = "available")
    private boolean available;
}
