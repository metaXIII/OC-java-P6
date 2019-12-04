package com.metaxiii.escalade.service;

import com.metaxiii.escalade.model.Site;

import java.util.List;
import java.util.Set;

public interface ISiteService {
    List<Site> findAllSite();

    Set<String> findAllType();
}
