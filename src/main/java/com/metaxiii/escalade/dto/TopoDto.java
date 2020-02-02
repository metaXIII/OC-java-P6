package com.metaxiii.escalade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TopoDto {
	private String nom;
	private String description;
	private String lieu;
	private String dateParution;
}
