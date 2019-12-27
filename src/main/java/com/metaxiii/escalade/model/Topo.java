package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "Topo")
public class Topo {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "lieu")
    private String lieu;

    @Column(name = "dateParution")
    private Date dateParution;

    @Column(name = "userId")
    private int userId;

    @Column(name = "available")
    private boolean available;
}
