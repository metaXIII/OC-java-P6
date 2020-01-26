package com.metaxiii.escalade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SiteDto {
	private String nom;
	private String description;
	private String secteur;
	private String type;
	private String longitude;
	private String latitude;
	private int    departement;
}
