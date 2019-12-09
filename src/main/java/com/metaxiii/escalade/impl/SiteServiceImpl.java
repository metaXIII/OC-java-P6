package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.dto.SearchDto;
import com.metaxiii.escalade.model.Site;
import com.metaxiii.escalade.repository.SiteRepository;
import com.metaxiii.escalade.service.ISiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class SiteServiceImpl implements ISiteService {
    private final SiteRepository siteRepository;

    @Override
    public List<Site> findAllSite() {
        return siteRepository.findAll();
    }

    @Override
    public Set<Site> findAllBySecteur(int secteur) {
        return siteRepository.findAllBySecteur(secteur);
    }

    @Override
    public Set<Site> findAllByDepartement(int departement) {
        return siteRepository.findAllByDepartement(departement);
    }

    @Override
    public Set<Site> findAllByType(String type) {
        return siteRepository.findAllByType(type);
    }

    @Override
    public Set<String> findAllType() {
        return siteRepository.findType();
    }

    @Override
    public Set<Site> findAllByOfficiel() {
        return siteRepository.findAllByOfficiel(true);
    }

    @Override
    public Set<Site> findAllByParam(String secteur, String departement, String type, String officiel) {
        return siteRepository.findAllByParam(secteur, departement, type, officiel);
    }

    public Object getResult(SearchDto searchDto) {
        int secteur = searchDto.getSecteur();
        int departement = searchDto.getDepartement();
        String type = searchDto.getType();
        boolean officiel = searchDto.isOfficiel();
        if (secteur != 0 && departement == 0 && type.isEmpty() && !officiel)
            return siteRepository.findAllBySecteur(searchDto.getSecteur());
        else if (secteur == 0 && departement != 0 && type.isEmpty() && !officiel)
            return siteRepository.findAllByDepartement(searchDto.getDepartement());
        else if (secteur == 0 && departement == 0 && !type.isEmpty() && !officiel)
            return siteRepository.findAllByType(searchDto.getType());
        else if (secteur == 0 && departement == 0 && type.isEmpty() && officiel)
            return siteRepository.findAllByOfficiel(true);
        else {
            return siteRepository.findAllByParam(
                    getSQLParam(secteur),
                    getSQLParam(departement),
                    getSQLParam(type),
                    getSQLParam(officiel)
            );
        }
    }

    public String getSQLParam(int element) {
        if (element == 0)
            return "%";
        return String.valueOf(element);
    }

    public String getSQLParam(String element) {
        if (element.isEmpty())
            return "%";
        return element;
    }

    @Override
    public String getSQLParam(boolean element) {
        if (!element)
            return "%";
        return "1";
    }

    @Override
    public Optional<Site> findById(Long id) {
        return siteRepository.findById(id);
    }
}
