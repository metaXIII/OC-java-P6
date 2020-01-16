package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "topoId")
    private long topoId;

    @Column(name = "requestUserId")
    private long requestUserId;
}
