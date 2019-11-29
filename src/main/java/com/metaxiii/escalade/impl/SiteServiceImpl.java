package com.metaxiii.escalade.impl;

import com.metaxiii.escalade.model.Site;
import com.metaxiii.escalade.repository.SiteRepository;
import com.metaxiii.escalade.service.ISiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SiteServiceImpl implements ISiteService {
    private final SiteRepository siteRepository;

    @Override
    public List<Site> findAllSite() {
        return siteRepository.findAll();
    }
}
