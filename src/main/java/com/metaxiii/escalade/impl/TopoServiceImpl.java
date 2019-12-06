package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.model.Topo;
import com.metaxiii.escalade.repository.TopoRepository;
import com.metaxiii.escalade.service.ITopoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TopoServiceImpl implements ITopoService {
    private final TopoRepository topoRepository;

    @Override
    public List<Topo> findAllTopos() {
        return topoRepository.findAll();
    }

    @Override
    public Optional<Topo> findById(Long id) {
        return topoRepository.findById(id);
    }

    @Override
    public void updateAvailableById(Long id, boolean available) {
        topoRepository.updateTopo(id, available);
    }
}
