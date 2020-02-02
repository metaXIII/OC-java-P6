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

    @ManyToOne()
    @JoinColumn(name = "topoId")
    private Topo topo;

    @ManyToOne()
    @JoinColumn(name = "requestUserId")
    private User requestUserId;

    @Column(name = "progress")
    private boolean progress;
}
