package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Secteurs")
public class Secteurs {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "site_id")
    private int site;

    @Column(name = "departement_id")
    private int departement;
}
