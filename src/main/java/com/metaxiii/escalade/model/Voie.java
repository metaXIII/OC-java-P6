package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "VOIE")
public class Voie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "LONGUEURID")
	private int longueurId;

	@Column(name = "COTATION")
	private String cotation;
}
