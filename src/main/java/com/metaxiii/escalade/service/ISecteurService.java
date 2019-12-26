package com.metaxiii.escalade.service;

import com.metaxiii.escalade.model.Secteur;

import java.util.List;
import java.util.Optional;

public interface ISecteurService {
    List<Secteur> findAllSecteur();

    Optional<Secteur> findById(int id);

    Optional<Secteur> findByName(String name);

    void save(Secteur secteur);
}
