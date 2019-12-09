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
    private Long id;

    @Column(name = "site_id")
    private int site_id;

    @Column(name = "cotation")
    private String cotation;
}
