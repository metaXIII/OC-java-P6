package com.metaxiii.escalade.service;

import com.metaxiii.escalade.dto.SearchDto;
import com.metaxiii.escalade.dto.SiteDto;
import com.metaxiii.escalade.model.Site;
import com.metaxiii.escalade.model.Voie;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ISiteService {
    List<Site> findAllSite();

    Set<Site> findAllBySecteurId(int secteur);

    Set<Site> findAllByDepartement(int departement);

    Set<Site> findAllByType(String type);

    Set<String> findAllType();

    Set<Site> findAllByOfficiel();

    Set<Site> findAllByParam(String secteur, String departement, String type, String officiel);

    Set<Site> getResult(SearchDto searchDto);

    String getSQLParam(int element);

    String getSQLParam(String element);

    String getSQLParam(boolean element);

    Optional<Site> findById(long id);

    Site save(SiteDto siteDto, int id);

    String CalculateCotation(List<Voie> voiesList);
}
