package com.metaxiii.escalade.service;

import com.metaxiii.escalade.model.Site;

import java.util.List;
import java.util.Set;

public interface ISiteService {
    List<Site> findAllSite();

    Set<Site> findAllBySecteur(int secteur);

    Set<Site> findAllByDepartement(int departement);

    Set<Site> findAllByType(String type);

    Set<String> findAllType();

    Set<Site> findAllByOfficiel();

}
