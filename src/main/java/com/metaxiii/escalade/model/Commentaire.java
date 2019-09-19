package com.metaxiii.escalade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "commentaire")
public class Commentaire {
    @Getter
    @Setter
    @Id
    @Column(name = "id")
    private long id;

    @Getter
    @Setter
    @Column (name = "content")
    private String content;

    @Getter
    @Setter
    @Column (name = "date")
    private Date date;

    @Getter
    @Setter
    @Column (name = "user_id")
    private int user_id;

    @Getter
    @Setter
    @Column (name = "site_id")
    private int site_id;
}
