package com.metaxiii.escalade.model;

import lombok.Getter;
import lombok.Setter;

public class Reservation {
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private int topo_id;

    @Getter
    @Setter
    private int request_user_id;
}
