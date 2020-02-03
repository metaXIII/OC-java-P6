package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @ManyToOne()
    @JoinColumn(name = "TOPOID")
    private Topo topo;

    @ManyToOne()
    @JoinColumn(name = "REQUESTUSERID")
    private User requestUserId;

    @Column(name = "PROGRESS")
    private boolean progress;
}
