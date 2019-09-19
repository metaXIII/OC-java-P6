package com.metaxiii.escalade.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Topo {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String nom;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String lieu;
    @Getter
    @Setter
    private Date date_parution;
    @Getter
    @Setter
    private int user_id;
    @Getter
    @Setter
    private boolean available;
}
