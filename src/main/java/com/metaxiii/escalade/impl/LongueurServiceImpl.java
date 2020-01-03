package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.dto.LongueurDto;
import com.metaxiii.escalade.model.Longueur;
import com.metaxiii.escalade.model.Voie;
import com.metaxiii.escalade.repository.LongueurRepository;
import com.metaxiii.escalade.service.ILongueurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LongueurServiceImpl implements ILongueurService {
    private final LongueurRepository longueurRepository;

    @Autowired
    private VoieServiceImpl voieService;

    @Override
    public List<Longueur> findAllBySiteId(int id) {
        return longueurRepository.findAllBySiteId(id);
    }

    @Override
    public void saveLongueur(LongueurDto longueurDto, int id) {
        List<Voie> voieList = new ArrayList<>();
        Longueur longueur = new Longueur();
        longueur.setSiteId(id);
        longueur.setCotation(longueurDto.getCotation());
        longueurDto.setId(longueurRepository.save(longueur).getId());
        for (int i = 0; i < longueurDto.getVoies(); i++) {
            Voie voie = new Voie();
            voie.setCotation(longueur.getCotation());
            voie.setLongueurId(longueurDto.getId());
            voieList.add(voie);
            voieService.save(voie);
        }
    }
}
