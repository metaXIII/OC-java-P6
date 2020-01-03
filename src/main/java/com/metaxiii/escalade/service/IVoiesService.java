package com.metaxiii.escalade.service;

import com.metaxiii.escalade.model.Voie;

import java.util.List;

public interface IVoiesService {
    List<Voie> findAllBySiteId(int id);

    void saveAll(List<Voie> voies);

    void save(Voie voie);
}
