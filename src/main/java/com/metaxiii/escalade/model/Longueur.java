package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Longueur")
public class Longueur {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "siteId")
    private int siteId;

    @Column(name = "cotation")
    private String cotation;
}
