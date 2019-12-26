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

    @Column(name = "topo_id")
    private int topo_id;

    @Column(name = "request_user_id")
    private int request_user_id;
}
