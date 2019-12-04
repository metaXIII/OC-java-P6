package com.metaxiii.escalade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class SearchDto {
    @NotNull
    @NotEmpty
    private String element;
    private String secteur;
    private int departement;
    private String type;
    private char officiel;
}
