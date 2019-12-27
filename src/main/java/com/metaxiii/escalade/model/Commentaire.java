package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "Commentaire")
public class Commentaire {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Date date;

    @Column(name = "userId")
    private int userId;

    @Column(name = "siteId")
    private int siteId;
}
