package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.dto.SearchDto;
import com.metaxiii.escalade.dto.SiteDto;
import com.metaxiii.escalade.model.Site;
import com.metaxiii.escalade.model.Voie;
import com.metaxiii.escalade.repository.SiteRepository;
import com.metaxiii.escalade.service.ISecteurService;
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
    private final SiteRepository  siteRepository;
    private final ISecteurService secteurService;

    @Override
    public List<Site> findAllSite() {
        return siteRepository.findAll();
    }

    @Override
    public Set<Site> findAllBySecteurId(int secteur) {
        return siteRepository.findAllBySecteurId(secteur);
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

    public Set<Site> getResult(SearchDto searchDto) {
        int     secteur     = searchDto.getSecteur();
        int     departement = searchDto.getDepartement();
        String  type        = searchDto.getType();
        boolean officiel    = searchDto.isOfficiel();
        if (secteur != 0 && departement == 0 && type.isEmpty() && !officiel)
            return siteRepository.findAllBySecteurId(searchDto.getSecteur());
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
    public Optional<Site> findById(long id) {
        return siteRepository.findById(id);
    }

    @Override
    public Site save(SiteDto siteDto, long id) {
        Site site = new Site();
        site.setNom(siteDto.getNom());
        site.setDescription(siteDto.getDescription());
        site.setUserId(id);
        site.setSecteurId(secteurService.checkSecteur(siteDto.getSecteur()).getId());
        site.setType(siteDto.getType());
        site.setLatitude(siteDto.getLatitude());
        site.setLongitude(siteDto.getLongitude());
        return siteRepository.save(site);
    }

    @Override
    public String calculateCotation(List<Voie> voiesList) {
        int moyenne = 0;
        for (Voie voie : voiesList) {
            moyenne += position(voie.getCotation());
        }
        if (moyenne > 0) {
            return position(moyenne / voiesList.size());
        } else
            return "";
    }

    private int position(String el) {
        int result = 0;
        switch (el) {
            case "3":
                result = 1;
                break;
            case "3+":
                result = 2;
                break;
            case "4a":
                result = 3;
                break;
            case "4b":
                result = 4;
                break;
            case "4c":
                result = 5;
                break;
            case "5a":
                result = 6;
                break;
            case "5b":
                result = 7;
                break;
            case "5c":
                result = 8;
                break;
            case "6a":
                result = 9;
                break;
            case "6a+":
                result = 10;
                break;
            case "6b":
                result = 11;
                break;
            case "6b+":
                result = 12;
                break;
            case "6c":
                result = 13;
                break;
            case "6c+":
                result = 14;
                break;
            case "7a":
                result = 15;
                break;
            case "7a+":
                result = 16;
                break;
            case "7b":
                result = 17;
                break;
            case "7b+":
                result = 18;
                break;
            case "7c":
                result = 19;
                break;
            case "7c+":
                result = 20;
                break;
            case "8a":
                result = 21;
                break;
            case "8a+":
                result = 22;
                break;
            case "8b":
                result = 23;
                break;
            case "8b+":
                result = 24;
                break;
            case " 8c":
                result = 25;
                break;
            case "8c+":
                result = 26;
                break;
            case "9a":
                result = 27;
                break;
            case "9a+":
                result = 28;
                break;
            case "9b":
                result = 29;
                break;
            case "9b+":
                result = 30;
                break;
            case "9c":
                result = 31;
                break;
            case "9c+":
                result = 32;
                break;
            default:
                break;
        }
        return result;
    }


    private String position(int el) {
        String result;
        switch (el) {
            case 1:
                result = "3";
                break;
            case 2:
                result = "3+";
                break;
            case 3:
                result = "4a";
                break;
            case 4:
                result = "4b";
                break;
            case 5:
                result = "4c";
                break;
            case 6:
                result = "5a";
                break;
            case 7:
                result = "5b";
                break;
            case 8:
                result = "5c";
                break;
            case 9:
                result = "6a";
                break;
            case 10:
                result = "6a+";
                break;
            case 11:
                result = "9b";
                break;
            case 12:
                result = "6b+";
                break;
            case 13:
                result = "6c";
                break;
            case 14:
                result = "6c+";
                break;
            case 15:
                result = "7a";
                break;
            case 16:
                result = "7a+";
                break;
            case 17:
                result = "7b";
                break;
            case 18:
                result = "7b+";
                break;
            case 19:
                result = "7c";
                break;
            case 20:
                result = "7c+";
                break;
            case 21:
                result = "8a";
                break;
            case 22:
                result = "8a+";
                break;
            case 23:
                result = "8b";
                break;
            case 24:
                result = "8b+";
                break;
            case 25:
                result = "8c";
                break;
            case 26:
                result = "8c+";
                break;
            case 27:
                result = "9a";
                break;
            case 28:
                result = "9a+";
                break;
            case 29:
                result = "9b";
                break;
            case 30:
                result = "9b+";
                break;
            case 31:
                result = "9c";
                break;
            case 32:
                result = "9c+";
                break;
            default:
                result = "";
                break;
        }
        return result;
    }
}
