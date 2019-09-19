package com.metaxiii.escalade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table (name = "topo")
public class Topo {
    @Getter
    @Setter
    @Id
    @Column(name = "id")
    private long id;

    @Getter
    @Setter
    @Column (name = "nom")
    private String nom;

    @Getter
    @Setter
    @Column (name = "description")
    private String description;

    @Getter
    @Setter
    @Column (name = "lieu")
    private String lieu;

    @Getter
    @Setter
    @Column (name = "date_parution")
    private Date date_parution;

    @Getter
    @Setter
    @Column (name = "user_id")
    private int user_id;

    @Getter
    @Setter
    @Column (name = "available")
    private boolean available;
}
