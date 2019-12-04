package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.model.Site;
import com.metaxiii.escalade.repository.SiteRepository;
import com.metaxiii.escalade.service.ISiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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
}
