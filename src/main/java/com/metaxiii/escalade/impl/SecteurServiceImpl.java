package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.model.Secteur;
import com.metaxiii.escalade.repository.SecteurRepository;
import com.metaxiii.escalade.service.ISecteurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
}
