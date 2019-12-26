package com.metaxiii.escalade.service;

import com.metaxiii.escalade.dto.SearchDto;
import com.metaxiii.escalade.dto.SiteDto;
import com.metaxiii.escalade.model.Site;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ISiteService {
    List<Site> findAllSite();

    Set<Site> findAllBySecteur(int secteur);

    Set<Site> findAllByDepartement(int departement);

    Set<Site> findAllByType(String type);

    Set<String> findAllType();

    Set<Site> findAllByOfficiel();

    Set<Site> findAllByParam(String secteur, String departement, String type, String officiel);

    Object getResult(SearchDto searchDto);

    String getSQLParam(int element);

    String getSQLParam(String element);

    String getSQLParam(boolean element);

    Optional<Site> findById(int id);

    Site save(SiteDto siteDto, int id);
}
