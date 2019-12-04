package com.metaxiii.escalade.repository;

import com.metaxiii.escalade.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    List<Site> findAll();
    List<Site> findAllBySecteur(int secteur);

    List<Site> findAllByOfficiel(char officiel);

    List<Site> findAllByType(String type);

    List<Site> findAllByPays(String pays);

    @Query(value = "select distinct Site.type from Site", nativeQuery = true)
    Set<String> findType();
}
