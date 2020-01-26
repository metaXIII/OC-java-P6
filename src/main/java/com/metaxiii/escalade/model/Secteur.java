package com.metaxiii.escalade.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Secteur")
public class Secteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "departementId")
	private int departementId;
}
