package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Code_postal")
public class CodePostal implements Serializable {
    @Id
    @Column(name = "id")
    private byte id;

    @Column(name = "departement")
    private String departement;
}
