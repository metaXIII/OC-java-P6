package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.model.Departement;
import com.metaxiii.escalade.model.Site;
import com.metaxiii.escalade.repository.DepartementRepository;
import com.metaxiii.escalade.repository.SiteRepository;
import com.metaxiii.escalade.service.IDepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartementServiceImpl implements IDepartementService {
    private final DepartementRepository departementRepository;

    @Override
    public List<Departement> findAllDepartement() {
        return departementRepository.findAll();
    }
}
