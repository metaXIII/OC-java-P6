package com.metaxiii.escalade.service;

import com.metaxiii.escalade.model.Topo;

import java.util.List;
import java.util.Optional;

public interface ITopoService {
    List<Topo> findAllTopos();

    Optional<Topo> findById(Long id);

    void updateAvailableById(Long id, boolean available);
}
