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

    public Secteur checkSecteur(String siteDtoGetSecteur) {
        Secteur secteur = new Secteur();
        String[] secteurs = siteDtoGetSecteur.split(" - ");
        if (secteurs.length > 1) {
            secteur.setNom(secteurs[1]);
            secteur.setDepartementId(Integer.parseInt(secteurs[0]));
            return secteurRepository.save(secteur);
        } else {
            Optional<Secteur> SecteurFromDatabase = secteurRepository.findById(Integer.parseInt(secteurs[0]));
            if (SecteurFromDatabase.isPresent()) {
                secteur.setId(SecteurFromDatabase.get().getId());
                secteur.setDepartementId(SecteurFromDatabase.get().getDepartementId());
                secteur.setNom(SecteurFromDatabase.get().getNom());
            }
            return secteur;
        }
    }
}
