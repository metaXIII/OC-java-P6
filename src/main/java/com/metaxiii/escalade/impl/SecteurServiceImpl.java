package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.dto.SecteurDto;
import com.metaxiii.escalade.model.Secteur;
import com.metaxiii.escalade.repository.SecteurRepository;
import com.metaxiii.escalade.service.ISecteurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SecteurServiceImpl implements ISecteurService {
    @Autowired
    private final SecteurRepository secteurRepository;

    @Override
    public List<Secteur> findAllSecteur() {
        return secteurRepository.findAll();
    }

    @Override
    public Optional<Secteur> findById(int id) {
        return secteurRepository.findById(id);
    }

    @Override
    public Optional<Secteur> findByName(String name) {
        return secteurRepository.findByNom(name);
    }

    @Override
    public Secteur save(Secteur secteur) {
        return secteurRepository.save(secteur);
    }

    public Secteur checkSecteur(String secteur) {
        Secteur secteur = new Secteur();
        String[] secteurs = siteDto.getSecteur().split(" - ");
        secteur.setDepartement_id(Integer.parseInt(secteurs[0]));
        String secteurName = secteurs[1];
        Optional<Secteur> SecteurFromDatabase = secteurService.findByName(secteurName);
        if (SecteurFromDatabase.isPresent()) {
            secteur.setDepartement_id(SecteurFromDatabase.get().getDepartement_id());
        } else {
            secteur.setNom(secteurName);
            site.setSecteur(secteurRepository.save(secteur).getId());
        }
    }
}
