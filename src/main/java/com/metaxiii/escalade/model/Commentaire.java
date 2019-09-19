package com.metaxiii.escalade.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Commentaire {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String content;
    @Getter
    @Setter
    private Date date;
    @Getter
    @Setter
    private int user_id;
    @Getter
    @Setter
    private int site_id;
}
