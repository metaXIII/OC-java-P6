package com.metaxiii.escalade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Getter
    @Setter
    @Column(name = "id")
    private short id;

    @Getter
    @Setter
    @Column(name = "role")
    private String role;
}
