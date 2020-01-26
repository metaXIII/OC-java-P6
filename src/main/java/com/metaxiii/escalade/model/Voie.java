package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Voie")
public class Voie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "longueurId")
	private int longueurId;

	@Column(name = "cotation")
	private String cotation;
}
