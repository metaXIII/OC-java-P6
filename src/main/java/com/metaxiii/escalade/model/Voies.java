package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Voies")
public class Voies {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "longueurId")
    private int longueurId;

    @Column(name = "cotation")
    private String cotation;
}
