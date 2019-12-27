package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Reservation")
public class Reservation {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "topoId")
    private int topoId;

    @Column(name = "requestUserId")
    private int requestUserId;
}
