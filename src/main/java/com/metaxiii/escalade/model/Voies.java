package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "voies")
public class Voies {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "cotation")
    private String cotation;

    @Column(name = "secteur_id")
    private int secteur_id;
}
