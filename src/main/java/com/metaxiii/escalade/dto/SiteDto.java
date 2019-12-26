package com.metaxiii.escalade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SiteDto {
    private String nom;
    private String description;
    private String secteur;
    private int departement;
    private String type;
    private String cotation;
    private String longitude;
    private String latitude;
}
