package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.model.Voies;
import com.metaxiii.escalade.repository.VoiesRepository;
import com.metaxiii.escalade.service.IVoiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VoiesServiceImpl implements IVoiesService {
    private final VoiesRepository voiesRepository;

    @Override
    public List<Voies> findAll() {
        return null;
    }
}
