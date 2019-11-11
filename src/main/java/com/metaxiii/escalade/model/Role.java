package com.metaxiii.escalade.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "role")
@AllArgsConstructor
public class Role {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "role")
    private String role;
}
