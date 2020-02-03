package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "COMMENTAIRE")
public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "DATE")
	private Date date;

	@Column(name = "USERID")
	private long userId;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "SITEID")
	private int siteId;
}
