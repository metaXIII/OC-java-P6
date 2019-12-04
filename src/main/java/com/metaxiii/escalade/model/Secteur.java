package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Secteur")
public class Secteur {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "departement_id")
    private int departement_id;
}
