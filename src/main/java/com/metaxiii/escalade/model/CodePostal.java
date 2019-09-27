package com.metaxiii.escalade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "code_postal")
public class CodePostal implements Serializable {
    @Getter
    @Setter
    @Id
    @Column (name = "id")
    private byte id;

    @Getter
    @Setter
    @Id
    @Column (name = "departement")
    private String departement;
}
