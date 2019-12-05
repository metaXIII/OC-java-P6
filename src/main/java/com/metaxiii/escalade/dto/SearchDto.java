package com.metaxiii.escalade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchDto {
    private int secteur;
    private int departement;
    private String type;
    private boolean officiel;
}
