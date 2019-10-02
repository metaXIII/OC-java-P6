package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Departement")
public class Departement implements Serializable {
    @Id
    @Column(name = "id")
    private int id;

    @Id
    @Column(name = "departement")
    private String departement;
}
